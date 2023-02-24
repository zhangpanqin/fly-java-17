package com.fly.blog.juc;

import lombok.Data;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 张攀钦
 * @date 2020-06-22-22:07
 * 研究内存泄漏
 */
public class ThreadLocalDemo {
    private static ExecutorService executorService = Executors.newFixedThreadPool(20);
    private static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            executorService.submit(() -> {
                try {
                    threadLocal.set(new Demo());
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (Objects.nonNull(threadLocal)) {
                        // 为防止内存泄漏,当前线程用完,清除掉 value
//                        threadLocal.remove();
                    }
                }
            });
        }
        Thread.sleep(5000);
        threadLocal = null;
        while (true) {
            Thread.sleep(2000);
        }
    }

    @Data
    static class Demo {
        //
        private Demo[] demos = new Demo[1024 * 1024 * 5];
    }
}
