/*
 * Copyright (c) 2020-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.infrastructure.entities;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Abstract class for persistable entity
 */
@Getter
@SuppressWarnings("unchecked")
public abstract class PersistableEntity<T> implements Persistable<UUID> {

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    public T setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return (T) this;
    }

    public T setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return (T) this;
    }

    @Override
    public boolean isNew() {
        return getId() == null;
    }
}
