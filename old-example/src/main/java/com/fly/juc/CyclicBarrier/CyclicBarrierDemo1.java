package com.fly.juc.CyclicBarrier;

import java.util.Objects;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo1 {
    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(20);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = null;
        for (int i = 0; i < 10; i++) {
            Thread tempThread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    CYCLIC_BARRIER.await();
                    System.out.println(Thread.currentThread().getName() + "阻塞过了，开始执行代码");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            if (Objects.isNull(thread)) {
                thread = tempThread;
            }
            tempThread.start();
        }
        System.out.println("线程都启动了");
        Thread.sleep(4000);
        thread.interrupt();

    }
}
