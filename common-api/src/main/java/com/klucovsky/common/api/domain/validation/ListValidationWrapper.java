/*
 * Copyright (c) 2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.validation;

import com.klucovsky.common.contract.interfaces.ValidatableObject;
import com.klucovsky.common.exception.errors.ValidationError;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * A validation wrapper for list of objects validation.
 */
public interface ListValidationWrapper<T extends ValidatableObject> {
    /**
     * Validate errors after calculation of target object
     *
     * @param models the list of object that is to be validated
     * @return found validation error with children
     */
    Mono<ValidationError> validatePostCalc(List<T> models);

    /**
     * Validate logical errors the target object,
     *
     * @param models the list of object that is to be validated
     * @return found validation error with children
     */
    Mono<ValidationError> validateLogical(List<T> models);
}
