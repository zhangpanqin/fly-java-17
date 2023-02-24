package com.fly.study.guava.collection;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

/**
 * @author 张攀钦
 * @date 2019-12-05-21:32
 * @description
 */
public class SetsTest {
    @Test
    public void run1() {
        Sets.SetView<String> difference = Sets.difference(Sets.newHashSet("1", "@"), Sets.newHashSet("1", "2"));
        System.out.println(difference);
    }
}
