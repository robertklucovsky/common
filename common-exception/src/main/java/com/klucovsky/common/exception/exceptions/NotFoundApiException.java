/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.exception.exceptions;

import com.klucovsky.common.exception.domain.BusinessErrorCodes;
import com.klucovsky.common.exception.domain.ErrorDetail;

import java.io.Serial;
import java.net.HttpURLConnection;

/**
 * Not found custom API exception returns error type, code and default message
 */

public class NotFoundApiException extends ApiException {

    @Serial
    private static final long serialVersionUID = 5905857452890984717L;

    private static final ErrorDetail defaultErrorDetail = BusinessErrorCodes.E01_004;
    private static final int DEFAULT_STATUS = HttpURLConnection.HTTP_NOT_FOUND;

    private NotFoundApiException(final String message, final Throwable cause) {
        super(message, cause, DEFAULT_STATUS, defaultErrorDetail);
    }

    private NotFoundApiException(final String message) {
        super(message, DEFAULT_STATUS, defaultErrorDetail);
    }

    /**
     * Create an {@link NotFoundApiException exception} of following parameters
     *
     * @param message {@link String exception message}
     * @param cause   {@link Throwable cause}
     * @return {@link NotFoundApiException access denied exception}
     */
    public static NotFoundApiException of(final String message, final Throwable cause) {
        return new NotFoundApiException(message, cause);
    }

    /**
     * Create an {@link NotFoundApiException exception} of following parameter
     *
     * @param message {@link String exception message}
     * @return {@link NotFoundApiException access denied exception}
     */
    public static NotFoundApiException of(final String message) {
        return new NotFoundApiException(message);
    }

    /**
     * Create an {@link NotFoundApiException exception} of following parameter
     *
     * @param cause   {@link Throwable cause}
     * @return {@link NotFoundApiException access denied exception}
     */
    public static NotFoundApiException of(final Throwable cause) {
        return new NotFoundApiException(defaultErrorDetail.getDefaultMessage(), cause);
    }

    /**
     * Create an {@link NotFoundApiException exception} with default values
     *
     * @return {@link NotFoundApiException access denied exception}
     */
    public static NotFoundApiException of() {
        return new NotFoundApiException(defaultErrorDetail.getDefaultMessage());
    }
}
