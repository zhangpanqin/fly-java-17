package com.fly.study.java.concurrent.thread.daemon;

/**
 * @author 张攀钦
 * @date 2019-12-15-10:52
 * @description 守护线程
 */
public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(() -> {
            try {
                System.out.println(1);
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(2);

            }
        });
        thread.setDaemon(true);
        thread.start();

        final Thread thread2 = new Thread(() -> {
            try {
                System.out.println(3);
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println(4);

            }
        });
        thread2.start();

//        thread2.join();
        System.out.println(6);

    }

}
