/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.enums;

/**
 * Phases of the project
 */
public enum ProjectPhase {

    /**
     * Project created
     */
    CREATED,

    /**
     * Quote is in progress
     */
    QUOTATION,

    /**
     * Production is preparing
     */
    PREPARATION,

    /**
     * Production is in progress
     */
    PRODUCTION,

    /**
     * Project is delivering
     */
    DELIVERING,

    /**
     * Project is invoiced
     */
    INVOICING,

    /**
     * Project is waiting for payment
     */
    PAYMENT,

    /**
     * Project completed
     */
    COMPLETED,

    /**
     * Project is closed
     */
    CLOSED,

    /**
     * Project is canceled
     */
    CANCELED,

    /**
     * Project is on hold
     */
    ON_HOLD
}
