/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.units;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of most used area units
 */
@Getter
@RequiredArgsConstructor
public enum AreaUnit {

    /**
     * Square meter with abbreviation and rate to square mm
     */
    SQUARE_METER(1e6, "m<sup>2</sup>"),

    /**
     * Square centimeter with abbreviation and rate to square mm
     */
    SQUARE_CENTIMETER(10_000d, "cm<sup>2</sup>"),

    /**
     * Square millimeter with abbreviation
     */
    SQUARE_MILLIMETER(1d, "mm<sup>2</sup>"),

    /**
     * Square kilometer with abbreviation and rate to square mm
     */
    SQUARE_KILOMETER(1e12, "km<sup>2</sup>"),

    /**
     * Square inch with abbreviation and rate to square mm
     */
    SQUARE_INCH(645.16, "in<sup>2</sup>"),

    /**
     * Square feet with abbreviation and rate to square mm
     */
    SQUARE_FEET(92_903.04, "ft<sup>2</sup>"),

    /**
     * Square yard with abbreviation and rate to square mm
     */
    SQUARE_YARD(836_127.36, "yd<sup>2</sup>"),

    /**
     * Square mile with abbreviation and rate to square mm
     */
    SQUARE_MILE(2.589_988e12, "mi<sup>2</sup>"),

    /**
     * Hectare with abbreviation and rate to square mm
     */
    HECTARE(1e10, "ha"),

    /**
     * Acre with abbreviation and rate to square mm
     */
    ACRE(4.046_856e9, "ac");

    private final double rate;
    private final String abbr;
}
