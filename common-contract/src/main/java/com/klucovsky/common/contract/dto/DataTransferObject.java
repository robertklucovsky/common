/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.contract.dto;

import com.klucovsky.common.contract.interfaces.ValidatableObject;

import java.io.Serializable;

/**
 * Interface class for DTOs
 */
public interface DataTransferObject extends ValidatableObject, Serializable {

    /**
     * Get object {@link String id}
     *
     * @return {@link String id}
     */
    String getId();
}
