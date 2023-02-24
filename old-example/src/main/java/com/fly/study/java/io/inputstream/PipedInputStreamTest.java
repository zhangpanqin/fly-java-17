package com.fly.study.java.io.inputstream;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author 张攀钦
 * @date 2019-09-22-17:08
 * @description 测试管道流
 */
public class PipedInputStreamTest {
    @Test
    public void run1() throws IOException, InterruptedException {
        PipedInputStream pipedInputStream = new PipedInputStream(100);


        PipedOutputStream pipedOutputStream = new PipedOutputStream();

        pipedInputStream.connect(pipedOutputStream);
        new Thread(()->{
            int count=1;
            while (count<=5){
                if(count<=5){
                    String str=String.valueOf(count);
                    try {
                        pipedOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                        count++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }).start();

        new Thread(()->{
            int count=6;
            while (count<=10){
                if(count<=10){
                    String str=String.valueOf(count);
                    try {
                        pipedOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                        count++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }).start();

        new Thread(()->{
            int count=11;
            while (count<=15){
                if(count<=15){
                    String str=String.valueOf(count);
                    try {
                        pipedOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                        count++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }).start();

        new Thread(()->{
            byte[] b=new byte[100];

                try {
                    final int read = pipedInputStream.read(b);
                    System.out.println(new String(b,0,read,"UTF-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }).start();





        pipedOutputStream.close();
        Thread.currentThread().join();
    }

}
