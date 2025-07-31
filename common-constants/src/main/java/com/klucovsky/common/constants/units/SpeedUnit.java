/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.units;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum of most used speed units
 */
@Getter
@RequiredArgsConstructor
public enum SpeedUnit {

    /**
     * Millimeters per second with abbreviation
     */
    MILLIMETERS_PER_SECOND(0.001, "mm/s"),

    /**
     * Meters per second with abbreviation
     */
    METERS_PER_SECOND(1d, "m/s"),

    /**
     * Meters per minute with abbreviation and rate to m/s
     */
    METERS_PER_MINUTE(60d, "m/min"),

    /**
     * Kilometers per hour with abbreviation and rate to m/s
     */
    KILOMETERS_PER_HOUR(0.277_777_778, "km/h"),

    /**
     * Inches per second with abbreviation and rate to m/s
     */
    INCHES_PER_SECOND(0.0254, "ips"),

    /**
     * Inches per minute with abbreviation and rate to m/s
     */
    INCHES_PER_MINUTE(1.524, "ipm"),

    /**
     * Feet per second with abbreviation and rate to m/s
     */
    FEET_PER_SECOND(0.3048, "fps"),

    /**
     * Feet per minute with abbreviation and rate to m/s
     */
    FEET_PER_MINUTE(18.288, "fpm"),

    /**
     * Miles per hour with abbreviation and rate to m/s
     */
    MILES_PER_HOUR(0.447_04, "mph");

    private final double rate;
    private final String abbr;
}
