package com.fly.study.java.operator;

import org.junit.jupiter.api.Test;

/**
 * @author 张攀钦
 * @date 2019-12-03-14:22
 * @description 位运算符
 */
public class OperatorDemo1 {

    /**
     * 左移 n << b
     * n * 2^b
     */

    @Test
    public void run2() {
        System.out.println(2 << 1);
        System.out.println(3 << 2);

    }


    /**
     * 右移 n >> b
     * n / 2^b
     */
    @Test
    public void run1() {
        int a = 4;
        System.out.println(a >> 1);
    }

}
