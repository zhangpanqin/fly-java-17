package com.fly.juc;


/**
 * @author 张攀钦
 * @date 2020-07-22-14:13
 */
public class ThreadInterrupt {
    public static void main(String[] args) {
        final Thread thread = new Thread(() -> {
            long current = System.currentTimeMillis();
            while (true) {
                final boolean interrupted = Thread.currentThread().isInterrupted();
                System.out.println(interrupted);
                if (interrupted) {
                    return;
                }
                long end = System.currentTimeMillis();
                while (System.currentTimeMillis() - current > 5000) {
                    current = System.currentTimeMillis();
                    break;
                }

            }
        });
        thread.start();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt();
        }).start();
    }
}
