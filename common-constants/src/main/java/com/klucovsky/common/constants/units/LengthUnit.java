/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.units;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of most used length units
 */
@Getter
@RequiredArgsConstructor
public enum LengthUnit {

    /**
     * Meter with abbreviation and rate to mm
     */
    METER(1000d, "m"),

    /**
     * Centimeter with abbreviation and rate to mm
     */
    CENTIMETER(100d, "cm"),

    /**
     * Millimeter with abbreviation
     */
    MILLIMETER(1d, "mm"),

    /**
     * Micrometer with abbreviation and rate to mm
     */
    MICRON(1e-3, "μm"),

    /**
     * Nanometer with abbreviation and rate to mm
     */
    NANOMETER(1e-6, "nm"),

    /**
     * Kilometer with abbreviation and rate to mm
     */
    KILOMETER(1e6, "km"),

    /**
     * Inch with abbreviation and rate to mm
     */
    INCH(25.4, "in"),

    /**
     * Foot with abbreviation and rate to mm
     */
    FOOT(304.8, "ft"),

    /**
     * Yard with abbreviation and rate to mm
     */
    YARD(914.4, "yd"),

    /**
     * Mile with abbreviation and rate to mm
     */
    MILE(1.609_344e6, "mi"),

    /**
     * Nautical mile with abbreviation and rate to mm
     */
    NAUTICAL_MILE(1.852e6, "nmi");

    private final double rate;
    private final String abbr;
}
