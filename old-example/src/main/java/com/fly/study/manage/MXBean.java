package com.fly.study.manage;

/**
 * @author 张攀钦
 * @date 2020-07-01-15:51
 */
public class MXBean {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                synchronized (MXBean.class) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(1);

                }
            }
        }).start();
    }
}
