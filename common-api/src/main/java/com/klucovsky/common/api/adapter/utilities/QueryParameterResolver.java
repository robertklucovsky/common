/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.adapter.utilities;

import com.klucovsky.common.constants.strings.QueryParamConstants;
import com.klucovsky.common.constants.strings.StringConstants;
import com.klucovsky.common.exception.exceptions.IllegalArgumentApiException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.klucovsky.common.constants.strings.StringConstants.TRUE;

/**
 * Class to resolve query parameters from url
 */
public class QueryParameterResolver implements ParameterResolver {

    /**
     * Resolve {@link UUID uuid} from string
     *
     * @param request {@link ServerRequest request}
     * @return {@link UUID}
     */
    @Override
    public UUID getIdFromPath(final ServerRequest request) {
        try {
            return UUID.fromString(request.pathVariable(StringConstants.ID));
        } catch (IllegalArgumentException e) {
            throw IllegalArgumentApiException.of(e.getMessage());
        }
    }

    /**
     * Resolve {@link Long concurrencyToken} from string
     *
     * @param request {@link ServerRequest request}
     * @return {@link Long}
     */
    @Override
    public Long getConcurrencyToken(ServerRequest request) {
        try {
            return Long.parseLong(request.pathVariable(StringConstants.CONCURRENCY_TOKEN));
        } catch (IllegalArgumentException e) {
            throw IllegalArgumentApiException.of(e.getMessage());
        }
    }

    /**
     * Resolve allowDraft parameter from path
     *
     * @param request {@link ServerRequest}
     * @return true/false/null
     */
    @Override
    public Boolean allowDraft(final ServerRequest request) {
        return request.queryParams().containsKey(QueryParamConstants.ALLOW_DRAFT)
                ?
                Boolean.parseBoolean(Optional
                        .ofNullable(request.queryParams().get(QueryParamConstants.ALLOW_DRAFT).get(0))
                        .orElse(TRUE))
                : null;
    }

    /**
     * Resolve pageable parameters from path parameters
     *
     * @param request {@link ServerRequest request}
     * @return {@link Pageable}
     */
    @Override
    public Pageable getPageable(final ServerRequest request) {
        if (request.queryParams().containsKey(QueryParamConstants.PAGE)
                || request.queryParams().containsKey(QueryParamConstants.SORT)) {
            int page = Integer.parseInt(request.queryParam(QueryParamConstants.PAGE).orElse("1")) - 1;
            int size = Integer.parseInt(request.queryParam(QueryParamConstants.SIZE).orElse("100"));

            Sort sort = Sort.unsorted();
            if (request.queryParams().containsKey(QueryParamConstants.SORT)) {
                List<Sort.Order> orders = request.queryParams().get(QueryParamConstants.SORT)
                        .stream()
                        .map(order -> order.startsWith("!")
                                ? Sort.Order.desc(order.substring(1))
                                : Sort.Order.asc(order))
                        .toList();
                sort = Sort.by(orders);
            }
            return PageRequest.of(page, size, sort);
        }
        return Pageable.unpaged();
    }

    /**
     * Get values from query parameter
     *
     * @param request {@link ServerRequest request}
     * @param param   {@link String name}
     * @return list of param values
     */
    @Override
    public List<String> getParamValues(final ServerRequest request, final String param) {
        return request.queryParams().getOrDefault(param, List.of());
    }
}
