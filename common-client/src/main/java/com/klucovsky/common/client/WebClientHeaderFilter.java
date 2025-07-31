/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.client;

import com.klucovsky.common.constants.strings.StringConstants;
import org.springframework.web.reactive.function.client.ClientRequest;
import reactor.core.publisher.Mono;

public class WebClientHeaderFilter {

    public Mono<ClientRequest> injectHeader(final ClientRequest request) {
        return Mono.deferContextual(Mono::just)
                .filter(ctx -> ctx.hasKey(StringConstants.BEARER_TOKEN))
                .map(ctx -> ctx.get(StringConstants.BEARER_TOKEN))
                .cast(String.class)
                .map(token -> ClientRequest.from(request)
                        .header(StringConstants.AUTHORIZATION, token)
                        .build());
    }
}
