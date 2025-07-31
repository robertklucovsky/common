/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.adapter.utilities;

import org.springframework.data.domain.Pageable;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.List;
import java.util.UUID;

/**
 * Interface to resolve path or query parameters from url
 */
public interface ParameterResolver {

    /**
     * Resolve {@link UUID id} from string
     *
     * @param request {@link ServerRequest request}
     * @return {@link UUID}
     */
    UUID getIdFromPath(ServerRequest request);

    /**
     * Resolve {@link Long concurrencyToken} from string
     *
     * @param request {@link ServerRequest request}
     * @return {@link Long}
     */
    Long getConcurrencyToken(ServerRequest request);

    /**
     * Resolve {@link Boolean allowDraft} parameter from query parameters
     *
     * @param request {@link ServerRequest}
     * @return true/false/null
     */
    Boolean allowDraft(ServerRequest request);

    /**
     * Resolve {@link Pageable pageable} parameters from query parameters
     *
     * @param request {@link ServerRequest request}
     * @return {@link Pageable}
     */
    Pageable getPageable(ServerRequest request);

    /**
     * Get values from query parameter
     *
     * @param request {@link ServerRequest request}
     * @param param   {@link String name}
     * @return list of param values
     */
    List<String> getParamValues(ServerRequest request, String param);
}