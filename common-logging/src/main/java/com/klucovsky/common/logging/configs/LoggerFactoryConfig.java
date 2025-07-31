/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.logging.configs;

import com.klucovsky.common.logging.factories.StandardLoggerFactory;
import com.klucovsky.common.logging.factories.TimedLoggerFactory;
import org.springframework.context.annotation.Bean;

public class LoggerFactoryConfig {

    @Bean
    public StandardLoggerFactory standardLoggerFactory() {
        return new StandardLoggerFactory();
    }

    @Bean
    public TimedLoggerFactory timedLoggerFactory() {
        return new TimedLoggerFactory();
    }
}
