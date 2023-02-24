package com.fly.study.java.file;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * @author 张攀钦
 * @date 2019-09-17-07:16
 * @description
 */
public class FileDemo1 {
    @Test
    public void run1() {
        System.out.println(File.separator);
        System.out.println(File.pathSeparator);

    }

    /**
     * 创建临时文件,返回的绝对路径
     */
    @Test
    public void run2() throws IOException {
        File test = File.createTempFile("test", ".temp");
//         /var/folders/ls/lc9l29z96y7gj6pbqkdlj7km0000gn/T/test1969069036151944835.temp
        System.out.println(test.getPath());
        System.out.println(test.getAbsolutePath());

        File tempFile = File.createTempFile("test2", ".temp2", new File("/Users/zhangpanqin/Desktop"));
        System.out.println(tempFile.getPath());
        System.out.println(tempFile.getAbsolutePath());

        final URI uri = tempFile.toURI();
        System.out.println(uri);


    }

    /**
     * 测试相对路径创建文件
     * 相对路径相对于 工程目录下（System.getProperty("user.dir")），
     */
    @Test
    public void run3(){
//        /Users/zhangpanqin/github/fly-java
        System.out.println(System.getProperty("user.dir"));

//        验证相对于（System.getProperty("user.dir")），
        System.setProperty("user.dir","/Users/zhangpanqin/Desktop");
//        /Users/zhangpanqin/github/fly-java
        File file = new File("");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());

        File file1 = new File("var");
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
    }

    /**
     * 设置文件 读写执行权限
     */
    @Test
    public void run4(){
        File file =new File("/Users/zhangpanqin/Desktop/test27841757922789759827.temp2");
        // 设置文件所有者和所有人的读权限,ownerOnly 是否只设置所有者权限
        file.setReadable(true, false);
    }
}
