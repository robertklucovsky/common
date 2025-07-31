/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.constants.regex;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

/**
 * Compiled common regex patterns
 */
@NoArgsConstructor(access = AccessLevel.NONE)
public class RegexPatterns {

    /**
     * Pattern to recognize email address
     */
    public static final Pattern email = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    /**
     * Pattern to recognize website url
     */
    public static final Pattern website = Pattern.compile(
            "^(http://|https://)?(www.)?([a-z0-9]+).[a-z0-9]*.[a-z]{3}.?([a-z]+)?$",
            Pattern.CASE_INSENSITIVE);
}
