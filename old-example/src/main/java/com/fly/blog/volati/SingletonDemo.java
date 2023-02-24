package com.fly.blog.volati;

/**
 * @author 张攀钦
 * @date 2020-06-20-17:54
 * 单例模式
 */
public class SingletonDemo {

    private static final SingletonDemo INSTANCE = new SingletonDemo();

    private SingletonDemo() {
    }

    public static SingletonDemo getInstance() {
        return SingletonDemo.INSTANCE;
    }
}
