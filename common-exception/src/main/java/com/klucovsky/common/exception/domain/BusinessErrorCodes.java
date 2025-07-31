/*
 * Copyright (c) 2023, KPS Design s.r.o.
 * All rights reserved.
 */

package com.klucovsky.common.exception.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class BusinessErrorCodes {
    /**
     * E01_000 Common error codes
     */
    public static final ErrorDetail E01_001 =
            ErrorDetail.of(ErrorType.BUSINESS, "01_001", "Unable to recognize request body");
    public static final ErrorDetail E01_002 =
            ErrorDetail.of(ErrorType.BUSINESS, "01_002", "Object with the same name already exists");
    public static final ErrorDetail E01_003 =
            ErrorDetail.of(ErrorType.BUSINESS, "01_003", "Field is required");
    public static final ErrorDetail E01_004 =
            ErrorDetail.of(ErrorType.BUSINESS, "01_004", "Entity not found");
    public static final ErrorDetail E01_005 =
            ErrorDetail.of(ErrorType.BUSINESS, "01_005", "List contains business errors");
    public static final ErrorDetail E01_006 =
            ErrorDetail.of(ErrorType.WARNING, "01_006", "List contains warnings");
}
