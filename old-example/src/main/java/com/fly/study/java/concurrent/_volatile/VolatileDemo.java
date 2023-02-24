package com.fly.study.java.concurrent._volatile;

/**
 * @author 张攀钦
 * @date 2020-02-04-14:38
 * @description
 * 验证可见性, volatile 标记的变量会从主存中读取,写直接写入到主存,并且让其余线程的本地内存失效
 * 一个线程修改对另一个线程可见
 */
public class VolatileDemo {

    private static class VolatileTask implements Runnable {
        boolean run = true;
        int i;

        @Override
        public void run() {
            while (run) {
                i++;
                // 加上 syso 是可以感知到 run 变化
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTask volatileTask = new VolatileTask();
        Thread thread = new Thread(volatileTask);
        thread.start();
        Thread.sleep(500);
        new Thread(()->{volatileTask.run = false;}).start();
    }
}
