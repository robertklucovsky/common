/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.infrastructure.events;


import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Interface for event producer
 *
 * @param <T> model type
 */
public interface EventProducer<T> {

    /**
     * Produce event when model was created
     *
     * @param model created model
     * @return model
     */
    Mono<T> modelCreatedEvent(T model);

    /**
     * Produce event when model was updated
     *
     * @param model updated model
     * @return model
     */
    Mono<T> modelUpdatedEvent(T model);

    /**
     * Produce event when model was merged
     *
     * @param model merged model
     * @param id    id of deleted model
     * @return model
     */
    Mono<T> modelMergedEvent(T model, UUID id);

    /**
     * Produce event when model was deleted
     *
     * @param result result of deletions
     * @param id id of deleted model
     * @return result
     */
    Mono<Boolean> modelDeletedEvent(Boolean result, UUID id);
}
