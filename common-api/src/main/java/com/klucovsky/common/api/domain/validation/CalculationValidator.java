/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.validation;

import com.klucovsky.common.contract.interfaces.ValidatableObject;

/**
 * Calculation validator for application-specific objects.
 *
 * @param <T> object extends {@link ValidatableObject}
 */
public interface CalculationValidator<T extends ValidatableObject> extends Validator<T> {
}
