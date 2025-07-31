/*
 * Copyright (c) 2020-2024, KPS Design s.r.o.
 * All rights reserved.
 *
 */

package com.klucovsky.common.api.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.Persistable;

import java.util.Date;
import java.util.UUID;

/**
 * Abstract class for persistable entity
 */
@Getter
@SuppressWarnings("unchecked")
public abstract class PersistableEntity<T> implements Persistable<UUID> {

    @CreatedDate
    private Date createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private Date modifiedAt;

    @LastModifiedBy
    private String modifiedBy;

    @Version
    private Long concurrencyToken;

    @Override
    @JsonIgnore
    public boolean isNew() {
        return getCreatedAt() == null;
    }

    public T setConcurrencyToken(Long concurrencyToken) {
        this.concurrencyToken = concurrencyToken;
        return (T) this;
    }

    public T setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return (T) this;
    }

    public T setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return (T) this;
    }

    public T setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
        return (T) this;
    }

    public T setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return (T) this;
    }
}
