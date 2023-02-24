package com.fly.source.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 张攀钦
 * @date 2020-07-07-17:01
 */
public class FileChannelLockDemo {
    private static final String FILE_NAME = "demo_lock.txt";

    static {
        final Path file_name = Paths.get(FILE_NAME);
        if (!Files.exists(file_name)) {
            try {
                Files.createFile(file_name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        long a = 0 + 11;
        final Thread thread = new Thread(() -> {
            try {
                method(a, 10);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();
    }

    public static void method(long position, long size) throws IOException {
        final FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME, true);
        final FileChannel channel = fileOutputStream.getChannel();
        final byte[] bytes = "1234".getBytes(StandardCharsets.UTF_8);
        final ByteBuffer wrap = ByteBuffer.allocate(1024);
        wrap.put(bytes);
        final ByteBuffer compact = wrap.compact();
        channel.write(wrap, position);
        channel.force(true);
        channel.close();
    }
}
