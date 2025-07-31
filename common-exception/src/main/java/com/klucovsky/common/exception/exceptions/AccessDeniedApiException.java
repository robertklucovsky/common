/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.exception.exceptions;

import com.klucovsky.common.exception.domain.ErrorDetail;
import com.klucovsky.common.exception.domain.SystemErrorCodes;

import java.io.Serial;
import java.net.HttpURLConnection;

/**
 * Access denied custom API exception returns error type, code and default message
 */
public class AccessDeniedApiException extends ApiException {
    @Serial
    private static final long serialVersionUID = -9096219873281096758L;

    private static final ErrorDetail defaultErrorDetail = SystemErrorCodes.E00_002;
    private static final int DEFAULT_STATUS = HttpURLConnection.HTTP_FORBIDDEN;

    private AccessDeniedApiException(final String message, final Throwable cause) {
        super(message, cause, DEFAULT_STATUS, defaultErrorDetail);
    }

    private AccessDeniedApiException(final String message) {
        super(message, DEFAULT_STATUS, defaultErrorDetail);
    }

    /**
     * Create an {@link AccessDeniedApiException exception} of following parameters
     *
     * @param message {@link String exception message}
     * @param cause   {@link Throwable cause}
     * @return {@link AccessDeniedApiException access denied exception}
     */
    public static AccessDeniedApiException of(final String message, final Throwable cause) {
        return new AccessDeniedApiException(message, cause);
    }

    /**
     * Create an {@link AccessDeniedApiException exception} of following parameter
     *
     * @param message {@link String exception message}
     * @return {@link AccessDeniedApiException access denied exception}
     */
    public static AccessDeniedApiException of(final String message) {
        return new AccessDeniedApiException(message);
    }

    /**
     * Create an {@link AccessDeniedApiException exception} of following parameter
     *
     * @param cause {@link Throwable cause}
     * @return {@link AccessDeniedApiException access denied exception}
     */
    public static AccessDeniedApiException of(final Throwable cause) {
        return new AccessDeniedApiException(defaultErrorDetail.getDefaultMessage(), cause);
    }

    /**
     * Create an {@link AccessDeniedApiException exception} with default values
     *
     * @return {@link AccessDeniedApiException access denied exception}
     */
    public static AccessDeniedApiException of() {
        return new AccessDeniedApiException(defaultErrorDetail.getDefaultMessage());
    }
}
