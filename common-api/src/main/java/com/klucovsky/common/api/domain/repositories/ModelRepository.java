/*
 * Copyright (c) 2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.repositories;

import com.klucovsky.common.contract.model.DataModelObject;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Default interface for model repository
 *
 * @param <T> T model
 */
public interface ModelRepository<T extends DataModelObject<T>> {

    /**
     * Save model
     *
     * @param model {@link T model} to save
     * @return saved {@link T model}
     */
    Mono<T> save(T model);

    /**
     * Update model
     *
     * @param id               {@link UUID id} of model to update
     * @param update           {@link T model} with changes to update original model
     * @param concurrencyToken entity version in db
     * @return update {@link T model}
     */
    Mono<T> update(UUID id, T update, Long concurrencyToken);

    /**
     * Delete model by its id
     *
     * @param id {@link UUID id} of model to update
     * @return true is successfully deleted
     */
    Mono<Boolean> deleteById(UUID id);

    /**
     * Find model by its id
     *
     * @param id {@link UUID id} of model to update
     * @return {@link T model}
     */
    Mono<T> findById(UUID id);
}
