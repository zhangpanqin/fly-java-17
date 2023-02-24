package com.fly.study.java.lambda.client;

import org.junit.jupiter.api.Test;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 张攀钦
 * @date 2019-09-26-21:23
 * @description 测试 stream 流 iterate generate
 */
public class Client2 {

    /**
     * 在上次结果上进行运算
     */
    @Test
    public void iterate() {
        System.out.println(Stream.iterate(2, n -> n + 2).limit(5).collect(Collectors.toList()));
    }

    @Test
    public void iterate2() {
        System.out.println(Stream.iterate(2, UnaryOperator.identity()).limit(5).collect(Collectors.toList()));
    }

    @Test
    public void generate() {
        System.out.println(Stream.generate(() -> Math.random()).limit(5).collect(Collectors.toList()));
    }

    @Test
    public void concat() {
        final Stream<String> a1 = Stream.of("a1", "a2", "a3", "a4");
        final Stream<String> b1 = Stream.of("b1", "b2", "b3", "b4");
        System.out.println(Stream.concat(a1, b1).collect(Collectors.toList()));
    }

}
