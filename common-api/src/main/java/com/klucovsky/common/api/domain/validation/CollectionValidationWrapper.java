/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.validation;

import com.klucovsky.common.contract.interfaces.ValidatableObject;
import com.klucovsky.common.exception.errors.ValidationError;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * Validation wrapper for set of objects validation.
 *
 * @param <T> object extends {@link ValidatableObject}
 */
public interface CollectionValidationWrapper<T extends ValidatableObject> {
    /**
     * Validate errors after calculation of target object
     *
     * @param model the collection of object that is to be validated
     * @return found validation error with children
     */
    Mono<ValidationError> validateCalculation(Collection<T> model);

    /**
     * Validate logical errors the target object,
     *
     * @param model the collection of object that is to be validated
     * @return found validation error with children
     */
    Mono<ValidationError> validateLogical(Collection<T> model);
}
