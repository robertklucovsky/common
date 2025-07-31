/*
 * Copyright (c) 2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.exception.wrappers;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import com.klucovsky.common.constants.strings.StringConstants;
import com.klucovsky.common.exception.domain.BusinessErrorCodes;
import com.klucovsky.common.exception.domain.ErrorDetail;
import com.klucovsky.common.exception.domain.SystemErrorCodes;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
public class RuntimeExceptionWrapper extends ExceptionWrapper {

    @Override
    public void addErrorAttributes(final Throwable error, final Map<String, Object> errorAttributes) {
        if (error instanceof WebClientResponseException.Unauthorized) {
            addAttributes(HttpStatus.UNAUTHORIZED, errorAttributes, SystemErrorCodes.E00_001);
        } else if (error instanceof WebClientResponseException.Forbidden) {
            addAttributes(HttpStatus.FORBIDDEN, errorAttributes, SystemErrorCodes.E00_002);
        } else if (error instanceof ResponseStatusException) {
            addAttributes(HttpStatus.NOT_FOUND, errorAttributes, SystemErrorCodes.E00_006);
        } else if (error instanceof OptimisticLockingFailureException) {
            addAttributes(HttpStatus.BAD_REQUEST, errorAttributes, SystemErrorCodes.E00_009);
        } else if (error instanceof DuplicateKeyException) {
            addAttributes(HttpStatus.BAD_REQUEST, errorAttributes, BusinessErrorCodes.E01_002);
        }
        next(error, errorAttributes);
    }

    private void addAttributes(final HttpStatus status, final Map<String, Object> errorAttributes, ErrorDetail errorDetail) {
        errorAttributes.replace(StringConstants.STATUS, status.value());
        errorAttributes.replace(StringConstants.ERROR, status.getReasonPhrase());
        errorAttributes.put(StringConstants.CODE, errorDetail.getCode());
        errorAttributes.put(StringConstants.TYPE, errorDetail.getType());
        errorAttributes.put(StringConstants.MESSAGE, errorDetail.getDefaultMessage());
        log.warn("[{}] Caught {} error: {}",
                errorAttributes.get(StringConstants.ID),
                errorDetail.getDefaultMessage(),
                new Gson().toJson(errorAttributes));
    }
}
