package com.fly.source;

/**
 * @author 张攀钦
 * @date 2020-06-16-19:11
 */
public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> classTest = Class.forName("com.fly.source.ClassTest", true, ClassDemo.class.getClassLoader());
    }
}
