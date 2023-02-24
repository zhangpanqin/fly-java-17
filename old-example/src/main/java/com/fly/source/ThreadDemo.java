package com.fly.source;

/**
 * @author 张攀钦
 * @date 2020-06-17-11:42
 * 11
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(20000);
                while (true) {
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "测试");
        thread.start();
        thread.join();
    }
}
