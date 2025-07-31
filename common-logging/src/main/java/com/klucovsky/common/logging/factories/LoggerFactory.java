/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.logging.factories;

import com.klucovsky.common.logging.JsonLogger;
import org.slf4j.Logger;

/**
 * Factory class to create a {@link JsonLogger}
 */
public interface LoggerFactory {

    /**
     * Create a {@link JsonLogger} to write logs in Json format<br>
     * with request id
     *
     * @param log       Slf4j {@link Logger} class
     * @return {@link JsonLogger}
     */
    JsonLogger getJsonLogger(Logger log);
}
