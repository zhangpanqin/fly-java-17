package com.fly.study.java.lambda.client;

import org.junit.jupiter.api.Test;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author 张攀钦
 * @date 2019-09-26-21:34
 * @description reduce 测试 api
 */
public class Reduce {
    @Test
    public void run1() {
        final Stream<String> a1 = Stream.of("a1", "a3", "a5");
        final String aaa = a1.reduce("aaa", (t1, t2) -> {
            System.out.println(t1);
            System.out.println(t2);

            StringJoiner stringJoiner = new StringJoiner("--");
            stringJoiner.add(t1).add(t2);
            return stringJoiner.toString();
        });
        System.out.println(aaa);

    }

    @Test
    public void run2() {
        final Stream<Integer> limit = Stream.iterate(1, UnaryOperator.identity()).limit(10);
        System.out.println(limit.parallel().reduce(2, (t1, t2) -> t1 + t2, BinaryOperator.maxBy((t1, t2) ->
                {
                    System.out.println(t2);
                    System.out.println(t1);
                    return t2 - t1;
                }
        )));
    }

    @Test
    public void run6() {
        final Stream<Integer> limit = Stream.iterate(1, UnaryOperator.identity()).limit(100);
        final Integer reduce = limit.parallel().reduce(0, (t1, t2) -> {
            System.out.println(t1);
            System.out.println(t2);
            return t1 + t2;
        });
        System.out.println(reduce);
    }

    @Test
    public void run3() {
        final Stream<Integer> limit = Stream.iterate(1, UnaryOperator.identity()).limit(10);
        BiFunction<Integer, Integer, Integer> biFunction = (t1, t2) -> t1 + t2;
        BiFunction<Integer, Integer, Integer> integerIntegerIntegerBiFunction = biFunction.andThen((t1 ->
        {
            String str="andThen:"+(t1+1);
            System.out.println(str);
            return t1 + 1 ;
        }));
        System.out.println(limit.parallel().reduce(2, integerIntegerIntegerBiFunction, BinaryOperator.maxBy((t1, t2) ->
                {
                    String str="maxBy"+t1.toString()+"-"+t2.toString();
                    System.out.println(str);
                    return t1 - t2;
                }
        )));
    }

    @Test
    public void run4() {
        final Stream<String> a = Stream.iterate("a", UnaryOperator.identity()).limit(20);
        System.out.println(a.reduce((t1, t2) -> t1 + "-" + t2).get());
    }

}
