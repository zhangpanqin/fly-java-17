package com.fly.juc.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo2 {
    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    CYCLIC_BARRIER.await();
                    System.out.println(Thread.currentThread().getName() + "阻塞过了，开始执行代码");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
        System.out.println("线程都启动了");

    }
}
