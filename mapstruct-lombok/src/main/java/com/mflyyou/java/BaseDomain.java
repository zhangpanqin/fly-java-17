package com.mflyyou.java;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class BaseDomain {
    private Long id;
    private Integer version;
}