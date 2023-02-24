package com.fly.study.cache;

import lombok.Data;
import java.time.Instant;

/**
 * 测试伪共享缓存
 */
public class FalseSharingTest {

    public static void main(String[] args) throws InterruptedException {
        testFalseSharing();
    }

    private static void testFalseSharing() throws InterruptedException {

        final Pointer pointer = new Pointer();
        final long l = Instant.now().toEpochMilli();

        final Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                pointer.a++;
            }
        });

        final Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                pointer.b++;
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        final long l1 = Instant.now().toEpochMilli();
        System.out.println(l1 - l);
        System.out.println(pointer);

    }

}
@Data
class Pointer {
    volatile long a;
    volatile long b;
}