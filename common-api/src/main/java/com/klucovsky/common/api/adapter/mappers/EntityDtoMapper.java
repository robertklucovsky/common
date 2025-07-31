/*
 * Copyright (c) 2020-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.adapter.mappers;

import com.klucovsky.common.api.infrastructure.entities.PersistableEntity;
import com.klucovsky.common.contract.dto.DataTransferObject;

/**
 * Mapper interface to convert from {@link PersistableEntity entity} to {@link DataTransferObject dto}
 *
 * @param <S> {@link PersistableEntity entity}
 * @param <T> {@link DataTransferObject dto}
 */
public interface EntityDtoMapper<S extends PersistableEntity<S>, T extends DataTransferObject> {

    /**
     * Map {@link PersistableEntity entity} to {@link DataTransferObject dto}
     *
     * @param entity {@link PersistableEntity entity}
     * @return mapped {@link DataTransferObject dto}
     */
    T map(S entity);
}
