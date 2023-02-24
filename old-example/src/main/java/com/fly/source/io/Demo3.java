package com.fly.source.io;

/**
 * @author 张攀钦
 * @date 2020-07-07-14:15
 */
public class Demo3 {
    static int a = 0;

    public static void main(String[] args) {
        System.out.println(getPosition());
        System.out.println(getPosition());
        System.out.println(getPosition());
        System.out.println(getPosition());

    }

    public static int getPosition() {
        return a++;
    }
}
