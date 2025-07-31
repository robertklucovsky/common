/*
 * Copyright (c) 2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.adapter.parsers;

/**
 * Parser interface to parse input to {@link T object}
 */
public interface Parser<T> {

    /**
     * Parse input to {@link T object}
     *
     * @param input {@link String input}
     * @return {@link T object}
     */
    T parse(String input);
}
