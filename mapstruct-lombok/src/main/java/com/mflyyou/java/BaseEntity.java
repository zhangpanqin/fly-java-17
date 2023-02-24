package com.mflyyou.java;

import lombok.Getter;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Getter
public abstract class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private Instant createdAt;
    private String createdBy;
    private Integer version;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
