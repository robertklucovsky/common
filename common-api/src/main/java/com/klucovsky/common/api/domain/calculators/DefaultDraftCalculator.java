/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.calculators;

import lombok.NoArgsConstructor;
import com.klucovsky.common.contract.interfaces.Draftable;
import com.klucovsky.common.contract.model.DataModelObject;
import com.klucovsky.common.exception.errors.ValidationError;
import reactor.core.publisher.Mono;

import java.util.Set;

/**
 * Set draft flag to true if model contains validation warnings
 *
 * @param <T> {@link DataModelObject model}
 */
@NoArgsConstructor(staticName = "getInstance")
public class DefaultDraftCalculator<T extends DataModelObject<T>> implements DraftCalculator<T> {
    /**
     * Calculate draft flag
     *
     * @param model  {@link T object} to calculate draft flag
     * @param errors set of {@link ValidationError}
     * @return {@link T object} with calculated flag
     */
    @Override
    public Mono<T> calculate(final T model, final Set<ValidationError> errors) {
        if (model instanceof Draftable<?> modelDraftable) {
            modelDraftable.setDraft(!errors.isEmpty());
        }
        return Mono.just(model);
    }
}
