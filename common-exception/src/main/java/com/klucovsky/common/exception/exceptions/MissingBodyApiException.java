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
 * Missing body custom API exception returns error type, code and default message
 */

public class MissingBodyApiException extends ApiException {

    @Serial
    private static final long serialVersionUID = 3035737639009499873L;

    private static final ErrorDetail defaultErrorDetail = SystemErrorCodes.E00_007;
    private static final int DEFAULT_STATUS = HttpURLConnection.HTTP_BAD_REQUEST;

    private MissingBodyApiException(final String message, final Throwable cause) {
        super(message, cause, DEFAULT_STATUS, defaultErrorDetail);
    }

    private MissingBodyApiException(final String message) {
        super(message, DEFAULT_STATUS, defaultErrorDetail);
    }

    /**
     * Create an {@link MissingBodyApiException exception} of following parameters
     *
     * @param message {@link String exception message}
     * @param cause   {@link Throwable cause}
     * @return {@link MissingBodyApiException access denied exception}
     */
    public static MissingBodyApiException of(final String message, final Throwable cause) {
        return new MissingBodyApiException(message, cause);
    }

    /**
     * Create an {@link MissingBodyApiException exception} of following parameter
     *
     * @param message {@link String exception message}
     * @return {@link MissingBodyApiException access denied exception}
     */
    public static MissingBodyApiException of(final String message) {
        return new MissingBodyApiException(message);
    }

    /**
     * Create an {@link MissingBodyApiException exception} of following parameter
     *
     * @param cause {@link Throwable cause}
     * @return {@link MissingBodyApiException access denied exception}
     */
    public static MissingBodyApiException of(final Throwable cause) {
        return new MissingBodyApiException(defaultErrorDetail.getDefaultMessage(), cause);
    }

    /**
     * Create an {@link MissingBodyApiException exception} with default values
     *
     * @return {@link MissingBodyApiException access denied exception}
     */
    public static MissingBodyApiException of() {
        return new MissingBodyApiException(defaultErrorDetail.getDefaultMessage());
    }
}
