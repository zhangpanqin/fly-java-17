package com.fly.source.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author 张攀钦
 * @date 2020-07-06-20:19
 */
public class FileInputStreamDemo {

    /**
     * 内存映射
     */
    public static void main(String[] args) throws IOException {
        final FileInputStream fileOutputStream = new FileInputStream("demo.txt");
        final FileChannel channel = fileOutputStream.getChannel();
        final MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 3, 5);
        final byte[] bytes = new byte[5];
        map.get(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
        channel.close();
    }

    public static void test1() throws IOException {
        final FileInputStream fileInputStream = new FileInputStream("demo.txt");
        final FileChannel channel = fileInputStream.getChannel();
        fileInputStream.skip(3);
        byte[] bytes = new byte[1024];
        fileInputStream.read(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }
}
