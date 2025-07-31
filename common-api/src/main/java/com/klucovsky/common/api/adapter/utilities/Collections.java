/*
 * Copyright (c) 2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.adapter.utilities;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.NONE)
public class Collections {

    public static <T> boolean isValid(Collection<T> collection) {
        return Optional.ofNullable(collection).map(c -> !c.isEmpty()).orElse(false);
    }
}
