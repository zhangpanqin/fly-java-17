package com.fly.study.java.concurrent._volatile;

/**
 * @author 张攀钦
 * @date 2020-02-14-05:19
 * @description 验证 volatile 不能保证原子性
 */
public class YanZhengNoAtomic {

    private static class Demo {
        volatile int num;

        public void add() {
            num++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.add();
            }).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(demo.num);
    }
}
