package com.fly.study.java.file;

import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author 张攀钦
 * @date 2019-09-18-22:04
 * @description 学习 JarFile api
 */
public class JarFileTest {
    /**
     * 获取 jar 包中的内容
     */


    @Test
    public void run3() throws URISyntaxException, IOException {
        final JarFile jarFile = new JarFile("/Users/zhangpanqin/.m2/repository/com/beust/jcommander/1.72/jcommander-1.72.jar");
        final JarEntry jarEntry  = jarFile.getJarEntry("META-INF/MANIFEST.MF");
        final InputStream inputStream = jarFile.getInputStream(jarEntry);
        System.out.println(IoUtil.read(inputStream,"utf-8"));
    }
}
