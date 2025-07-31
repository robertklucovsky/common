/*
 * Copyright (c) 2020-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.adapter.mappers;

import com.klucovsky.common.contract.dto.DataTransferObject;
import com.klucovsky.common.contract.model.DataModelObject;

/**
 * Mapper interface to convert from {@link DataModelObject model} to {@link DataTransferObject dto}
 *
 * @param <S> {@link DataModelObject model}
 * @param <T> {@link DataTransferObject dto}
 */
public interface DtoMapper<S extends DataModelObject<S>, T extends DataTransferObject> {

    /**
     * Map {@link DataModelObject model} to {@link DataTransferObject dto}
     *
     * @param model {@link DataModelObject model}
     * @return mapped {@link DataTransferObject dto}
     */
    T map(S model);
}
