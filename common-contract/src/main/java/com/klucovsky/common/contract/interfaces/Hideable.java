/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.contract.interfaces;

/**
 * Identification if the object is hidden
 *
 * @param <T> T object
 */
public interface Hideable<T> {
    /**
     * Set hidden flag
     *
     * @param hidden boolean flag
     * @return updated T object
     */
    T setHidden(boolean hidden);
}
