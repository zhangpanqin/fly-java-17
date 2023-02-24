package com.fly.source;

import cn.hutool.core.io.IoUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author 张攀钦
 * @date 2020-06-16-20:39
 */
public class ProcessBuilderDemo {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        Process ll = processBuilder.command("/bin/ls", "/").start();
        InputStream inputStream = ll.getInputStream();
        String read = IoUtil.read(inputStream, StandardCharsets.UTF_8);
        System.out.println(read);
    }
}
