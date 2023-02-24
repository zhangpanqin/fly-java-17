package com.fly.study.io;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

/**
 * @author 张攀钦
 * @date 2020-06-14-21:36
 * 测试随机 io
 */
public class RandomAccessFileDemo {

    @Test
    public void run33() throws IOException {
        final File path = Paths.get("demo.txt").toAbsolutePath().toFile();
        final RandomAccessFile randomAccessFile = new RandomAccessFile(path,"rw");
        final byte[] bytes = "a".getBytes(StandardCharsets.UTF_8);
        final FileChannel channel = randomAccessFile.getChannel();
        final FileLock lock = channel.lock();
        final ByteBuffer wrap = ByteBuffer.wrap(bytes);
        channel.write(wrap);
        lock.release();
        final ByteBuffer allocate = ByteBuffer.allocate(1024);
        final int read = channel.read(allocate,0);
        final byte[] array = allocate.array();
        System.out.println(new String(array, StandardCharsets.UTF_8));
        randomAccessFile.close();
    }
}
