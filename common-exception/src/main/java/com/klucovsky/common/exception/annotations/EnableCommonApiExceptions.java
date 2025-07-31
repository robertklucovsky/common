/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.exception.annotations;

import com.klucovsky.common.exception.configurations.CommonApiExceptionsConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Import(CommonApiExceptionsConfiguration.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableCommonApiExceptions {
}
