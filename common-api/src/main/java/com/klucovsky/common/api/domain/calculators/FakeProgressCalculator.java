/*
 * Copyright (c) 2020-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.calculators;

import lombok.NoArgsConstructor;
import com.klucovsky.common.api.domain.processors.ModelProcessor;
import com.klucovsky.common.contract.interfaces.ValidatableObject;
import com.klucovsky.common.contract.model.DataModelObject;
import reactor.core.publisher.Mono;

/**
 * Fake state calculator is used in {@link ModelProcessor model processor} if state calculator not needed
 *
 * @param <T> object extends {@link ValidatableObject}
 * @author Robert Klucovsky
 * @since 1.0
 */
@NoArgsConstructor(staticName = "getInstance")
public class FakeProgressCalculator<T extends DataModelObject<T>> implements ProgressCalculator<T> {
    /**
     * Calculate object
     *
     * @param model object to calculate
     * @return calculated object
     */
    @Override
    public Mono<T> calculate(final T model) {
        return Mono.justOrEmpty(model);
    }
}
