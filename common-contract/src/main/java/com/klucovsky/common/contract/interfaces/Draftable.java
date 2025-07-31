/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.contract.interfaces;

/**
 * Identification if the object can be stored as a draft
 *
 * @param <T> T object
 */
public interface Draftable<T> {
    /**
     * Set draft status flag
     *
     * @param status boolean status
     * @return updated {@link Draftable object}
     */
    T setDraft(boolean status);
}
