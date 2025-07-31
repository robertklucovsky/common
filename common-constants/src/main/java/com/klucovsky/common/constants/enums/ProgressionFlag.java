/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Project statusFlag
 */
@Getter
@RequiredArgsConstructor
public enum ProgressionFlag {

    CLOSED(0),
    ON_HOLD(10),
    IN_TIME(20),
    DELAY(30);

    private final int value;
}
