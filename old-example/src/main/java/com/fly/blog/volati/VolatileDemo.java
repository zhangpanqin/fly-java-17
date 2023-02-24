package com.fly.blog.volati;

/**
 * @author 张攀钦
 * @date 2020-06-20-14:33
 */
public class VolatileDemo {
    private static volatile int a = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (a == 0) {

            }
        }, "线程 1").start();
        System.out.println("修改 a=1 之前");
        Thread.sleep(3000);
        a = 1;
        System.out.println("修改 a=1 之后");
    }
}
