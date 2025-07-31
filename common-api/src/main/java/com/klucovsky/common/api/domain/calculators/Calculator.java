/*
 * Copyright (c) 2020-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.calculators;

import com.klucovsky.common.constants.enums.RoundType;
import com.klucovsky.common.contract.model.DataModelObject;
import reactor.core.publisher.Mono;

/**
 * Interface for calculator
 *
 * @param <T> object which have to be calculated
 */
public interface Calculator<T extends DataModelObject<T>> {
    /**
     * Calculate object
     *
     * @param object object to calculate
     * @return calculated object
     */
    default Mono<T> calculate(final T object) {
        return calculateRound(object, RoundType.NO_ROUND);
    }

    /**
     * Calculate object
     *
     * @param object    object to calculate
     * @param roundType {@link RoundType}
     * @return object with calculated list price
     */
    Mono<T> calculateRound(T object, RoundType roundType);
}
