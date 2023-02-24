package com.mflyyou.java;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class User extends BaseDomain {
    private String name;
}