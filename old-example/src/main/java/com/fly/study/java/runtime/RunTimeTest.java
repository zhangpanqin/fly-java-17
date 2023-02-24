package com.fly.study.java.runtime;

import org.junit.jupiter.api.Test;

/**
 * @author 张攀钦
 * @date 2019-12-16-10:28
 * @description
 */
public class RunTimeTest {

    @Test
    public void run1() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
