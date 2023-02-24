package com.fly.study.java.concurrent._volatile;

import lombok.Data;
import java.util.concurrent.TimeUnit;

/**
 * @author 张攀钦
 * @date 2020-02-14-04:28
 * @description
 */
public class YanZhengKeJianXing2 {

    @Data
    private static class Demo {
//        不加 volatile 的时候，main 线程 和 B 线程会一直循环
        int num;

        public void change() {
            this.num = 60;
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        new Thread(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                demo.num=3;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(demo);
        },"A 线程").start();

        new Thread(()->{
            System.out.println(demo.num);
            synchronized (YanZhengKeJianXing2.class){}
//            System.out.println(111);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (demo.num==0){}
            System.out.println(demo);
        },"B 线程").start();
        while (demo.num==0){

        }
        System.out.println(Thread.currentThread().getName()+"获取的demo.num:"+demo.num);
    }
}
