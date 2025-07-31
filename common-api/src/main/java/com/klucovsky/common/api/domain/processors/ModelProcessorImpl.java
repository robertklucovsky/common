/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.processors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.klucovsky.common.api.domain.calculators.Calculator;
import com.klucovsky.common.api.domain.calculators.DraftCalculator;
import com.klucovsky.common.api.domain.calculators.ProgressCalculator;
import com.klucovsky.common.api.domain.services.CommandService;
import com.klucovsky.common.api.domain.services.CommonService;
import com.klucovsky.common.api.domain.validation.ValidationWrapper;
import com.klucovsky.common.api.infrastructure.events.EventProducer;
import com.klucovsky.common.constants.enums.RoundType;
import com.klucovsky.common.constants.strings.QueryParamConstants;
import com.klucovsky.common.constants.strings.StringConstants;
import com.klucovsky.common.contract.model.DataModelObject;
import com.klucovsky.common.exception.errors.ValidationError;
import com.klucovsky.common.exception.exceptions.ValidationException;
import com.klucovsky.common.logging.factories.LoggerFactory;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Model processor class to process validation, calculation
 * and storage of input model
 *
 * @param <T> input/output model class {@link DataModelObject}
 */
@Slf4j
@RequiredArgsConstructor(staticName = "getInstance")
public class ModelProcessorImpl<T extends DataModelObject<T>> implements ModelProcessor<T> {

    private final ValidationWrapper<T> validator;
    private final Calculator<T> calculator;
    private final ProgressCalculator<T> progressCalculator;
    private final DraftCalculator<T> draftCalculator;
    private final CommandService<T> commandService;
    private final CommonService<T> commonService;
    private final EventProducer<T> eventProducer;
    private final LoggerFactory loggerFactory;

    /**
     * Validate, calculate and create {@link DataModelObject},
     * return errors and set the object status
     *
     * @param model      {@link DataModelObject}
     * @param allowDraft boolean
     * @return created {@link DataModelObject}
     */
    @Override
    public Mono<T> create(final T model, final boolean allowDraft) {
        return Mono.just(loggerFactory.getJsonLogger(log)
                        .addDebug(QueryParamConstants.ALLOW_DRAFT, allowDraft))
                .flatMap(logger -> validateModel(model, allowDraft)
                        .flatMap(commandService::save)
                        .flatMap(eventProducer::modelCreatedEvent)
                        .doOnError(throwable -> logger
                                .addDebug(StringConstants.MODEL_TO_CREATE, model)
                                .logError("Model creation failed"))
                        .doOnSuccess(createdModel -> logger.addDebug(StringConstants.CREATED_MODEL, createdModel)
                                .log("Model created successfully")));
    }

    /**
     * Validate, calculate and update existing {@link DataModelObject},
     * return errors and set the object status
     *
     * @param id         {@link UUID id} of the original model
     * @param update     updated {@link DataModelObject model}
     * @param allowDraft boolean
     * @return updated {@link DataModelObject}
     */
    @Override
    public Mono<T> update(final UUID id, final T update, final Long concurrencyToken, final boolean allowDraft) {
        return Mono.just(loggerFactory.getJsonLogger(log)
                        .addDebug(QueryParamConstants.ALLOW_DRAFT, allowDraft))
                .flatMap(logger -> validateModel(update, allowDraft)
                        .flatMap(updateModel -> commandService.update(id, updateModel, concurrencyToken))
                        .flatMap(commonService::mapRef)
                        .flatMap(eventProducer::modelUpdatedEvent)
                        .doOnError(throwable -> logger
                                .addDebug(StringConstants.MODEL_TO_UPDATE, update)
                                .logError("Model update failed"))
                        .doOnSuccess(savedModel -> logger.addDebug(StringConstants.UPDATED_MODEL, savedModel)
                                .log("Model updated successfully")));
    }

    /**
     * Validate, calculate and merge two existing {@link DataModelObject},
     * return errors and set the object status
     *
     * @param model      {@link DataModelObject}
     * @param id         id of deleted item
     * @param allowDraft boolean
     * @return merged {@link DataModelObject}
     */
    @Override
    public Mono<T> merge(final T model, final UUID id, final boolean allowDraft) {
        return Mono.just(loggerFactory.getJsonLogger(log)
                        .addDebug(StringConstants.MODEL_ID_TO_DELETE, id)
                        .addDebug(QueryParamConstants.ALLOW_DRAFT, allowDraft))
                .flatMap(logger -> validateModel(model, allowDraft)
                        .flatMap(updatedModel -> commandService.merge(updatedModel, id))
                        .flatMap(commonService::mapRef)
                        .flatMap(mergedModel -> eventProducer.modelMergedEvent(mergedModel, id))
                        .doOnError(throwable -> logger
                                .addDebug(StringConstants.MODEL_TO_UPDATE, model)
                                .logError("Model merge failed"))
                        .doOnSuccess(mergedModel -> logger.addDebug(StringConstants.UPDATED_MODEL, mergedModel)
                                .log("Model update command has been successful")));
    }

    /**
     * Delete (hide) {@link DataModelObject model}
     *
     * @param id id of deleted model
     * @return {@link Boolean success}
     */
    @Override
    public Mono<Boolean> delete(UUID id) {
        return Mono.just(loggerFactory.getJsonLogger(log)
                        .addDebug(StringConstants.MODEL_TO_DELETE, id))
                .flatMap(logger -> commandService.delete(id)
                        .flatMap(result -> eventProducer.modelDeletedEvent(result, id))
                        .doOnError(throwable -> logger.logError("Model update failed"))
                        .doOnSuccess(success -> logger.log("Model updated successfully")));
    }

    /**
     * Process validation and calculation when input associated fields are changed
     *
     * @param model {@link DataModelObject}
     * @return {@code Mono<Void>}
     */
    @Override
    public Mono<Void> processMessageCommand(final T model) {
        return Mono.just(loggerFactory.getJsonLogger(log))
                .flatMap(logger -> Mono.just(model)
                        .flatMap(commonService::mapRef)
                        .flatMap(modelToValidate -> validateLogical(modelToValidate, true)
                                .flatMap(errors -> calculator.calculate(modelToValidate)
                                        .flatMap(calculatedModel ->
                                                validateCalculation(calculatedModel, errors, true))))
                        .flatMap(commandService::save)
                        .doOnError(throwable -> logger
                                .addDebug(StringConstants.MODEL_TO_PROCESS, model)
                                .logError("Model update command failed"))
                        .doOnSuccess(updatedModel -> logger
                                .addDebug(StringConstants.PROCESSED_MODEL, updatedModel)
                                .log("Model update command has been successful")))
                .then();
    }

    /**
     * Process validation and rounded calculation of item without touching the database
     *
     * @param model     {@link DataModelObject}
     * @param roundType RoundType
     * @return calculated price
     */
    @Override
    public Mono<T> calculate(final T model, final RoundType roundType) {
        return Mono.just(loggerFactory.getJsonLogger(log)
                        .addDebug(QueryParamConstants.ALLOW_DRAFT, true))
                .flatMap(logger -> Mono.just(model)
                        .flatMap(commonService::mapRef)
                        .flatMap(modelToValidate -> validateLogical(modelToValidate, true)
                                .flatMap(errors -> calculator.calculateRound(modelToValidate, roundType)
                                        .flatMap(priceCalculatedModel ->
                                                validateCalculation(priceCalculatedModel, errors, true))))
                        .doOnError(throwable -> logger
                                .addDebug(StringConstants.MODEL_TO_CALCULATE, model)
                                .logError("Model calculation failed"))
                        .doOnSuccess(updatedModel -> logger
                                .addDebug(StringConstants.CALCULATED_MODEL, updatedModel)
                                .log("Model calculation has been successful")));
    }

    /**
     * Process validation and calculation of item without touching the database
     *
     * @param model {@link DataModelObject}
     * @return calculated price
     */
    @Override
    public Mono<T> calculate(final T model) {
        return Mono.just(loggerFactory.getJsonLogger(log)
                        .addDebug(QueryParamConstants.ALLOW_DRAFT, true))
                .flatMap(logger -> Mono.just(model)
                        .flatMap(commonService::mapRef)
                        .flatMap(modelToValidate -> validateLogical(modelToValidate, true)
                                .flatMap(errors -> calculator.calculate(modelToValidate)
                                        .flatMap(calculatedModel ->
                                                validateCalculation(calculatedModel, errors, true))))
                        .doOnError(throwable -> logger
                                .addDebug(StringConstants.MODEL_TO_CALCULATE, model)
                                .logError("Model calculation failed"))
                        .doOnSuccess(updatedModel -> logger
                                .addDebug(StringConstants.CALCULATED_MODEL, updatedModel)
                                .log("Model calculation has been successful")));
    }

    private Mono<T> validateModel(final T model, final boolean allowDraft) {
        return Mono.just(model)
                .flatMap(commonService::mapRef)
                .flatMap(modelToValidate -> validateLogical(modelToValidate, allowDraft)
                        .flatMap(errors -> calculator.calculate(modelToValidate)
                                .flatMap(calculatedDto -> validateCalculation(calculatedDto, errors, allowDraft))))
                .flatMap(progressCalculator::calculate);
    }

    private Mono<Set<ValidationError>> validateLogical(final T model, boolean allowDraft) {
        return validator.validateLogical(model)
                .handle((errors, sink) -> {
                    if (hasErrors(errors, allowDraft)) {
                        sink.error(Exceptions.propagate(ValidationException.of(errors)));
                        return;
                    }
                    sink.next(errors);
                });
    }

    private Mono<T> validateCalculation(final T model, final Set<ValidationError> previousErrors, boolean allowDraft) {
        return validator.validateCalculation(model)
                .<Set<ValidationError>>handle((errors, sink) -> {
                    if (hasErrors(errors, allowDraft)) {
                        sink.error(Exceptions.propagate(ValidationException.of(errors)));
                        return;
                    }
                    sink.next(errors);
                })
                .flatMapMany(Flux::fromIterable)
                .concatWith(Flux.fromIterable(previousErrors))
                .collect(Collectors.toSet())
                .flatMap(errors -> draftCalculator.calculate(model, errors))
                .onErrorResume(Mono::error);
    }

    private boolean hasErrors(final Set<ValidationError> errors, boolean allowDraft) {
        return !allowDraft && !errors.isEmpty();
    }
}
