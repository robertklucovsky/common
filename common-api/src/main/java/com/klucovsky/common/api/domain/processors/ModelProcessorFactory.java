/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.processors;

import com.klucovsky.common.contract.model.DataModelObject;
import com.klucovsky.common.logging.factories.LoggerFactory;

/**
 * Model processor factory interface
 *
 * @param <T> processed model extends {@link DataModelObject}
 */
public interface ModelProcessorFactory<T extends DataModelObject<T>> {

    /**
     * Create processor factory class from request or message command
     *
     * @param loggerFactory {@link LoggerFactory}
     * @return this processor as {@link ModelProcessor}
     */
    ModelProcessor<T> getProcessor(LoggerFactory loggerFactory);
}
