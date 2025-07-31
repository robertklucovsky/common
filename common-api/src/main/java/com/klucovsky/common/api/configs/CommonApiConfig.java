/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.configs;

import com.klucovsky.common.api.adapter.utilities.ParameterResolver;
import com.klucovsky.common.api.adapter.utilities.QueryParameterResolver;
import com.klucovsky.common.api.domain.validation.mappers.ValidationChildrenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;

/**
 * Config claas for Common Api module
 */
@RequiredArgsConstructor
public class CommonApiConfig {

    /**
     * Create {@link ValidationChildrenMapper} class
     *
     * @return {@link ValidationChildrenMapper}
     */
    @Bean
    public ValidationChildrenMapper validationChildrenMapper() {
        return new ValidationChildrenMapper();
    }

    /**
     * Create {@link ParameterResolver} class
     *
     * @return {@link QueryParameterResolver}
     */
    @Bean
    public ParameterResolver parameterResolver() {
        return new QueryParameterResolver();
    }
}
