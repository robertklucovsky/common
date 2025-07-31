/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.annotations;

import com.klucovsky.common.api.configs.CommonApiConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Call {@link CommonApiConfig} as a @Configuration
 */
@Target(ElementType.TYPE)
@Import(CommonApiConfig.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableCommonApi {
}
