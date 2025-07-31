/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.units;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VolumeUnit {

    LITER(1e6, "l"),
    MILLILITER(1000d, "ml"),
    DECILITER(1e4, "dcl"),
    HECTOLITER(1e8, "hl"),
    CUBIC_METER(1e9, "m<sup>3</sup>"),
    CUBIC_CENTIMETER(1e3, "cm<sup>3</sup>"),
    CUBIC_MILLIMETER(1d, "mm<sup>3</sup>"),
    CUBIC_KILOMETER(1e18, "km<sup>3</sup>"),
    CUBIC_INCH(16_387.064, "in<sup>3</sup>"),
    CUBIC_FOOT(2.831_685e7, "ft<sup>3</sup>"),
    CUBIC_YARD(7.645_549e8, "yd<sup>3</sup>"),
    CUBIC_MILE(4.168_181_825e18, "mi<sup>3</sup>"),
    TEASPOON_US(4928.92, "tsp"),
    TABLESPOON_US(14_786.765, "tbsp"),
    FLUID_OUNCE_US(29_573.53, "fl oz"),
    CUP_US(240_000, "c"),
    PINT_US(473_176.473, "pt"),
    QUART_US(946_352.946, "qt"),
    GALLON_US(3.785_412e6, "gal"),
    TEASPOON_UK(5919.39, "tsp"),
    TABLESPOON_UK(17_758.171, "tbsp"),
    FLUID_OUNCE_UK(28_413.063, "fl oz"),
    CUP_UK(284_130.6, "c"),
    PINT_UK(568_261.25, "pt"),
    QUART_UK(1.136_523e6, "qt"),
    GALLON_UK(4.546_09e6, "gal");

    private final double rate;
    private final String abbr;
}
