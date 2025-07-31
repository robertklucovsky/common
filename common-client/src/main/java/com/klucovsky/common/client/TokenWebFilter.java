/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.client;

import com.klucovsky.common.constants.strings.StringConstants;
import com.klucovsky.common.exception.exceptions.UnauthorizedApiException;
import org.springframework.http.HttpMessage;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

public class TokenWebFilter implements WebFilter {
    /**
     * Process the Web request and (optionally) delegate to the next
     * {@code WebFilter} through the given {@link WebFilterChain}.
     *
     * @param exchange the current server exchange
     * @param chain    provides a way to delegate to the next filter
     * @return {@code Mono<Void>} to indicate when request processing is complete
     */
    @Override
    public Mono<Void> filter(final ServerWebExchange exchange, final WebFilterChain chain) {
        return Mono.justOrEmpty(exchange.getRequest())
                .mapNotNull(HttpMessage::getHeaders)
                .mapNotNull(headers -> headers.get(StringConstants.AUTHORIZATION))
                .switchIfEmpty(Mono.error(UnauthorizedApiException.of()))
                .map(tokens -> tokens.stream().findFirst())
                .flatMap(tokenOptional -> tokenOptional
                        .map(token -> chain.filter(exchange)
                                .contextWrite(context -> context.put(StringConstants.BEARER_TOKEN, token)))
                        .orElseGet(() -> chain.filter(exchange)))
                .onErrorResume(e -> {
                    if (e instanceof UnauthorizedApiException) {
                        return chain.filter(exchange);
                    }
                    return Mono.error(e);
                });
    }
}
