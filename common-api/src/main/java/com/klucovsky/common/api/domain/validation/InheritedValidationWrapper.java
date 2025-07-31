/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.validation;

import com.klucovsky.common.contract.interfaces.ValidatableObject;
import com.klucovsky.common.exception.errors.ValidationError;
import reactor.core.publisher.Flux;

/**
 * Validation wrapper for the inherited objects
 *
 * @param <T> object extends {@link ValidatableObject}
 * @param <S> object from which the validated object was inherited
 */
public interface InheritedValidationWrapper<S extends ValidatableObject, T extends S> {
    /**
     * Validate errors after calculation of the inherited object
     *
     * @param object the object that is to be validated
     * @return found validation errors
     */
    Flux<ValidationError> validateCalculation(T object);

    /**
     * Validate logical errors of the inherited object
     *
     * @param object the object that is to be validated
     * @return found validation errors
     */
    Flux<ValidationError> validateLogical(T object);
}
