package com.fly.blog.jol;

import org.openjdk.jol.info.ClassLayout;
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;

/**
 * @author Aleksey Shipilev
 */
public class JOLSample_14_FatLocking {
    public static void main(String[] args) throws Exception {
        // 延迟六秒执行例子，创建的 a 为可偏向对象
        TimeUnit.SECONDS.sleep(6);
        final A a = new A();
        ClassLayout layout = ClassLayout.parseInstance(a);
        out.println("**** 查看初始化 a 的对象头");
        out.println(layout.toPrintable());
        // 这里模拟获取锁，当前获取到的锁为 偏向锁
        Thread t = new Thread(() -> {
            synchronized (a) {
            }
        });
        t.start();
        // 阻塞等待获取 t 线程完成
        t.join();
        out.println("**** t 线程获得锁之后");
        out.println(layout.toPrintable());
        final Thread t2 = new Thread(() -> {
            synchronized (a) {
                // a 的存在两个想成竞争锁，锁升级为轻量级锁
                out.println("**** t2 第二次获取锁");
                out.println(layout.toPrintable());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 开启 t3 线程模拟竞争，t3 会自旋获得锁，由于 t2 阻塞了 3 秒，t3 自旋是得不到锁的，锁升级为重量级锁
        final Thread t3 = new Thread(() -> {
            synchronized (a) {
                out.println("**** t3 不停获取锁");
                out.println(layout.toPrintable());
            }
        });
        t2.start();
        // 为了 t2 先获得锁，这里阻塞 10ms ,再开启 t3 线程
        TimeUnit.MILLISECONDS.sleep(10);
        t3.start();t2.join();t3.join();
        // 验证 gc 可以使锁降级
        System.gc();
        out.println("**** After System.gc()");
        out.println(layout.toPrintable());
    }
    public static class A {}
}