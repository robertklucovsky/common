/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.client.configs;

import com.klucovsky.common.client.TokenWebFilter;
import com.klucovsky.common.client.WebClientHeaderFilter;
import com.klucovsky.common.client.properties.MicroserviceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(MicroserviceProperties.class)
public class EnableServiceClientConfig {

    @Bean
    public TokenWebFilter tokenWebFilter() {
        return new TokenWebFilter();
    }

    @Bean
    public WebClientHeaderFilter webClientHeaderFilter() {
        return new WebClientHeaderFilter();
    }
}