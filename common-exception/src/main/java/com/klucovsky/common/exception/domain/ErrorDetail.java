/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.exception.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@AllArgsConstructor(staticName = "of")
public class ErrorDetail implements Serializable {

    @Serial
    private static final long serialVersionUID = -2417106485317494206L;

    private final ErrorType type;
    private final String code;
    private final String defaultMessage;
}
