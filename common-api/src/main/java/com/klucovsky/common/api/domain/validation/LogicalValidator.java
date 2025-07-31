/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.validation;

import com.klucovsky.common.contract.interfaces.ValidatableObject;

/**
 * Logical validator for application-specific objects.
 *
 * @param <T> object extends {@link ValidatableObject}
 */
public interface LogicalValidator<T extends ValidatableObject> extends Validator<T> {
}
