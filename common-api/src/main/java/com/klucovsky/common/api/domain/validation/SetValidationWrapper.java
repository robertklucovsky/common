/*
 * Copyright (c) 2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.validation;

import com.klucovsky.common.contract.interfaces.ValidatableObject;
import com.klucovsky.common.exception.errors.ValidationError;
import reactor.core.publisher.Mono;

import java.util.Set;

/**
 * A validation wrapper for set of objects validation.
 */
public interface SetValidationWrapper<T extends ValidatableObject> {
    /**
     * Validate errors after calculation of target object
     *
     * @param models the set of object that is to be validated
     * @return found validation error with children
     */
    Mono<ValidationError> validatePostCalc(Set<T> models);

    /**
     * Validate logical errors the target object,
     *
     * @param model the set of object that is to be validated
     * @return found validation error with children
     */
    Mono<ValidationError> validateLogical(Set<T> model);
}
