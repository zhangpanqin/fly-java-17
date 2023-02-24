package com.fly.study.java.classloader;

import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

/**
 * @author 张攀钦
 * @date 2020-04-13-17:18
 * 测试 11
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getResource("meta-index"));
//        系统类加载器
        System.out.println(System.getProperty("sun.boot.class.path"));
//        扩展类加载器
        System.out.println(System.getProperty("java.ext.dirs"));

//        final URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
//        ClassLoaders
//        final URL[] urLs = bootstrapClassPath.getURLs();
//        Stream.of(urLs).forEach(item -> {
//            System.out.println(item.getFile());
//        });

    }

    @Test
    public void run99() {
        final String property = System.getProperty("java.ext.dirs");
        final String[] split = property.split(":");
        Stream.of(split).forEach(item -> {
            System.out.println(item);
        });
    }


    @Test
    public void run555() {
        System.out.println(Test2.class.getResource("name"));
    }

    @Test
    public void run222() {
        final InputStream resourceAsStream = Test2.class.getClassLoader().getResourceAsStream("META-INF/maven/com.alibaba/fastjson/pom.properties");
        System.out.println(IoUtil.read(resourceAsStream, StandardCharsets.UTF_8));
    }

    @Test
    public void ttt() {
        System.out.println("ttt");
    }

    @Test
    public void run24() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        final Class<Test2> aClass = (Class<Test2>) systemClassLoader.loadClass("com.fly.study.java.classloader.Test2");
        final Test2 o = aClass.newInstance();
        o.ttt();
    }

    @Test
    public void run33() throws IOException {
        final Path path = Paths.get("/Users/zhangpanqin/github/fly-java/demo.txt");
        final byte[] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    @Test
    public void run2() {
        final File file = new File("/Users/zhangpanqin/github/fly-java/demo.txt");
        final byte[] bytes = cn.hutool.core.io.FileUtil.readBytes(file);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    @Test
    public void run3() throws IOException {
        final File file = new File("/Users/zhangpanqin/github/fly-java/src/main/resources/fastjson-1.2.68.jar");
        final JarFile jarFile = new JarFile(file);
        final JarEntry jarEntry = jarFile.getJarEntry("META-INF/LICENSE.txt");
        final InputStream inputStream = jarFile.getInputStream(jarEntry);
        System.out.println(IoUtil.read(inputStream, StandardCharsets.UTF_8));
        IoUtil.close(inputStream);
    }


    public static void main2(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(Paths.get("").toAbsolutePath());
    }
}
