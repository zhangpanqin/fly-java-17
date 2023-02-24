package com.fly.study.java.io.inputstream;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 张攀钦
 * @date 2019-09-19-07:16
 * @description io 学习
 */
public class FileInputStreamTest {

    /**
     * 不关流
     */

    @Test
    public void run11() throws IOException, InterruptedException {
        int count=0;
        while (count<=100){
            File file =new File("demo.txt");
            final FileInputStream fileInputStream = new FileInputStream(file);
            byte[] content=new byte[1024];
            final int read = fileInputStream.read(content);
            System.out.println(new String(content, 0, read, "UTF-8"));
            System.out.println(count);
            count++;
            fileInputStream.close();
        }
        Thread.sleep(10000000);
    }

    @Test
    public void run1() {
        final Path path = Paths.get("demo.txt");
        try (InputStream inputStream = Files.newInputStream(path, StandardOpenOption.READ);InputStream inputStream1 = Files.newInputStream(path, StandardOpenOption.READ);){
            byte[] b=new byte[1024];
            int length=0;
            while ((length=inputStream.read(b))!=-1){
                final String s = new String(b, 0,length,"UTF-8");
                System.out.println(s);
            }

            byte[] b1=new byte[1024];
            int length1=0;
            while ((length1=inputStream1.read(b1))!=-1){
                final String s = new String(b1, 0,length1,"UTF-8");
                System.out.println(s);
            }

            Thread.sleep(10000);
        } catch (IOException | InterruptedException e) {
           throw new RuntimeException(e);
        }

    }

    /**
     * 测试文件是否可读
     */
    @Test
    public void run2() throws IOException {
        File file =new File("/Users/zhangpanqin/Desktop/test27841757922789759827.temp2");
        if(file.exists()==false){
            file.createNewFile();
        }
        // 设置文件所有者和所有人的读权限,ownerOnly 是否只设置所有者权限
//        file.setReadable(false, false);
        try(final FileInputStream fileInputStream = new FileInputStream(file);){
            byte[] b=new byte[1024];
            final int read = fileInputStream.read(b);
            String s = new String(b, 0, read, "UTF-8");
            System.out.println(s);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Test
    public void run4() throws IOException {
        File file =new File("demo.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        fileInputStream.skip(10L);
        byte[] b=new byte[1024];
        final int read = fileInputStream.read(b);
        String s = new String(b, 0, read, "UTF-8");
        System.out.println(s);
        fileInputStream.close();
    }


    /**
     * 测试文件是否可以被多个流打开
     */
    @Test
    public void run3() throws IOException {
        File file =new File("demo.txt");
        File file2 =new File("demo.txt");
        FileInputStream fileInputStream =null;
        FileInputStream fileInputStream2 =null;
        try{
            fileInputStream=new FileInputStream(file);
            fileInputStream2=new FileInputStream(file2);
            byte[] b=new byte[1024];
            final int read = fileInputStream.read(b);
            String s = new String(b, 0, read, "UTF-8");
            System.out.println(s);


            byte[] b2=new byte[1024];
            final int read2 = fileInputStream2.read(b2);
            String s2 = new String(b2, 0, read2, "UTF-8");
            System.out.println(s2);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if(fileInputStream!=null){
                fileInputStream.close();
            }
            if(fileInputStream2!=null){
                fileInputStream2.close();
            }
        }

    }

}
