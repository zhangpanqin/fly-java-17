package com.fly.study.java.concurrent.util;

import lombok.Data;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 张攀钦
 * @date 2019-12-15-17:57
 * @description
 */
public class ExchangerData {

    @Data
    public static class Worker {
        private final int count;
        private String name;

        public Worker(int count){
            this.count=count;
        }
    }

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(50);
        final Exchanger<Worker> objectExchanger = new Exchanger<>();
        for (int i = 1; i <= 50; i++) {
            final Worker worker = new Worker(i);
            executorService.execute(()->{
                try {
                    worker.setName(Thread.currentThread().getName());
                    final Worker exchange = objectExchanger.exchange(worker);
                    System.out.println(Thread.currentThread().getName()+"获得"+exchange);
                } catch (InterruptedException e) {
                }
            });
        }
        executorService.shutdown();
    }
}
