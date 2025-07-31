/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of customer score
 */
@Getter
@RequiredArgsConstructor
public enum CustomerScore {

    /**
     * Never deal with this customer again
     */
    NEVER_AGAIN(1),

    /**
     * This customer must pay in advance
     */
    PREPAY_ONLY(2),

    /**
     * Standard customer
     */
    STANDARD_CUSTOMER(3),

    /**
     * Important customer
     */
    IMPORTANT_CUSTOMER(4),

    /**
     * VIP customer
     */
    VIP_CUSTOMER(5);

    private final int score;
}
