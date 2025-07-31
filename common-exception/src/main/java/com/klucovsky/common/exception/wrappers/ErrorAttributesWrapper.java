package com.klucovsky.common.exception.wrappers;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ErrorAttributesWrapper extends DefaultErrorAttributes {

    private final List<ExceptionWrapper> chain;

    public ErrorAttributesWrapper() {
        chain = new ArrayList<>();
        registerException(new ApiExceptionWrapper());
        registerException(new RuntimeExceptionWrapper());
    }

    @Override
    public Map<String, Object> getErrorAttributes(final ServerRequest request, final ErrorAttributeOptions options) {
        Throwable error = getError(request);
        final var errorAttributes = super.getErrorAttributes(request, options);
        chain.stream().findFirst().ifPresent(wrapper -> wrapper.addErrorAttributes(error, errorAttributes));
        return errorAttributes;
    }

    public void registerException(final ExceptionWrapper exception) {
        if (!chain.isEmpty()) {
            chain.get(chain.size() - 1).setNextChain(exception);
        }
        chain.add(exception);
    }
}
