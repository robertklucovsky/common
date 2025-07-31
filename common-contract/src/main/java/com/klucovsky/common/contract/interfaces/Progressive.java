/*
 * Copyright (c) 2020-2023, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.contract.interfaces;

import com.klucovsky.common.constants.enums.ProgressionFlag;

/**
 * Interface for model that can be in progress
 *
 * @param <T> T object
 */
public interface Progressive<T> {

    /**
     * Set progression flag
     *
     * @param progressionFlag {@link ProgressionFlag flag}
     * @return updated T object
     */
    T setStatusFlag(ProgressionFlag progressionFlag);
}
