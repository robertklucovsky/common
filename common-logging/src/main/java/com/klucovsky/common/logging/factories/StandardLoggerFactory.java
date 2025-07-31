/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.logging.factories;

import com.klucovsky.common.logging.JsonLogger;
import com.klucovsky.common.logging.StandardJsonLogger;
import org.slf4j.Logger;

public class StandardLoggerFactory implements LoggerFactory {
    /**
     * Create a {@link JsonLogger} to write logs in Json format<br>
     * with request id
     *
     * @param log       Slf4j {@link Logger} class
     * @return {@link JsonLogger}
     */
    @Override
    public JsonLogger getJsonLogger(final Logger log) {
        return new StandardJsonLogger(log);
    }
}
