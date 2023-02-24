package com.fly.study.java.concurrent.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 张攀钦
 * @date 2019-12-15-17:03
 * @description
 */
public class CyclicBarrierTest {

    public static class Worker{
        private int i;
        private CyclicBarrier cyclicBarrier;
        public Worker(int count,CyclicBarrier cyclicBarrier){
            this.i=count;
            this.cyclicBarrier=cyclicBarrier;
        }
        public void doSomething() throws BrokenBarrierException, InterruptedException {
            System.out.println("第 "+this.i+" 个士兵报道");
            Thread.sleep(300);
            cyclicBarrier.await();
        }
    }
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("运行完成打印");
        });
        for (int i = 0; i < 10; i++) {
            final Worker worker = new Worker(i, cyclicBarrier);
            new Thread(() -> {
                try {
                    worker.doSomething();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
