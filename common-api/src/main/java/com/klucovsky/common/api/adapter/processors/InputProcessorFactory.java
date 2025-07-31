/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.adapter.processors;

import com.klucovsky.common.contract.dto.InputObject;
import com.klucovsky.common.contract.model.DataModelObject;

/**
 * Dto processor factory interface
 *
 * @param <S> input dto extends {@link InputObject}
 * @param <T> output model extends {@link DataModelObject}
 */
public interface InputProcessorFactory<S extends InputObject, T extends DataModelObject<T>> {

    /**
     * Create processor factory class from request or message command
     *
     * @return input processor as {@link InputProcessor}
     */
    InputProcessor<S, T> getProcessor();
}
