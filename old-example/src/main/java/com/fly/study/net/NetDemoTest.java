package com.fly.study.net;

import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author 张攀钦
 * @date 2020-07-15-10:25
 */
public class NetDemoTest {

    private URL url;
    private URL httpUrl;

    @BeforeEach
    public void before() throws MalformedURLException {
        url = new URL(new URL("jar:file:/usr/local/var/www/a.jar!/"), "com/alibaba/fastjson/JSON.class");
        httpUrl = new URL(new URL("jar:http://localhost:1000/a.jar!/"), "com/alibaba/fastjson/JSON.class");
    }

    @Test
    public void run1() throws IOException {
        JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
        jarConnection.connect();
        final InputStream inputStream = jarConnection.getInputStream();
        final String read = IoUtil.read(inputStream, StandardCharsets.UTF_8);
        System.out.println(read);
    }

    @Test
    public void run2() throws IOException {
        JarURLConnection jarConnection = (JarURLConnection) httpUrl.openConnection();
        jarConnection.connect();
        final InputStream inputStream = jarConnection.getInputStream();
        final String read = IoUtil.read(inputStream, StandardCharsets.UTF_8);
        System.out.println(read);
    }

    @Test
    public void run3() throws IOException {
        JarURLConnection jarConnection = (JarURLConnection) httpUrl.openConnection();
        final JarEntry jarEntry = jarConnection.getJarEntry();
        System.out.println(jarEntry.getName());
    }

    @Test
    public void run31() throws IOException {
        JarURLConnection jarConnection = (JarURLConnection) httpUrl.openConnection();
        final JarFile jarFile = jarConnection.getJarFile();
        final JarEntry jarEntry = jarFile.getJarEntry("com/alibaba/fastjson/JSONPath.class");
        System.out.println(jarEntry.getName());

    }

    @Test
    public void run4() throws MalformedURLException, URISyntaxException {
        final URL resource = NetDemoTest.class.getClassLoader().getResource("demo.txt");
        System.out.println(resource.toURI());
    }

    @Test
    public void run5() throws UnknownHostException {
        final InetSocketAddress inetSocketAddress = new InetSocketAddress("www.baidu.com", 2020);
        final InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress inetAddress : allByName) {
            System.out.println(inetAddress.getHostAddress());
        }
    }
}
