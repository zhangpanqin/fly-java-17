package com.fly.blog.nio;

import java.nio.ByteBuffer;

/**
 * @author 张攀钦
 * @date 2020-07-11-20:26
 */
public class BufferNio {
    //    -Xmx100m -XX:MaxDirectMemorySize=1g
    public static void main(String[] args) throws InterruptedException {
        System.out.println("申请 100 m `HeapByteBuffer`");
        while (true) {
            ByteBuffer.allocateDirect(100 * 1024 * 1024);
            System.gc();
            System.out.println("申请 directbuffer 成功");
        }
    }
}
