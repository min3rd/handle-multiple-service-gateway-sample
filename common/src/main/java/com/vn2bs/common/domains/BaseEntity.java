package com.vn2bs.common.domains;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<T> implements Serializable {

    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    @NotNull
    private Timestamp createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    @NotNull
    private Timestamp lastModifiedDate;
}
