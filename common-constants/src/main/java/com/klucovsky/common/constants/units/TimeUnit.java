/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.units;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of most used time unit
 */
@Getter
@RequiredArgsConstructor
public enum TimeUnit {

    HOUR(3600d, "h"),
    MINUTE(60d, "min"),
    SECOND(1d, "s"),
    DAY(28_800d, "d"),
    WEEK(144_000d, "w"),
    MONTH(626_400d, "m");

    private final double rate;
    private final String abbr;
}
