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
public class DateFormatApiException extends ApiException {

    @Serial
    private static final long serialVersionUID = -4906229555904092531L;

    private static final ErrorDetail defaultErrorDetail = SystemErrorCodes.E00_012;
    private static final int DEFAULT_STATUS = HttpURLConnection.HTTP_BAD_REQUEST;

    private DateFormatApiException(final String message, final Throwable cause) {
        super(message, cause, DEFAULT_STATUS, defaultErrorDetail);
    }

    private DateFormatApiException(final String message) {
        super(message, DEFAULT_STATUS, defaultErrorDetail);
    }

    /**
     * Create an {@link DateFormatApiException exception} of following parameters
     *
     * @param message {@link String exception message}
     * @param cause   {@link Throwable cause}
     * @return {@link DateFormatApiException illegal argument exception}
     */
    public static DateFormatApiException of(final String message, final Throwable cause) {
        return new DateFormatApiException(message, cause);
    }

    /**
     * Create an {@link DateFormatApiException exception} of following parameter
     *
     * @param message {@link String exception message}
     * @return {@link DateFormatApiException illegal argument exception}
     */
    public static DateFormatApiException of(final String message) {
        return new DateFormatApiException(message);
    }

    /**
     * Create an {@link DateFormatApiException exception} of following parameter
     *
     * @param cause {@link Throwable cause}
     * @return {@link DateFormatApiException illegal argument exception}
     */
    public static DateFormatApiException of(final Throwable cause) {
        return new DateFormatApiException(defaultErrorDetail.getDefaultMessage(), cause);
    }

    /**
     * Create an {@link DateFormatApiException exception} with default values
     *
     * @return {@link DateFormatApiException illegal argument exception}
     */
    public static DateFormatApiException of() {
        return new DateFormatApiException(defaultErrorDetail.getDefaultMessage());
    }
}
