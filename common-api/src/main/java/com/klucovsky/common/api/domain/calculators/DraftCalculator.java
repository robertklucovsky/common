/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.calculators;

import com.klucovsky.common.contract.model.DataModelObject;
import com.klucovsky.common.exception.errors.ValidationError;
import reactor.core.publisher.Mono;

import java.util.Set;

/**
 * Set draft flag to true if model contains validation warnings
 *
 * @param <T> {@link DataModelObject model}
 */
public interface DraftCalculator<T extends DataModelObject<T>> {

    /**
     * Calculate draft flag
     *
     * @param model  {@link DataModelObject model} to calculate draft flag
     * @param errors set of {@link ValidationError}
     * @return {@link T model} with calculated flag
     */
    Mono<T> calculate(T model, Set<ValidationError> errors);
}
