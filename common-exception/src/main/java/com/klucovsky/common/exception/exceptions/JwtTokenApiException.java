/*
 * Copyright (c) 2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.exception.exceptions;

import lombok.Getter;
import com.klucovsky.common.exception.domain.ErrorDetail;
import com.klucovsky.common.exception.domain.SystemErrorCodes;

import java.io.Serial;
import java.net.HttpURLConnection;

@Getter
public class JwtTokenApiException extends ApiException {

    @Serial
    private static final long serialVersionUID = -4906229555904092531L;

    private static final ErrorDetail defaultErrorDetail = SystemErrorCodes.E00_011;
    private static final int DEFAULT_STATUS = HttpURLConnection.HTTP_BAD_REQUEST;

    private JwtTokenApiException(final String message, final Throwable cause) {
        super(message, cause, DEFAULT_STATUS, defaultErrorDetail);
    }

    private JwtTokenApiException(final String message) {
        super(message, DEFAULT_STATUS, defaultErrorDetail);
    }

    /**
     * Create an {@link JwtTokenApiException exception} of following parameters
     *
     * @param message {@link String exception message}
     * @param cause   {@link Throwable cause}
     * @return {@link JwtTokenApiException illegal argument exception}
     */
    public static JwtTokenApiException of(final String message, final Throwable cause) {
        return new JwtTokenApiException(message, cause);
    }

    /**
     * Create an {@link JwtTokenApiException exception} of following parameter
     *
     * @param message {@link String exception message}
     * @return {@link JwtTokenApiException illegal argument exception}
     */
    public static JwtTokenApiException of(final String message) {
        return new JwtTokenApiException(message);
    }

    /**
     * Create an {@link JwtTokenApiException exception} of following parameter
     *
     * @param cause {@link Throwable cause}
     * @return {@link JwtTokenApiException illegal argument exception}
     */
    public static JwtTokenApiException of(final Throwable cause) {
        return new JwtTokenApiException(defaultErrorDetail.getDefaultMessage(), cause);
    }

    /**
     * Create an {@link JwtTokenApiException exception} with default values
     *
     * @return {@link JwtTokenApiException illegal argument exception}
     */
    public static JwtTokenApiException of() {
        return new JwtTokenApiException(defaultErrorDetail.getDefaultMessage());
    }
}
