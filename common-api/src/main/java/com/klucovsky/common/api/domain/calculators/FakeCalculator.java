/*
 * Copyright (c) 2020-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.calculators;

import lombok.NoArgsConstructor;
import com.klucovsky.common.api.domain.processors.ModelProcessor;
import com.klucovsky.common.constants.enums.RoundType;
import com.klucovsky.common.contract.interfaces.ValidatableObject;
import com.klucovsky.common.contract.model.DataModelObject;
import reactor.core.publisher.Mono;

/**
 * State calculator is used in {@link ModelProcessor model processor}
 *
 * @param <T> object extends {@link ValidatableObject}
 * @author Robert Klucovsky
 * @since 1.0
 */
@NoArgsConstructor(staticName = "getInstance")
public class FakeCalculator<T extends DataModelObject<T>> implements Calculator<T> {

    /**
     * Calculate object
     *
     * @param object object to calculate
     * @return calculated object
     */
    @Override
    public Mono<T> calculateRound(final T object, final RoundType roundType) {
        return Mono.just(object);
    }
}
