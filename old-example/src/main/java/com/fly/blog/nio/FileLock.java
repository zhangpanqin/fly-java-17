package com.fly.blog.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CountDownLatch;

/**
 * @author 张攀钦
 * @date 2020-07-08-17:27
 */
public class FileLock {
    public static void main(String[] args) throws IOException, InterruptedException {
        final Path path = Paths.get("file_lock.txt");
        final FileChannel open = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.READ);
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            try (final java.nio.channels.FileLock lock = open.lock(0, 3, false)) {
                System.out.println("获取到锁0-3,代码没有被阻塞");
                Thread.sleep(10000);
                final ByteBuffer wrap = ByteBuffer.wrap("aaa".getBytes());
                open.position(0);
                open.write(wrap);
                Thread.sleep(10000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            try (final java.nio.channels.FileLock lock = open.lock(1, 3, true)) {
                System.out.println("获取到锁4-7,代码没有被阻塞");
                final ByteBuffer wrap = ByteBuffer.wrap("bbb".getBytes());
                open.position(4);
                open.write(wrap);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }).start();
        countDownLatch.await();
        open.close();
    }
}
