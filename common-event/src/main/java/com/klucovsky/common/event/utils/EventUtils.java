/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.event.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import com.klucovsky.common.constants.strings.StringConstants;
import org.apache.kafka.common.header.Headers;

@NoArgsConstructor(access = AccessLevel.NONE)
public class EventUtils {

    public static String getTenantId(final Headers headers) {
        return headers.headers(StringConstants.TENANT_ID).iterator().next().toString();
    }
}
