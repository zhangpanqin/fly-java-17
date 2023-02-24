package com.fly.study.guava.joiner;

import com.google.common.base.Joiner;
import org.junit.jupiter.api.Test;

/**
 * @author 张攀钦
 * @date 2020-05-11-11:30
 */
public class JoinerTest {
    @Test
    public void run1(){
        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("Harry", null, "Ron", "Hermione"));
    }
}
