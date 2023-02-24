package com.fly.study.java.lambda.enitity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @author 张攀钦
 * @date 2019-09-25-20:38
 * @description 用户信息
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 7240658208223103787L;

    private Integer id;

    private String username;

    private Integer age;

    private Gender gender;
}

