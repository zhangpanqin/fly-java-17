package com.fly.study.java.lambda;

import org.junit.jupiter.api.Test;
import java.util.function.BiFunction;

/**
 * @author 张攀钦
 * @date 2019-09-27-12:58
 * @description BiFunctionTest
 */
public class BiFunctionTest {
    @Test
    public void run1() {
        BiFunction<Integer,Integer,Integer> biFunction = (t1,t2)->t1+t2;
        final BiFunction<Integer, Integer, String> biFunction1
        = biFunction.andThen(t1 -> t1.toString()+"-1字符串");
        final BiFunction<Integer, Integer, String> integerIntegerStringBiFunction = biFunction1.andThen(t1 -> t1 + "-2字符串");
        System.out.println(integerIntegerStringBiFunction.apply(2, 3));
    }
}
