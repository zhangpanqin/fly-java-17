package com.fly.study.java.path;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 张攀钦
 * @date 2019-09-18-20:50
 * @description Paths 用法学习
 */
public class PathsTest {
    @Test
    public void run1() {
        Path path = Paths.get("/demo");
        System.out.println(path.toAbsolutePath());
    }

    @Test
    public void run2() {
//        相对于动作目录 user.dir
//        /Users/zhangpanqin/github/fly-java/demo
        System.out.println(Paths.get("demo").toAbsolutePath());
//        获取绝对路径
//        /demo
        System.out.println(Paths.get("/demo").toAbsolutePath());
    }

    @Test
    public void run3() throws IOException {
        Path path = Paths.get("demo/a-test.txt");
        Path parent = path.getParent();
        if(!Files.exists(parent)){
            Files.createDirectories(parent);
        }
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }

}
