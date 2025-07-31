/*
 * Copyright (c) 2020-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.calculators;

import com.klucovsky.common.contract.model.DataModelObject;
import reactor.core.publisher.Mono;

/**
 * Interface for progress calculator
 *
 * @param <T> {@link DataModelObject model} for which have to be calculated progress
 * @author Robert Klucovsky
 * @since 1.0.0
 */
public interface ProgressCalculator<T extends DataModelObject<T>> {

    /**
     * Calculate model progress
     *
     * @param model {@link DataModelObject model} to calculate progress
     * @return {@link T model} with calculated progress
     */
    Mono<T> calculate(T model);
}
