package com.fly.study.java.clazz;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 张攀钦
 * @date 2019-12-04-19:37
 * @description
 */
public class ClassLoaderDemo {

    /**
     * 获取 classpath 路径
     */
    @Test
    public void run1() {
        URL resource = ClassLoaderDemo.class.getClassLoader().getResource("");
        System.out.println(resource.getPath());
    }

    /**
     * 相对于当前类下的路径
     */
    @Test
    public void run2() {
        URL resource = ClassLoaderDemo.class.getResource("");
        System.out.println(resource.getPath());
    }

    /**
     * 当前项目下的路径
     */
    @Test
    public void run3() {
        Path path = Paths.get("");
        System.out.println(path.toAbsolutePath());
    }

    /**
     * 获取当前项目路径
     */
    @Test
    public void run4() {
        File file = new File("");
        System.out.println(file.getAbsolutePath());
    }

}
