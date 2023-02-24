package com.fly.study.java.classloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 张攀钦
 * @date 2020-04-19-14:51
 */
public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        final Path path = Paths.get("/Users/zhangpanqin/github/fly-java/target2/classes/com/fly/study/java/classloader/Test2.class");

        try {
            final byte[] bytes = Files.readAllBytes(path);
            return defineClass("com.fly.study.java.classloader.Test2", bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        final MyClassLoader myClassLoader = new MyClassLoader();
        final Class<?> nam = myClassLoader.findClass("nam");
        System.out.println(nam.getClassLoader());
        System.out.println(Test2.class.getClassLoader());
        System.out.println(Test2.class == nam);
    }
}
