/*
 * Copyright (c) 2020-2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.adapter.mappers;

import com.klucovsky.common.contract.dto.DataTransferObject;
import com.klucovsky.common.contract.dto.InputObject;

/**
 * Mapper interface to convert from {@link InputObject input} to {@link DataTransferObject dto}
 *
 * @param <S> {@link InputObject input}
 * @param <T> {@link DataTransferObject dto}
 */
public interface InputDtoMapper<S extends InputObject, T extends DataTransferObject> {

    /**
     * Map {@link InputObject input} to {@link DataTransferObject dto}
     *
     * @param input {@link InputObject input}
     * @return mapped {@link DataTransferObject dto}
     */
    T map(S input);
}
