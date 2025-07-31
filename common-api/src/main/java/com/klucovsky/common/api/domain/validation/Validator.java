/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.validation;

import com.klucovsky.common.constants.strings.StringConstants;
import com.klucovsky.common.contract.interfaces.ValidatableObject;
import com.klucovsky.common.exception.domain.ErrorDetail;
import com.klucovsky.common.exception.errors.ValidationError;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Validator for application-specific objects.
 *
 * @param <T> object extends {@link ValidatableObject}
 */
public interface Validator<T extends ValidatableObject> {

    /**
     * Validate the supplied target object, which must be
     * of a Class for which the #supports(Class) method
     * typically has (or would) return true.
     *
     * @param model the object that is to be validated
     * @return found validation errors
     */
    Flux<ValidationError> validate(final T model);

    /**
     * Reject value of field
     *
     * @param field       field
     * @param errorDetail ErrorDetail
     * @return Mono of ValidationError
     */
    default Mono<ValidationError> rejectValue(final String field,
                                              final ErrorDetail errorDetail) {
        var fieldName = field == null ? StringConstants.QUERY_ERROR : field;
        return Mono.just(ValidationError.of(fieldName, errorDetail));
    }

    /**
     * Reject whole class
     *
     * @param errorDetail ErrorDetail
     * @return Mono of ValidationError
     */
    default Mono<ValidationError> reject(final ErrorDetail errorDetail) {
        return rejectValue(null, errorDetail);
    }

    /**
     * Reject field if String value is null or blank
     *
     * @param model       target class
     * @param field       field to reject
     * @param errorDetail ErrorDetail
     * @return Mono of ValidationError
     */
    default Mono<ValidationError> rejectIfNullOrEmpty(final T model,
                                                      final String field,
                                                      final ErrorDetail errorDetail) {
        var value = getFieldValue(model, field);
        if (StringUtils.hasText(value) && !value.equals("[]")) {
            return Mono.empty();
        } else {
            return rejectValue(field, errorDetail);
        }
    }

    /**
     * Reject field if value is null
     *
     * @param model       target class
     * @param field       field to reject
     * @param errorDetail ErrorDetail
     * @return Mono of ValidationError
     */
    default Mono<ValidationError> rejectIfNull(final T model,
                                               final String field,
                                               final ErrorDetail errorDetail) {
        var value = getFieldValue(model, field);
        if (value == null) {
            return rejectValue(field, errorDetail);
        } else {
            return Mono.empty();
        }
    }

    /**
     * Reject field if value is out of range
     *
     * @param model       target class
     * @param min         minimal value
     * @param max         maximal value
     * @param field       field to reject
     * @param errorDetail ErrorDetail
     * @return Mono of ValidationError
     */
    default Mono<ValidationError> rejectIfOutOfRange(final T model,
                                                     final Double min,
                                                     final Double max,
                                                     final String field,
                                                     final ErrorDetail errorDetail) {
        Double value;
        var valueStr = getFieldValue(model, field);
        if (StringUtils.hasText(valueStr)) {
            try {
                value = Double.valueOf(valueStr);
            } catch (Exception e) {
                value = null;
            }
            if (value != null && (value < min || value > max)) {
                return rejectValue(field, errorDetail);
            }
        }
        return Mono.empty();
    }

    /**
     * Gwt value of specific field
     *
     * @param model target class
     * @param field field to get
     * @return value of field returned as String
     */
    default String getFieldValue(T model, String field) {
        final var tClass = model.getClass();
        try {
            final var tClassField = tClass.getField(field);
            return tClassField.get(model).toString();
        } catch (Exception e) {
            final var s1 = field.substring(0, 1).toUpperCase();
            final var methodName = "get" + s1 + field.substring(1);
            try {
                final var method = tClass.getMethod(methodName);
                return method.invoke(model).toString();
            } catch (Exception ex) {
                return "";
            }
        }
    }
}
