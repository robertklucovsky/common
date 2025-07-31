/*
 * Copyright (c) 2020-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.adapter.mappers;

import com.klucovsky.common.contract.dto.InputObject;
import com.klucovsky.common.contract.model.DataModelObject;

/**
 * Mapper interface to convert from {@link InputObject input} to {@link DataModelObject model}
 *
 * @param <S> {@link InputObject input}
 * @param <T> {@link DataModelObject model}
 */
public interface InputMapper<S extends InputObject, T extends DataModelObject<T>> {

    /**
     * Map {@link InputObject input} to {@link DataModelObject model}
     *
     * @param input {@link InputObject input}
     * @return mapped {@link DataModelObject model}
     */
    T map(S input);
}
