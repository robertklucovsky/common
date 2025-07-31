/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.business;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.klucovsky.common.api.domain.processors.ModelProcessor;
import com.klucovsky.common.api.domain.services.CommandService;
import com.klucovsky.common.api.domain.services.CommonService;
import com.klucovsky.common.constants.enums.RoundType;
import com.klucovsky.common.constants.strings.QueryParamConstants;
import com.klucovsky.common.constants.strings.StringConstants;
import com.klucovsky.common.contract.model.DataModelObject;
import com.klucovsky.common.logging.factories.LoggerFactory;
import org.slf4j.event.Level;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Facade interface to send commands to domain services
 *
 * @param <T> {@link DataModelObject}
 */
@Slf4j
@RequiredArgsConstructor
public abstract class BusinessFacade<T extends DataModelObject<T>> implements ModelProcessor<T> {

    private final CommandService<T> commandService;
    private final CommonService<T> commonService;
    private final ModelProcessor<T> processor;
    private final LoggerFactory loggerFactory;

    /**
     * Find model by id and return objectModel
     *
     * @param id object id {@link UUID}
     * @return this {@link DataModelObject}
     */
    public Mono<T> get(final UUID id) {
        loggerFactory.getJsonLogger(log)
                .addAction(Level.TRACE)
                .addTrace(StringConstants.ID, id)
                .log(Level.TRACE);
        return commonService.find(id);
    }

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
        loggerFactory.getJsonLogger(log)
                .addAction(Level.TRACE)
                .addTrace(StringConstants.MODEL_TO_CREATE, model)
                .addTrace(QueryParamConstants.ALLOW_DRAFT, allowDraft)
                .log(Level.TRACE);
        return processor.create(model, allowDraft);
    }

    /**
     * Validate, calculate and update existing {@link DataModelObject},
     * return errors and set the object status
     *
     * @param id               {@link UUID id} of the original model
     * @param update           updated {@link DataModelObject model}
     * @param concurrencyToken entity version in db
     * @param allowDraft       boolean
     * @return updated {@link DataModelObject}
     */
    @Override
    public Mono<T> update(final UUID id, final T update, final Long concurrencyToken, final boolean allowDraft) {
        loggerFactory.getJsonLogger(log)
                .addAction(Level.TRACE)
                .addTrace(StringConstants.MODEL_TO_UPDATE, update)
                .addTrace(QueryParamConstants.ALLOW_DRAFT, allowDraft)
                .log(Level.TRACE);
        return processor.update(id, update, concurrencyToken, allowDraft);
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
        loggerFactory.getJsonLogger(log)
                .addAction(Level.TRACE)
                .addTrace(StringConstants.MODEL_TO_MERGE, model)
                .addTrace(StringConstants.MODEL_ID_TO_DELETE, id)
                .addTrace(QueryParamConstants.ALLOW_DRAFT, allowDraft)
                .log(Level.TRACE);
        return processor.merge(model, id, allowDraft);
    }

    /**
     * Delete (hide) {@link DataModelObject model}
     *
     * @return {@link Boolean success}
     */
    public Mono<Boolean> delete(final UUID id) {
        loggerFactory.getJsonLogger(log)
                .addAction(Level.TRACE)
                .addTrace(StringConstants.MODEL_ID_TO_DELETE, id)
                .log(Level.TRACE);
        return commandService.delete(id);
    }

    /**
     * Process validation and calculation when input associated fields are changed
     *
     * @param model {@link DataModelObject}
     * @return void
     */
    @Override
    public Mono<Void> processMessageCommand(final T model) {
        loggerFactory.getJsonLogger(log)
                .addAction(Level.TRACE)
                .addTrace(StringConstants.MODEL_TO_PROCESS, model)
                .log(Level.TRACE);
        return processor.processMessageCommand(model);
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
        loggerFactory.getJsonLogger(log)
                .addAction(Level.TRACE)
                .addTrace(StringConstants.MODEL_TO_CALCULATE, model)
                .addTrace(StringConstants.ROUND_TYPE, roundType)
                .log(Level.TRACE);
        return processor.calculate(model, roundType);
    }

    /**
     * Process validation and calculation of item without touching the database
     *
     * @param model {@link DataModelObject}
     * @return calculated price
     */
    @Override
    public Mono<T> calculate(final T model) {
        loggerFactory.getJsonLogger(log)
                .addAction(Level.TRACE)
                .addTrace(StringConstants.MODEL_TO_CALCULATE, model)
                .log(Level.TRACE);
        return processor.calculate(model);
    }
}
