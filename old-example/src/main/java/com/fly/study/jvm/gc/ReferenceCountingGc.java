
package com.fly.study.jvm.gc;

/**
 * @author 张攀钦
 * @date 2019-12-18-23:10
 * @description 验证 java 没有使用引用计数算法
 */
public class ReferenceCountingGc {
    public Object obj;

    private static final int _1MB = 1014 * 1014;

    /**
     * // 占用内存
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) throws InterruptedException {
         ReferenceCountingGc referenceCountingGc = new ReferenceCountingGc();
         ReferenceCountingGc referenceCountingGc2 = new ReferenceCountingGc();
         referenceCountingGc.obj=referenceCountingGc2;
         referenceCountingGc2.obj=referenceCountingGc;

        referenceCountingGc=null;
        referenceCountingGc2=null;

        System.gc();
        while (true){}
    }
}
