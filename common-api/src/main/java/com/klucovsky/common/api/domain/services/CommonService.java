/*
 * Copyright (c) 2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.services;

import com.klucovsky.common.contract.model.DataModelObject;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Common interface class for both command and query services
 *
 * @param <T> model object to manipulate with
 */
public interface CommonService<T extends DataModelObject<T>> {

    /**
     * Get all database references
     *
     * @param model object to get references as Model
     * @return object with filled references
     */
    Mono<T> mapRef(T model);

    /**
     * Find object by id and return objectModel
     *
     * @param id object id
     * @return object
     */
    Mono<T> find(UUID id);
}
