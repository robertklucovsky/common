/*
 * Copyright (c) 2020-2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.exception.exceptions;

import lombok.Getter;
import com.klucovsky.common.exception.domain.BusinessErrorCodes;
import com.klucovsky.common.exception.domain.ErrorDetail;
import com.klucovsky.common.exception.dto.ErrorDto;
import com.klucovsky.common.exception.errors.ValidationError;
import com.klucovsky.common.exception.mappers.ValidationErrorMapper;

import java.io.Serial;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Validation custom API exception returns error type, code and default message
 */
@Getter
public class ValidationException extends ApiException {

    @Serial
    private static final long serialVersionUID = -3345979990122269800L;

    private static final ErrorDetail defaultErrorDetail = BusinessErrorCodes.E01_001;
    private static final int DEFAULT_STATUS = HttpURLConnection.HTTP_BAD_REQUEST;

    private final transient Map<String, ErrorDto> errors;

    private ValidationException(final String message, final Throwable cause, final Set<ValidationError> errors) {
        super(message, cause, DEFAULT_STATUS, defaultErrorDetail);
        this.errors = ValidationErrorMapper.map(errors);
    }

    private ValidationException(final String message, final Set<ValidationError> errors) {
        super(message, DEFAULT_STATUS, defaultErrorDetail);
        this.errors = ValidationErrorMapper.map(errors);
    }

    /**
     * Create an {@link ValidationException exception} of following parameters
     *
     * @param message {@link String exception message}
     * @param cause   {@link Throwable cause}
     * @param errors  {@link Set<ValidationError> errors}
     * @return {@link ValidationException access denied exception}
     */
    public static ValidationException of(final String message,
                                         final Throwable cause,
                                         final Set<ValidationError> errors) {
        return new ValidationException(message, cause, errors);
    }

    /**
     * Create an {@link ValidationException exception} of following parameters
     *
     * @param message {@link String exception message}
     * @param errors  {@link Set<ValidationError> errors}
     * @return {@link ValidationException access denied exception}
     */
    public static ValidationException of(final String message, final Set<ValidationError> errors) {
        return new ValidationException(message, errors);
    }

    /**
     * Create an {@link ValidationException exception} of following parameters
     *
     * @param cause  {@link Throwable cause}
     * @param errors {@link Set<ValidationError> errors}
     * @return {@link ValidationException access denied exception}
     */
    public static ValidationException of(final Throwable cause, final Set<ValidationError> errors) {
        return new ValidationException(defaultErrorDetail.getDefaultMessage(), cause, errors);
    }

    /**
     * Create an {@link ValidationException exception} of following parameter
     *
     * @param errors {@link Set<ValidationError> errors}
     * @return {@link ValidationException access denied exception}
     */
    public static ValidationException of(final Set<ValidationError> errors) {
        return new ValidationException(defaultErrorDetail.getDefaultMessage(), errors);
    }

    /**
     * Create an {@link ValidationException exception} of following parameter
     *
     * @param error {@link ValidationError error}
     * @return {@link ValidationException access denied exception}
     */
    public static ValidationException of(final ValidationError error) {
        return new ValidationException(defaultErrorDetail.getDefaultMessage(), Collections.singleton(error));
    }
}
