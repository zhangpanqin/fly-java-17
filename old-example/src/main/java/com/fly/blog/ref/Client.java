package com.fly.blog.ref;

/**
 * @author 张攀钦
 * @date 2020-07-11-23:19
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Object a = new DemoPhantomReference(i);
            System.gc();
            a = null;
        }
    }
}
