/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of rounding types
 */
@Getter
@RequiredArgsConstructor
public enum RoundType {

    /**
     * No round
     */
    NO_ROUND(5),

    /**
     * Round to zero decimal places
     */
    ROUND_TO_INTEGER(0),

    /**
     * Round to tens
     */
    ROUND_TO_TEN(-1),

    /**
     * Round to hundreds
     */
    ROUND_TO_HUNDRED(-2),

    /**
     * Round to thousands
     */
    ROUND_TO_THOUSAND(-3),

    /**
     * Round to one decimal place
     */
    ROUND_TO_TENTH(1),

    /**
     * Round to two decimal places
     */
    ROUND_TO_HUNDREDTH(2),

    /**
     * Round to three decimal places
     */
    ROUND_TO_THOUSANDTH(3),

    /**
     * Round to four decimal places
     */
    ROUND_TO_TEN_THOUSANDTH(4);

    private final int scale;
}
