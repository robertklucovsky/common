/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.date;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * DateTime formats used to convert from/to string
 */
@NoArgsConstructor(access = AccessLevel.NONE)
public class DateFormatConstants {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_REGEX = "^(19|20)\\d\\d[\\/\\-.](0[1-9]|1[012])[\\/\\-.](0[1-9]|[12][0-9]|3[01])$";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
}
