package com.fly.study.guava.string;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

/**
 * @author 张攀钦
 * @date 2019-12-05-23:27
 * @description
 */
public class SplitterTest {

    @Test
    public void run0() {
//        会丢失最后一个元素
        final String[] split = "12#34#56#".split("#");
        System.out.println(Arrays.asList(split));
    }

    @Test
    public void run1() {
//        不会丢失最后一个元素
        final Splitter on = Splitter.on("#");
        System.out.println(on.split("12#34#56#"));
    }

    @Test
    public void run2() {
        System.out.println(Splitter.on(',').trimResults(CharMatcher.is('_')).splitToList("_a,_b_,c__"));
    }

    @Test
    public void run3() {
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux"));
    }


}
