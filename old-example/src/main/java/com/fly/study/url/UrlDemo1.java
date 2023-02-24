package com.fly.study.url;

import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * @author 张攀钦
 * @date 2020-07-14-11:37
 */
public class UrlDemo1 {
    public static void main(String[] args) throws MalformedURLException {
        final URL url = new URL("http", "www.baidu.com", 80, "");
    }


    @Test
    public void run441() throws IOException {
        final URL url = new URL("http://www.baidu.com");
        final Object content = url.getContent();
        System.out.println(content);
    }

    @Test
    public void run22() {
        final URL resource = UrlDemo1.class.getClassLoader().getResource("demo.txt");
        System.out.println(resource);
        System.out.println(resource.getQuery());
    }

    @Test
    public void run222() throws MalformedURLException {
        final URL url = new URL("https://oauth2:yWrqofzT3DcVHayVsG3m@git.uinnova.com/thingjs/plan/thingjs-demo/mobile-plan.git?a=1#frament");
        System.out.println(url.getQuery());
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getAuthority());
        System.out.println(url.getRef());
        System.out.println(url.getFile());
        System.out.println(url.getUserInfo());

    }

    @Test
    public void run56() throws IOException {
        final URL url = new URL("http://localhost:8080/test/api");
        final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("name", "ceshi1123");
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        final OutputStream outputStream = urlConnection.getOutputStream();
        String sendData = "username=张攀钦";
        outputStream.write(sendData.getBytes(StandardCharsets.UTF_8));
        final int responseCode = urlConnection.getResponseCode();
        System.out.println(responseCode);
        final InputStream inputStream = urlConnection.getInputStream();
        byte[] data = new byte[1024];
        final int read = inputStream.read(data);
        final String s = new String(data, 0, read);
        System.out.println(s);
        inputStream.close();
    }

    @Test
    public void run33() throws IOException {
        final URL url = new URL("file:/Users/zhangpanqin/github/fly-java/target/classes/demo.txt");
        final URLConnection urlConnection = url.openConnection();
        final InputStream inputStream = urlConnection.getInputStream();
        final String read = IoUtil.read(inputStream, StandardCharsets.UTF_8);
        System.out.println(read);
    }
}
