/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.logging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import com.klucovsky.common.logging.model.JsonViews;

import java.time.Duration;
import java.time.Instant;

@NoArgsConstructor(access = AccessLevel.NONE)
public class LoggerUtil {

    /**
     * Calculate elapsed time
     *
     * @param start {@link Instant start time}
     * @return elapsed time formatted as {@link String}
     */
    static String getElapsedTime(Instant start) {
        Duration duration = Duration.between(start, Instant.now());
        long seconds = duration.toSeconds();
        long hh = seconds / 3_600;
        long mm = (seconds % 3_600) / 60;
        long ss = seconds % 60;
        long sss = duration.toMillis() - seconds * 1_000;
        if (hh > 0) {
            return String.format("%02d:%02d:%02d.%03d", hh, mm, ss, sss);
        }
        if (mm > 0) {
            return String.format("%02d:%02d.%03d", mm, ss, sss);
        }
        return String.format("%d.%03d", ss, sss);
    }

    /**
     * Convert object to json string
     *
     * @param object object to convert
     * @return {@link String json}
     */
    public static String convertToJson(final Object object) {
        try {
            return new ObjectMapper().writerWithView(JsonViews.Public.class).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "{\"error\":\"Could not convert the request\"}";
        }
    }
}
