package com.fly.blog.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Objects;

/**
 * @author 张攀钦
 * @date 2020-07-11-23:07
 */
public class DemoCleaner extends PhantomReference<Object> {
    private static final ReferenceQueue<Object> dummyQueue = new ReferenceQueue();
    private Runnable runnable;

    static {
        new Thread(
                () -> {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                            DemoCleaner demoCleaner = (DemoCleaner) dummyQueue.poll();
                            if (Objects.nonNull(demoCleaner)) {
                                demoCleaner.clean();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }

    public DemoCleaner(String s, Runnable runnable) {
        super(s, dummyQueue);
        this.runnable = runnable;
    }

    public void clean() {
        System.out.println("clean 执行了");
        runnable.run();
    }

}
