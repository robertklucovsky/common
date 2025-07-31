/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.infrastructure.mappers;


import com.klucovsky.common.api.infrastructure.entities.PersistableEntity;
import com.klucovsky.common.contract.model.DataModelObject;

/**
 * Mapper interface to convert from {@link DataModelObject model} to {@link PersistableEntity entity} and back
 *
 * @param <S> {@link DataModelObject model}
 * @param <T> {@link PersistableEntity entity}
 */
public interface EntityMapper<S extends DataModelObject<S>, T extends PersistableEntity<T>> {

    /**
     * Map {@link DataModelObject model} to {@link PersistableEntity entity}
     *
     * @param model {@link DataModelObject model}
     * @return mapped {@link PersistableEntity entity}
     */
    T map(S model);

    /**
     * Map {@link PersistableEntity entity} to {@link DataModelObject model}
     *
     * @param entity {@link PersistableEntity entity}
     * @return mapped {@link DataModelObject model}
     */
    S map(T entity);
}
