/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.exception.configurations;

import com.klucovsky.common.exception.wrappers.ErrorAttributesWrapper;
import org.springframework.context.annotation.Bean;

public class CommonApiExceptionsConfiguration {

    @Bean
    public ErrorAttributesWrapper errorAttributesWrapperConfigure() {
        return new ErrorAttributesWrapper();
    }
}
