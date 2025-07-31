package com.klucovsky.common.exception.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import com.klucovsky.common.exception.dto.ErrorDto;
import com.klucovsky.common.exception.errors.ValidationError;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.NONE)
public class ValidationErrorMapper {
    /**
     * Map list of validation errors to map
     *
     * @param errors list of validation errors
     * @return mapped errors
     */
    public static Map<String, ErrorDto> map(Set<ValidationError> errors) {
        return errors == null
                ? null
                : errors.stream().collect(Collectors.toMap(ValidationError::getField, ValidationErrorMapper::mapError));
    }

    public static ErrorDto mapError(ValidationError error) {
        return ErrorDto.of(error.getDetail().getType().name(),
                error.getDetail().getCode(),
                error.getDetail().getDefaultMessage(),
                ValidationErrorMapper.map(error.getChildren()));
    }
}
