/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.validation;

import com.klucovsky.common.contract.interfaces.ValidatableObject;
import reactor.core.publisher.Flux;

/**
 * Validation factory to get validators
 *
 * @param <T> object to validate
 */
public interface ValidatorsFactory<T extends ValidatableObject> {
    /**
     * Get logical validators to perform a logical validation
     *
     * @return set of LogicalValidators
     */
    Flux<LogicalValidator<T>> getLogicalValidators();

    /**
     * Get calc validators to perform a calc validation
     *
     * @return set of CalculationValidators
     */
    Flux<CalculationValidator<T>> getCalculationValidators();
}
