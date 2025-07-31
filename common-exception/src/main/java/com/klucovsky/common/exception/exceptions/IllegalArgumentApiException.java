/*
 * Copyright (c) 2020-2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.exception.exceptions;

import com.klucovsky.common.exception.domain.ErrorDetail;
import com.klucovsky.common.exception.domain.SystemErrorCodes;

import java.io.Serial;
import java.net.HttpURLConnection;

/**
 * Illegal argument custom API exception returns error type, code and default message
 */

public class IllegalArgumentApiException extends ApiException {

    @Serial
    private static final long serialVersionUID = -7727897973492531583L;

    private static final ErrorDetail defaultErrorDetail = SystemErrorCodes.E00_008;
    private static final int DEFAULT_STATUS = HttpURLConnection.HTTP_BAD_REQUEST;

    private IllegalArgumentApiException(final String message, final Throwable cause) {
        super(message, cause, DEFAULT_STATUS, defaultErrorDetail);
    }

    private IllegalArgumentApiException(final String message) {
        super(message, DEFAULT_STATUS, defaultErrorDetail);
    }

    /**
     * Create an {@link IllegalArgumentApiException exception} of following parameters
     *
     * @param message {@link String exception message}
     * @param cause   {@link Throwable cause}
     * @return {@link IllegalArgumentApiException illegal argument exception}
     */
    public static IllegalArgumentApiException of(final String message, final Throwable cause) {
        return new IllegalArgumentApiException(message, cause);
    }

    /**
     * Create an {@link IllegalArgumentApiException exception} of following parameter
     *
     * @param message {@link String exception message}
     * @return {@link IllegalArgumentApiException illegal argument exception}
     */
    public static IllegalArgumentApiException of(final String message) {
        return new IllegalArgumentApiException(message);
    }

    /**
     * Create an {@link IllegalArgumentApiException exception} of following parameter
     *
     * @param cause   {@link Throwable cause}
     * @return {@link IllegalArgumentApiException illegal argument exception}
     */
    public static IllegalArgumentApiException of(final Throwable cause) {
        return new IllegalArgumentApiException(defaultErrorDetail.getDefaultMessage(), cause);
    }

    /**
     * Create an {@link IllegalArgumentApiException exception} with default values
     *
     * @return {@link IllegalArgumentApiException illegal argument exception}
     */
    public static IllegalArgumentApiException of() {
        return new IllegalArgumentApiException(defaultErrorDetail.getDefaultMessage());
    }
}
