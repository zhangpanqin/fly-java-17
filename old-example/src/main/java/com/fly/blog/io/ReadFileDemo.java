package com.fly.blog.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author 张攀钦
 * @date 2020-06-30-11:22
 */
public class ReadFileDemo {
    public static void main(String[] args) throws URISyntaxException {
        final URL resource = ReadFileDemo.class.getClassLoader().getResource("5g.txt");
        final URI uri = resource.toURI();
        final File file = new File(uri);
        System.out.println("开始执行");
        new Thread(() -> {
            while (true) {
                try (final FileOutputStream fileOutputStream = new FileOutputStream(file);) {
                    for (int i = 0; i < 10000; i++) {
                        fileOutputStream.write(i);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
