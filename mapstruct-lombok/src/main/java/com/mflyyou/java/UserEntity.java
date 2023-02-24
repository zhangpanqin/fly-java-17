package com.mflyyou.java;

import lombok.Getter;
import java.io.Serial;

@Getter
public class UserEntity extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
