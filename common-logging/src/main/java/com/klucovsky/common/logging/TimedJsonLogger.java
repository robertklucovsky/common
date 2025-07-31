/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.logging;

import com.klucovsky.common.constants.strings.StringConstants;
import org.slf4j.Logger;
import org.slf4j.event.Level;

import java.time.Instant;

public class TimedJsonLogger extends JsonLogger {

    private static final String ELAPSED_TIME = "ElapsedTime";
    private final Instant start = Instant.now();

    public TimedJsonLogger(final Logger logger) {
        super(logger);
    }

    public TimedJsonLogger(final Logger logger, final String requestId) {
        super(logger, requestId);
    }

    /**
     * Add map to json structure on TRACE level
     *
     * @param name   property name
     * @param object property value
     * @return chain link to {@link JsonLogger}
     */
    @Override
    public JsonLogger addTrace(final String name, final Object object) {
        logs.put(name + ELAPSED_TIME, LoggerUtil.getElapsedTime(start));
        return super.addTrace(name, object);
    }

    /**
     * Add map to json structure on DEBUG level
     *
     * @param name   property name
     * @param object property value
     * @return chain link to {@link JsonLogger}
     */
    @Override
    public JsonLogger addDebug(final String name, final Object object) {
        logs.put(name + ELAPSED_TIME, LoggerUtil.getElapsedTime(start));
        return super.addDebug(name, object);
    }

    /**
     * Add map to json structure on INFO level
     *
     * @param name   property name
     * @param object property value
     * @return chain link to {@link JsonLogger}
     */
    @Override
    public JsonLogger addInfo(final String name, final Object object) {
        logs.put(name + ELAPSED_TIME, LoggerUtil.getElapsedTime(start));
        return super.addInfo(name, object);
    }

    /**
     * Ending method of operation related to json
     * this method writes the completed json structure to log on INFO level
     *
     * @param level log level
     * @param message message to log
     */
    @Override
    public void log(final Level level, final String message) {
        addInfo(StringConstants.ELAPSED_TIME, LoggerUtil.getElapsedTime(start));
        super.log(level, message);
    }

    /**
     * Ending method of operation related to json
     * this method writes the completed json structure to log on INFO level
     *
     * @param message message to log
     */
    @Override
    public void logError(final String message) {
        addInfo(StringConstants.ELAPSED_TIME, LoggerUtil.getElapsedTime(start));
        super.logError(message);
    }

    /**
     * Ending method of operation related to json
     * this method writes the completed json structure to log on INFO level
     *
     * @param message message to log
     */
    @Override
    public void log(final String message) {
        addInfo(StringConstants.ELAPSED_TIME, LoggerUtil.getElapsedTime(start));
        super.log(message);
    }
}
