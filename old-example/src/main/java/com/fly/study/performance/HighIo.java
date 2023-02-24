package com.fly.study.performance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 张攀钦
 * @date 2020-06-02-19:36
 */
public class HighIo {
    public static void main(String[] args) throws IOException {
        read1();
    }

    public static void read1() {
        final File file = new File("/Users/zhangpanqin/学习资料/付费视频/a.zip");
        byte[] a = new byte[100];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            while (fileInputStream.read(a) != -1) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
