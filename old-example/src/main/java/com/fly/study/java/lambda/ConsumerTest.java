package com.fly.study.java.lambda;

import org.junit.jupiter.api.Test;
import java.util.function.Consumer;

/**
 * @author 张攀钦
 * @date 2019-09-27-17:27
 * @description Consumer api 测试
 */
public class ConsumerTest {

    @Test
    public void run1() {
        Consumer<String> consumer =(userDTO)->{
            System.out.println(1);
        };
        Consumer<String> consumer1 = consumer.andThen((userDTO) -> System.out.println(2));
        final Consumer<String> stringConsumer = consumer1.andThen(userDTO -> System.out.println(3));
        stringConsumer.accept("null");
    }

}
