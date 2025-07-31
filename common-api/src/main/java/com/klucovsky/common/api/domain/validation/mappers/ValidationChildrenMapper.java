/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.validation.mappers;

import com.klucovsky.common.exception.domain.BusinessErrorCodes;
import com.klucovsky.common.exception.domain.ErrorDetail;
import com.klucovsky.common.exception.domain.ErrorType;
import com.klucovsky.common.exception.errors.ValidationError;
import reactor.core.publisher.Mono;

import java.util.Set;

/**
 * Mapper to map the errors of children
 */
public class ValidationChildrenMapper {

    /**
     * Map Set as children
     *
     * @param validationErrors children's validation errors
     * @param field            child name
     * @return ValidationError with children
     */
    public Mono<ValidationError> mapSet(final Set<ValidationError> validationErrors, final String field) {

        final ErrorDetail error = validationErrors
                .stream()
                .anyMatch(err -> err.getDetail().getType().equals(ErrorType.BUSINESS))
                ? BusinessErrorCodes.E01_005
                : BusinessErrorCodes.E01_006;

        return validationErrors.isEmpty()
                ? Mono.empty()
                : Mono.just(ValidationError.of(field, error, validationErrors));
    }
}
