package com.fly.study.java.lambda.enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @author 张攀钦
 * @date 2019-09-25-21:17
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBO implements Serializable {
    private static final long serialVersionUID = -5724927488853529215L;

    private String name;

    private Integer age;
}
