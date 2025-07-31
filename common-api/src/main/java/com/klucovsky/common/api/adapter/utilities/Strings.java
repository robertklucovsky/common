/*
 * Copyright (c) 2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.adapter.utilities;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.NONE)
public class Strings {

    public static boolean isValid(final String string) {
        return Optional.ofNullable(string).map(s -> !s.isBlank()).orElse(false);
    }
}
