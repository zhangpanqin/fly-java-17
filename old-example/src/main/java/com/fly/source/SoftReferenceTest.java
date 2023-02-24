package com.fly.source;


import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * -XX:+PrintGCDetails -Xmx5m
 */
public class SoftReferenceTest {
    public static final List<Data_1M> data_1MList = new ArrayList<>();

    public static SoftReference<Data_1M> DATA_1_M_SOFT_REFERENCE=new SoftReference<>(new Data_1M(),new ReferenceQueue());

    public static class Data_1M {
        private byte[] data;

        public Data_1M() {
            // 1M
            this.data = new byte[1024 * 1024];
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 16; i++) {
            try {
                //不停新增堆大小
                data_1MList.add(new Data_1M());
                //新增后查看SoftReference中的对象是否被回收
                System.out.println("第" + i + ":" + DATA_1_M_SOFT_REFERENCE.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(20000);
    }
}