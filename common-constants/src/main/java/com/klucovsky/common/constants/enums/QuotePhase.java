/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.enums;

/**
 * Phases of quote
 */
public enum QuotePhase {

    /**
     * Quote is prepared to send to customer
     */
    OPPORTUNITY,

    /**
     * Quote sent to customer and negotiation started
     */
    NEGOTIATION,

    /**
     * Quote is confirmed by customer
     */
    CONFIRMED,

    /**
     * Quote is rejected by customer
     */
    REJECTED,

    /**
     * Quote is on hold
     */
    ON_HOLD
}
