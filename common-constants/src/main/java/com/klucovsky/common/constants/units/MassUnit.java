/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.units;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of most used mass units
 */
@Getter
@RequiredArgsConstructor
public enum MassUnit {

    /**
     * Gram with abbreviation
     */
    GRAM(1d, "g"),

    /**
     * Kilogram with abbreviation and rate to gram
     */
    KILOGRAM(1000d, "kg"),

    /**
     * Milligram with abbreviation and rate to gram
     */
    MILLIGRAM(1e-3, "mg"),

    /**
     * Dekagram with abbreviation and rate to gram
     */
    DEKAGRAM(10d, "dkg"),

    /**
     * Tonne with abbreviation and rate to gram
     */
    TONNE(1e6, "t"),

    /**
     * Ounce with abbreviation and rate to gram
     */
    OUNCE(28.35, "oz"),

    /**
     * Pound with abbreviation and rate to gram
     */
    POUND(453.592, "lb"),

    /**
     * Stone with abbreviation and rate to gram
     */
    STONE(6350.293, "st"),

    /**
     * US ton with abbreviation and rate to gram
     */
    US_TON(907_184.74, "t"),

    /**
     * UK ton with abbreviation and rate to gram
     */
    UK_TON(1.016_047e6, "t"),

    /**
     * Carat with abbreviation and rate to gram
     */
    CARAT(5d, "ct");

    private final double rate;
    private final String abbr;
}
