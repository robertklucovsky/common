/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.exception.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class SystemErrorCodes {
    /**
     * E00_000 System error codes
     */
    public static final ErrorDetail E00_001 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_001", "Authorization failed");
    public static final ErrorDetail E00_002 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_002", "Insufficient privileges");
    public static final ErrorDetail E00_003 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_003", "Service unavailable, please try again later");
    public static final ErrorDetail E00_004 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_004", "The name of uploaded file is missing");
    public static final ErrorDetail E00_005 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_005", "Access denied");
    public static final ErrorDetail E00_006 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_006", "Endpoint not found");
    public static final ErrorDetail E00_007 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_007", "Missing body");
    public static final ErrorDetail E00_008 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_008", "Illegal argument");
    public static final ErrorDetail E00_009 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_009", "Object is being changed by someone else");
    public static final ErrorDetail E00_010 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_010", "DataSource for tenant ID not found");
    public static final ErrorDetail E00_011 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_011", "Access token is used instead of ID token");
    public static final ErrorDetail E00_012 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_012", "Date format not recognized");
    public static final ErrorDetail E00_013 =
            ErrorDetail.of(ErrorType.SYSTEM, "00_013", "Request not allowed");
}
