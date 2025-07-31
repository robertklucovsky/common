/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.enums;

/**
 * Enum of operation repetition
 */
public enum RepeatType {

    /**
     * The operation will be performed once
     */
    ONCE,

    /**
     * The operation will be performed for each part
     */
    EVERY,

    /**
     * The operation will be performed once per batch of parts
     */
    BATCH
}
