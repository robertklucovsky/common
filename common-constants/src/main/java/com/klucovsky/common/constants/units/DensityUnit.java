/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.units;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of most used density units
 */
@Getter
@RequiredArgsConstructor
public enum DensityUnit {

    /**
     * Kilograms per cubic meter with abbreviation and rate to gram per cubic mm
     */
    KILOGRAMS_PER_CUBIC_METER(1_000_000d, "kg/m<sup>3</sup>"),

    /**
     * Kilograms per cubic decimeter with abbreviation and rate to gram per cubic mm
     */
    KILOGRAMS_PER_CUBIC_DECIMETER(1000d, "kg/dm<sup>3</sup>"),

    /**
     * Grams per cubic centimeter with abbreviation and rate to gram per cubic mm
     */
    GRAMS_PER_CUBIC_CENTIMETER(1000d, "g/cm<sup>3</sup>"),

    /**
     * Grams per cubic millimeter with abbreviation
     */
    GRAMS_PER_CUBIC_MILLIMETER(1d, "g/mm<sup>3</sup>"),

    /**
     * Ounces per cubic inch with abbreviation and rate to gram per cubic mm
     */
    OUNCES_PER_CUBIC_INCH(1_729.994_044, "oz/in<sup>3</sup>"),

    /**
     * Ounces per fluid ounce with abbreviation and rate to gram per cubic mm
     */
    OUNCES_PER_FLUID_OUNCE(958.611_415, "oz/fl.oz"),

    /**
     * Pounds per cubic inch with abbreviation and rate to gram per cubic mm
     */
    POUNDS_PER_CUBIC_INCH(27_679.904_71, "lb/in<sup>3</sup>"),

    /**
     * Pounds per cubic foot with abbreviation and rate to gram per cubic mm
     */
    POUNDS_PER_CUBIC_FOOT(16.018_463, "lb/ft<sup>3</sup>"),

    /**
     * Pounds per cubic yard with abbreviation and rate to gram per cubic mm
     */
    POUNDS_PER_CUBIC_YARD(0.593_276, "lb/yd<sup>3</sup>"),

    /**
     * Pounds per US gallon with abbreviation and rate to gram per cubic mm
     */
    POUNDS_PER_GALLON_US(119.826_427, "lb/gal");

    private final double rate;
    private final String abbr;
}
