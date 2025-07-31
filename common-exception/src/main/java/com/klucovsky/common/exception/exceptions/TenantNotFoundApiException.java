/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.exception.exceptions;

import com.klucovsky.common.exception.domain.ErrorDetail;
import com.klucovsky.common.exception.domain.SystemErrorCodes;

import java.io.Serial;
import java.net.HttpURLConnection;

/**
 * Tenant not found custom API exception returns error type, code and default message
 */
public class TenantNotFoundApiException extends ApiException {

    @Serial
    private static final long serialVersionUID = 5905857452890984717L;

    private static final ErrorDetail defaultErrorDetail = SystemErrorCodes.E00_010;
    private static final int DEFAULT_STATUS = HttpURLConnection.HTTP_NOT_IMPLEMENTED;

    private TenantNotFoundApiException(final String message, final Throwable cause) {
        super(message, cause, DEFAULT_STATUS, defaultErrorDetail);
    }

    private TenantNotFoundApiException(final String message) {
        super(message, DEFAULT_STATUS, defaultErrorDetail);
    }

    /**
     * Create an {@link TenantNotFoundApiException exception} of following parameters
     *
     * @param message {@link String exception message}
     * @param cause   {@link Throwable cause}
     * @return {@link TenantNotFoundApiException access denied exception}
     */
    public static TenantNotFoundApiException of(final String message, final Throwable cause) {
        return new TenantNotFoundApiException(message, cause);
    }

    /**
     * Create an {@link TenantNotFoundApiException exception} of following parameter
     *
     * @param message {@link String exception message}
     * @return {@link TenantNotFoundApiException access denied exception}
     */
    public static TenantNotFoundApiException of(final String message) {
        return new TenantNotFoundApiException(message);
    }

    /**
     * Create an {@link TenantNotFoundApiException exception} of following parameter
     *
     * @param cause   {@link Throwable cause}
     * @return {@link TenantNotFoundApiException access denied exception}
     */
    public static TenantNotFoundApiException of(final Throwable cause) {
        return new TenantNotFoundApiException(defaultErrorDetail.getDefaultMessage(), cause);
    }

    /**
     * Create an {@link TenantNotFoundApiException exception} with default values
     *
     * @return {@link TenantNotFoundApiException access denied exception}
     */
    public static TenantNotFoundApiException of() {
        return new TenantNotFoundApiException(defaultErrorDetail.getDefaultMessage());
    }
}
