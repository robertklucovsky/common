/*
 * Copyright (c) 2020-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.services;

import com.klucovsky.common.contract.model.DataModelObject;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

/**
 * Interface class to get model object from database
 *
 * @param <T> model object to store
 */
public interface QueryService<T extends DataModelObject<T>> {

    /**
     * Get all models paged and sorted
     *
     * @param pageable {@link Pageable} page, sort settings
     * @return paged collection of {@link DataModelObject models}
     */
    Flux<T> findAll(Pageable pageable);
}
