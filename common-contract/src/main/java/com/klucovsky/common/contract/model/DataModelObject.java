/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.contract.model;

import com.klucovsky.common.contract.interfaces.ValidatableObject;

import java.io.Serializable;
import java.util.UUID;

/**
 * Data Model Object interface
 *
 * @param <T> T object
 */
public interface DataModelObject<T> extends ValidatableObject, Serializable {

    /**
     * Get model id
     *
     * @return {@link UUID id}
     */
    UUID getId();

    /**
     * Set model id
     *
     * @param id {@link UUID id}
     * @return updated {@link DataModelObject object}
     */
    T setId(UUID id);
}
