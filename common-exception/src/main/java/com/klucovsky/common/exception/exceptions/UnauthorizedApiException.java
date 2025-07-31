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
 * Unauthorized custom API exception returns error type, code and default message
 */
public class UnauthorizedApiException extends ApiException {

    @Serial
    private static final long serialVersionUID = -8371027918635657894L;

    private static final ErrorDetail defaultErrorDetail = SystemErrorCodes.E00_001;
    private static final int DEFAULT_STATUS = HttpURLConnection.HTTP_UNAUTHORIZED;

    private UnauthorizedApiException(final String message, final Throwable cause) {
        super(message, cause, DEFAULT_STATUS, defaultErrorDetail);
    }

    private UnauthorizedApiException(final String message) {
        super(message, DEFAULT_STATUS, defaultErrorDetail);
    }

    /**
     * Create an {@link UnauthorizedApiException exception} of following parameters
     *
     * @param message {@link String exception message}
     * @param cause   {@link Throwable cause}
     * @return {@link UnauthorizedApiException access denied exception}
     */
    public static UnauthorizedApiException of(final String message, final Throwable cause) {
        return new UnauthorizedApiException(message, cause);
    }

    /**
     * Create an {@link UnauthorizedApiException exception} of following parameter
     *
     * @param message {@link String exception message}
     * @return {@link UnauthorizedApiException access denied exception}
     */
    public static UnauthorizedApiException of(final String message) {
        return new UnauthorizedApiException(message);
    }

    /**
     * Create an {@link UnauthorizedApiException exception} of following parameter
     *
     * @param cause   {@link Throwable cause}
     * @return {@link UnauthorizedApiException access denied exception}
     */
    public static UnauthorizedApiException of(final Throwable cause) {
        return new UnauthorizedApiException(defaultErrorDetail.getDefaultMessage(), cause);
    }

    /**
     * Create an {@link UnauthorizedApiException exception} with default values
     *
     * @return {@link UnauthorizedApiException access denied exception}
     */
    public static UnauthorizedApiException of() {
        return new UnauthorizedApiException(defaultErrorDetail.getDefaultMessage());
    }
}
