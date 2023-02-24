package com.fly.study.java.lambda;

import com.fly.study.java.lambda.enitity.Gender;
import com.fly.study.java.lambda.enitity.UserDTO;
import org.junit.jupiter.api.Test;
import java.util.Optional;

/**
 * @author 张攀钦
 * @date 2019-11-11-16:22
 * @description 学习 Optional
 */
public class OptionalDemo {


    @Test
    public void run4() {
        UserDTO al = UserDTO.builder().age(18).id(1).username("陈平安").gender(Gender.MALE).build();
        Optional<UserDTO> al1 = Optional.of(al);
        System.out.println(al1);
    }

}
