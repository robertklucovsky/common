/*
 * Copyright (c) 2020-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.services;

import com.klucovsky.common.contract.model.DataModelObject;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Command interface class to store Model object in ObjectManager
 *
 * @param <T> Model object to store
 */
public interface CommandService<T extends DataModelObject<T>> {

    /**
     * Save object into database
     *
     * @param model object to insert as Model
     * @return created object
     */
    Mono<T> save(T model);

    /**
     * Save updated object into database
     *
     * @param id               - object id
     * @param update           object to insert as Model
     * @param concurrencyToken entity version in db
     * @return created object
     */
    Mono<T> update(UUID id, T update, Long concurrencyToken);

    /**
     * Delete object from database
     *
     * @param id object id
     * @return void
     */
    Mono<Boolean> delete(UUID id);

    /**
     * Merge objects update first and delete the second by id
     *
     * @param model updated T object by merging
     * @param id    id of object to delete
     * @return updated T object
     */
    Mono<T> merge(T model, UUID id);
}
