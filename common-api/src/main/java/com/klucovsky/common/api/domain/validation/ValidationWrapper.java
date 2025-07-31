/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.validation;

import com.klucovsky.common.contract.interfaces.ValidatableObject;
import com.klucovsky.common.exception.errors.ValidationError;
import reactor.core.publisher.Mono;

import java.util.Set;

/**
 * Validation wrapper for complete object validation.
 *
 * @param <T> object extends {@link ValidatableObject}
 */
public interface ValidationWrapper<T extends ValidatableObject> {
    /**
     * Validate errors after calculation of target object
     *
     * @param model the object that is to be validated
     * @return found validation errors
     */
    Mono<Set<ValidationError>> validateCalculation(T model);

    /**
     * Validate logical errors the target object,
     *
     * @param model the object that is to be validated
     * @return found validation errors
     */
    Mono<Set<ValidationError>> validateLogical(T model);
}
