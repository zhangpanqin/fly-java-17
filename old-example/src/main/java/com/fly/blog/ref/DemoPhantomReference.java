package com.fly.blog.ref;

/**
 * @author 张攀钦
 * @date 2020-07-11-23:07
 */
public class DemoPhantomReference {
    private int a;
    private DemoCleaner demoCleaner;

    private int[] aa = new int[1024 * 1024 * 100];

    public DemoPhantomReference(int a) {
        this.a = a;
        this.demoCleaner = new DemoCleaner(String.valueOf(a), new GCDemo(a, this));
    }


    public static class GCDemo implements Runnable {
        private int b;
        private DemoPhantomReference demoPhantomReference;

        public GCDemo(int a, DemoPhantomReference demoPhantomReference) {
            this.b = a;
            this.demoPhantomReference = null;
        }

        @Override
        public void run() {
            System.out.println("将 DemoPhantomReference.a 置为 null");
        }
    }
}
