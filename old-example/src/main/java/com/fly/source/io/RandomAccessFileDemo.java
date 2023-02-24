package com.fly.source.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author 张攀钦
 * @date 2020-07-07-13:42
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
            final RandomAccessFile randomAccessFile = new RandomAccessFile("demo.txt","rw");
            System.out.println(randomAccessFile.getFilePointer());
            randomAccessFile.seek(2);
            System.out.println(randomAccessFile.getFilePointer());
            randomAccessFile.writeBytes("5");
            randomAccessFile.close();
    }
}
