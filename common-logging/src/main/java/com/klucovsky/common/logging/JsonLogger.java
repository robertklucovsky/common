/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.logging;

import com.klucovsky.common.constants.strings.StringConstants;
import org.slf4j.Logger;
import org.slf4j.event.Level;

import java.util.HashMap;
import java.util.Map;

public abstract class JsonLogger {

    protected final Logger logger;
    protected final String logPrefix;
    protected final Map<String, Object> logs = new HashMap<>();

    protected JsonLogger(Logger logger) {
        this.logger = logger;
        this.logPrefix = "";
    }

    protected JsonLogger(final Logger logger, final String logPrefix) {
        this.logger = logger;
        this.logPrefix = logPrefix;
    }

    /**
     * Add method being executed as action
     */
    public JsonLogger addAction(final Level level) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        if (Level.TRACE.equals(level) && logger.isTraceEnabled()) {
            addTrace(StringConstants.ACTION, methodName);
        } else if (Level.DEBUG.equals(level) && logger.isDebugEnabled()) {
            addDebug(StringConstants.ACTION, methodName);
        } else {
            addInfo(StringConstants.ACTION, methodName);
        }
        return this;
    }

    /**
     * Add map to json structure on TRACE level
     *
     * @param name   property name
     * @param object property value
     * @return chain link to {@link JsonLogger}
     */
    public JsonLogger addTrace(final String name, final Object object) {
        if (logger.isTraceEnabled()) {
            logs.put(name, object);
        }
        return this;
    }

    /**
     * Add map to json structure on DEBUG level
     *
     * @param name   property name
     * @param object property value
     * @return chain link to {@link JsonLogger}
     */
    public JsonLogger addDebug(final String name, final Object object) {
        if (logger.isDebugEnabled()) {
            logs.put(name, object);
        }
        return this;
    }

    /**
     * Add map to json structure on INFO level
     *
     * @param name   property name
     * @param object property value
     * @return chain link to {@link JsonLogger}
     */
    public JsonLogger addInfo(final String name, final Object object) {
        if (logger.isInfoEnabled()) {
            logs.put(name, object);
        }
        return this;
    }

    /**
     * Ending method of operation related to json
     * this method writes the completed json structure to log on INFO level
     *
     * @param level   log {@link Level level}
     * @param message message to log
     */
    public void log(final Level level, final String message) {
        String body;
        if (logs.isEmpty()) {
            body = "";
        } else {
            body = LoggerUtil.convertToJson(logs);
            logs.clear();
        }
        logger.atLevel(level).log("{}{} {}", logPrefix, message, body);
    }

    /**
     * Ending method of operation related to json
     * this method writes the completed json structure to log on INFO level
     *
     * @param message message to log
     */
    public void log(final String message) {
        log(Level.INFO, message);
    }

    /**
     * Ending method of operation related to json
     * this method writes the completed json structure to log on INFO level
     *
     * @param message message to log
     */
    public void logError(final String message) {
        log(Level.ERROR, message);
    }

    /**
     * Ending method of operation related to json
     * this method writes the completed json structure to log on INFO level
     */
    public void log() {
        if (!logs.isEmpty()) {
            String jsonLogs = LoggerUtil.convertToJson(logs);
            logger.info("{}{}", logPrefix, jsonLogs);
            logs.clear();
        }
    }

    /**
     * Ending method of operation related to json
     * this method writes the completed json structure to log on INFO level
     */
    public void log(final Level level) {
        if (!logs.isEmpty()) {
            String jsonLogs = LoggerUtil.convertToJson(logs);
            logger.atLevel(level).log("{}{}", logPrefix, jsonLogs);
            logs.clear();
        }
    }
}
