package com.fly.blog.volati;



/**
 * @author 张攀钦
 * @date 2020-06-20-17:54
 * 单例模式
 */

public class SingletonDemo2 {
    private  static SingletonDemo2 INSTANCE;

    private SingletonDemo2() {

    }
    public static SingletonDemo2 getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonDemo2.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonDemo2();
                }
            }
        }
        return INSTANCE;
    }
}
