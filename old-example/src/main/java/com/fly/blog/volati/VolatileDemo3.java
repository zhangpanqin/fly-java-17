package com.fly.blog.volati;

/**
 * @author 张攀钦
 * @date 2020-06-20-22:42
 */
public class VolatileDemo3 {
    private static volatile Demo[] demos = new Demo[2];

//    @sun.misc.Contended
    private static final class Demo {
        private volatile long x = 0L;
        private volatile long pading1, pading2, pading3, pading4, pading5, pading6, pading7;
    }

    static {
        demos[0] = new Demo();
        demos[1] = new Demo();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (long i = 0; i < 10000_0000L; i++) {
                demos[0].x = i;
            }
        });
        Thread thread = new Thread(() -> {
            for (long i = 0; i < 10000_0000L; i++) {
                demos[1].x = i;
            }
        });
        long start = System.nanoTime();
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        long end = System.nanoTime();
        long runSecond = (end - start) / 100_0000;
        System.out.println("运行毫秒:" + runSecond);
    }


}
