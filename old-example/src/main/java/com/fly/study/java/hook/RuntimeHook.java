package com.fly.study.java.hook;

/**
 * @author 张攀钦
 * @date 2019-12-04-15:23
 * @description
 */
public class RuntimeHook {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(() -> {
            System.out.println("最后关闭");
        }));
        for (int i = 0; i < 100000; i++) {
            System.out.println("========================");
        }
    }
}
