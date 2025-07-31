package com.klucovsky.common.exception.wrappers;

import com.google.gson.Gson;
import com.klucovsky.common.constants.strings.StringConstants;
import com.klucovsky.common.exception.exceptions.ApiException;
import com.klucovsky.common.exception.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ApiExceptionWrapper extends ExceptionWrapper {

    private static final Logger log = LoggerFactory.getLogger(ApiExceptionWrapper.class);

    @Override
    public void addErrorAttributes(final Throwable error, final Map<String, Object> errorAttributes) {
        if (error instanceof ApiException apiException) {
            errorAttributes.put(StringConstants.STATUS, apiException.getStatus());
            errorAttributes.put(StringConstants.CODE, apiException.getCode());
            errorAttributes.put(StringConstants.TYPE, apiException.getType());
            errorAttributes.put(StringConstants.ERROR, apiException.getDefaultMessage());
            if (!error.getMessage().equals(apiException.getDefaultMessage())) {
                errorAttributes.put(StringConstants.MESSAGE, error.getMessage());
            }
            if (error instanceof ValidationException validationException) {
                errorAttributes.put(StringConstants.VALIDATION_ERRORS, validationException.getErrors());
            }
            String attributesJson = new Gson().toJson(errorAttributes);
            log.warn("[{}] Caught {} error: {}",
                    errorAttributes.get(StringConstants.REQUEST_ID),
                    apiException.getDefaultMessage(),
                    attributesJson);
        }
        next(error, errorAttributes);
    }
}
