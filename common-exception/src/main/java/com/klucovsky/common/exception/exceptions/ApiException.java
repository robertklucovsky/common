package com.klucovsky.common.exception.exceptions;

import lombok.Getter;
import com.klucovsky.common.exception.domain.ErrorDetail;
import com.klucovsky.common.exception.domain.ErrorType;

import java.io.Serial;

/**
 * Custom API exception returns error type, code and default message
 */
@Getter
public abstract class ApiException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -7650014589075723476L;

    private final int status;
    private final String code;
    private final ErrorType type;
    private final String defaultMessage;

    protected ApiException(final String message, final int status, final ErrorDetail errorDetail) {
        super(message);
        this.status = status;
        this.code = errorDetail.getCode();
        this.type = errorDetail.getType();
        this.defaultMessage = errorDetail.getDefaultMessage();
    }

    protected ApiException(final String message,
                           final Throwable cause,
                           final int status,
                           final ErrorDetail errorDetail) {
        super(message, cause);
        this.status = status;
        this.code = errorDetail.getCode();
        this.type = errorDetail.getType();
        this.defaultMessage = errorDetail.getDefaultMessage();
    }
}
