package com.fly.study.java.lambda;

import com.fly.study.java.lambda.enitity.Gender;
import com.fly.study.java.lambda.enitity.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author 张攀钦
 * @date 2019-09-27-16:58
 * @description Predicate测试
 */
public class PredicateTest {

    private UserDTO userDTO1;
    private UserDTO userDTO2;
    @BeforeEach
    public void before(){
        userDTO1=UserDTO.builder().age(18).id(1).username("陈平安").gender(Gender.MALE).build();
        userDTO2=UserDTO.builder().age(19).id(2).username("宁姚").gender(Gender.FEMALE).build();
    }
    @Test
    public void or() {
        Predicate<UserDTO> predicate=(userDTO)->userDTO.getId()>3;
        predicate= predicate.or(t2 -> t2.getUsername().contains("宁"));
        System.out.println(predicate.test(userDTO2));
    }
    @Test
    public void and() {
        Predicate<UserDTO> predicate=(userDTO)->userDTO.getId()>1;
        predicate= predicate.and(t2 -> t2.getUsername().contains("平"));
        System.out.println(predicate.test(userDTO1));
    }
    @Test
    public void negate() {
        Predicate<UserDTO> predicate=(userDTO)->userDTO.getId()>1;
        predicate= predicate.negate();
        System.out.println(predicate.test(userDTO1));
    }

    @Test
    public void isEqual() {
        final Predicate<UserDTO> equal = Predicate.isEqual(userDTO1);
        System.out.println(equal.test(userDTO2));
    }

    @Test
    public void run5() {
        System.out.println(Objects.equals(userDTO1, userDTO2));
    }

}
