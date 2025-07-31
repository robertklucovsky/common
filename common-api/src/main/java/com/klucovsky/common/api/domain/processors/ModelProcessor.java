/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.domain.processors;

import com.klucovsky.common.constants.enums.RoundType;
import com.klucovsky.common.contract.model.DataModelObject;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Model processor interface to process validation, calculation
 * and storage of input model
 *
 * @param <T> input/output model class {@link DataModelObject}
 */
public interface ModelProcessor<T extends DataModelObject<T>> {

    /**
     * Validate, calculate and create {@link DataModelObject},
     * return errors and set the object status
     *
     * @param model      {@link DataModelObject}
     * @param allowDraft boolean
     * @return created {@link DataModelObject}
     */
    Mono<T> create(T model, boolean allowDraft);

    /**
     * Validate, calculate and update existing {@link DataModelObject},
     * return errors and set the object status
     *
     * @param id               {@link UUID id} of the original model
     * @param update           updated {@link DataModelObject model}
     * @param concurrencyToken entity version in db
     * @param allowDraft       boolean
     * @return updated {@link DataModelObject}
     */
    Mono<T> update(UUID id, T update, Long concurrencyToken, boolean allowDraft);

    /**
     * Validate, calculate and merge two existing {@link DataModelObject},
     * return errors and set the object status
     *
     * @param model      {@link DataModelObject}
     * @param id         id of deleted item
     * @param allowDraft boolean
     * @return merged {@link DataModelObject}
     */
    Mono<T> merge(T model, UUID id, boolean allowDraft);

    /**
     * Delete (hide) {@link DataModelObject model}
     *
     * @param id id of deleted model
     * @return {@link Boolean success}
     */
    Mono<Boolean> delete(UUID id);

    /**
     * Process validation and calculation when input associated fields are changed
     *
     * @param model {@link DataModelObject}
     * @return void
     */
    Mono<Void> processMessageCommand(T model);

    /**
     * Process validation and rounded calculation of item without touching the database
     *
     * @param model     {@link DataModelObject}
     * @param roundType RoundType
     * @return calculated price
     */
    Mono<T> calculate(T model, RoundType roundType);

    /**
     * Process validation and calculation of item without touching the database
     *
     * @param model {@link DataModelObject}
     * @return calculated price
     */
    Mono<T> calculate(T model);
}
