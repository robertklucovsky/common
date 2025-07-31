/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.adapter.processors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.klucovsky.common.api.adapter.mappers.InputMapper;
import com.klucovsky.common.constants.strings.StringConstants;
import com.klucovsky.common.contract.dto.InputObject;
import com.klucovsky.common.contract.model.DataModelObject;
import com.klucovsky.common.exception.domain.BusinessErrorCodes;
import com.klucovsky.common.exception.errors.ValidationError;
import com.klucovsky.common.exception.exceptions.ValidationException;
import com.klucovsky.common.logging.LoggerUtil;
import reactor.core.publisher.Mono;

/**
 * Dto processor class to process import json from web request
 * and convert it to {@link DataModelObject}
 *
 * @param <S> input object class {@link InputObject}
 * @param <T> business model class {@link DataModelObject}
 */
@Slf4j
@AllArgsConstructor(staticName = "getInstance")
public class InputProcessor<S extends InputObject, T extends DataModelObject<T>> {

    private final Class<S> inputType;
    private final InputMapper<S, T> inputMapper;

    /**
     * Process web request with parameters input body to {@link DataModelObject}
     * then to {@link DataModelObject}
     *
     * @param requestBody request body {@link String string}
     * @return {@link DataModelObject}
     */
    public Mono<T> getModelFromBody(final String requestBody) {

        return getModel(requestBody)
                .map(inputMapper::map)
                .doOnNext(model -> log.debug("Input mapped to model {}", LoggerUtil.convertToJson(model)));
    }

    private Mono<S> getModel(final String requestBody) {
        log.trace("Request body: {}", requestBody);
        return Mono.justOrEmpty(requestBody)
                .flatMap(body -> {
                    try {
                        return Mono.just(new ObjectMapper().readValue(body, inputType));
                    } catch (JsonProcessingException e) {
                        final var error = ValidationError
                                .of(StringConstants.QUERY_ERROR, BusinessErrorCodes.E01_001);
                        return Mono.error(ValidationException.of(error));
                    }
                });
    }
}
