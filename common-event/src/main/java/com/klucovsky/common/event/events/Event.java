/*
 * Copyright (c) 2023-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.event.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

/**
 * Event message class
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Event<T> {

    /**
     * Model that triggered the event
     */
    private T model;

    /**
     * Model id if the model isn't present
     */
    private UUID id;

    /**
     * The name of the operation that was performed on the model
     */
    private String eventOperation;

    /**
     * Static creator of EventMessage without id
     *
     * @param model          model triggered the event
     * @param eventOperation operation name
     * @param <T>            model class
     * @return new EventMessage
     */
    public static <T> Event<T> of(final T model, final String eventOperation) {
        return of(model, null, eventOperation);
    }

    /**
     * Static creator of EventMessage without model
     *
     * @param id             id of model triggered the event
     * @param eventOperation operation name
     * @param <T>            model class
     * @return new EventMessage
     */
    public static <T> Event<T> of(UUID id, final String eventOperation) {
        return of(null, id, eventOperation);
    }
}
