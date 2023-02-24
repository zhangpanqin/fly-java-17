package com.fly.source;

/**
 * @author 张攀钦
 * @date 2020-06-17-12:17
 * 验证锁信息查看,blocked 状态的
 */
public class ThreadDemo2 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            synchronized (ThreadDemo.class) {
                while (true) {
                }
            }
        }, "测试2");
        thread.start();
        Thread.sleep(1000);
        Thread thread2 = new Thread(() -> {
            synchronized (ThreadDemo.class) {
                while (true) {
                }
            }
        }, "测试3");
        thread2.start();
        thread2.join();
    }
}
