package com.fly.study.java.concurrent.util;

import java.time.LocalDateTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author 张攀钦
 * @date 2019-12-15-17:44
 * @description 信号量学习
 */
public class SemaphoreTest {

    public static class Worker {
        private int i;
        private Semaphore semaphore;

        public Worker(int count, Semaphore semaphore) {
            this.i = count;
            this.semaphore = semaphore;
        }

        public void doSomething() throws BrokenBarrierException, InterruptedException {
            System.out.println("第 " + this.i + " 个士兵报道");
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println("第 " + this.i + " 个士兵完成任务"+ LocalDateTime.now());
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(2);
        final ExecutorService executorService = Executors.newFixedThreadPool(30);

        for (int i = 0; i < 10; i++) {
            Worker  worker=new Worker(i,semaphore);
            executorService.execute(()->{
                try {
                    worker.doSomething();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
