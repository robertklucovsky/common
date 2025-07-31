/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.units;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of most used power units
 */
@Getter
@RequiredArgsConstructor
public enum PowerUnit {

    /**
     * Watt with abbreviation
     */
    WATT(1d, "W"),

    /**
     * Kilowatt with abbreviation and rate to watt
     */
    KILOWATT(1000d, "kW"),

    /**
     * Megawatt with abbreviation and rate to watt
     */
    MEGAWATT(1e6, "MW"),

    /**
     * Gigawatt with abbreviation and rate to watt
     */
    GIGAWATT(1e9, "GW"),

    /**
     * Terawatt with abbreviation and rate to watt
     */
    TERAWATT(1e12, "TW"),

    /**
     * Milliwatt with abbreviation and rate to watt
     */
    MILLIWATT(0.001, "mW"),

    /**
     * Microwatt with abbreviation and rate to watt
     */
    MICROWATT(1e-6, "μW"),

    /**
     * Nanowatt with abbreviation and rate to watt
     */
    NANOWATT(1e-9, "nW"),

    /**
     * Picowatt with abbreviation and rate to watt
     */
    PICOWATT(1e-12, "pW"),

    /**
     * Metric horsepower with abbreviation and rate to watt
     */
    METRIC_HORSEPOWER(735.498_75, "hp"),

    /**
     * Mechanical horsepower with abbreviation and rate to watt
     */
    MECHANICAL_HORSEPOWER(745.699_871_58, "hp"),

    /**
     * Electric horsepower with abbreviation and rate to watt
     */
    ELECTRIC_HORSEPOWER(746d, "hp");

    private final double rate;
    private final String abbr;
}
