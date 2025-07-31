/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.units;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TorqueUnit {

    NEWTON_METER(1d, "N⋅m"),
    NEWTON_CENTIMETER(100d, "N⋅cm"),
    KILOGRAM_METER(9.806_65, "kgf⋅m"),
    KILOGRAM_CENTIMETER(0.098_066_5, "kg⋅cm"),
    POUND_FOOT(1.355_817_952, "lbf⋅ft"),
    POUND_INCH(0.112_984_833, "lbf⋅in");

    private final double rate;
    private final String abbr;
}
