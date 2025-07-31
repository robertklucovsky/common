/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.infrastructure.events;

import lombok.NoArgsConstructor;
import com.klucovsky.common.api.domain.processors.ModelProcessor;
import com.klucovsky.common.contract.model.DataModelObject;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Fake event producer is used in {@link ModelProcessor model processor} if event producer not needed
 *
 * @param <T> object extends {@link DataModelObject}
 * @author Robert Klucovsky
 * @since 1.0
 */
@NoArgsConstructor(staticName = "getInstance")
public class FakeEventProducer<T extends DataModelObject<T>> implements EventProducer<T> {

    /**
     * Produce event when model was created
     *
     * @param model created model
     * @return SenderResult
     */
    @Override
    public Mono<T> modelCreatedEvent(T model) {
        // fake modelCreatedEvent
        return Mono.just(model);
    }

    /**
     * Produce event when model was updated
     *
     * @param model updated model
     * @return SenderResult
     */
    @Override
    public Mono<T> modelUpdatedEvent(T model) {
        // fake modelUpdatedEvent
        return Mono.just(model);
    }

    /**
     * Produce event when model was merged
     *
     * @param model merged model
     * @param id    id of deleted model
     * @return SenderResult
     */
    @Override
    public Mono<T> modelMergedEvent(T model, UUID id) {
        // fake modelMergedEvent
        return Mono.just(model);
    }

    /**
     * Produce event when model was deleted
     *
     * @param id id of deleted model
     * @return SenderResult
     */
    @Override
    public Mono<Boolean> modelDeletedEvent(Boolean result, UUID id) {
        // fake modelDeletedEvent
        return Mono.just(result);
    }
}
