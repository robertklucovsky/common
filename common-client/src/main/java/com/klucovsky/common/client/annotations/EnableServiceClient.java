/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.client.annotations;

import com.klucovsky.common.client.configs.EnableServiceClientConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Import(EnableServiceClientConfig.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableServiceClient {
}
