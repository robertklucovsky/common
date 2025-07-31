/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.exception.errors;

import lombok.*;
import com.klucovsky.common.exception.domain.ErrorDetail;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@EqualsAndHashCode
@AllArgsConstructor(staticName = "of")
@RequiredArgsConstructor(staticName = "of")
public class ValidationError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1976278445231175144L;

    private final String field;
    private final ErrorDetail detail;
    private Set<ValidationError> children;
}
