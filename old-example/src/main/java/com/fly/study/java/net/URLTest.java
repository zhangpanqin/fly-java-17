package com.fly.study.java.net;

import cn.hutool.core.io.IoUtil;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author 张攀钦
 * @date 2019-09-18-22:05
 * @description URL 学习
 */
public class URLTest {
    @Test
    public void run1() throws IOException, URISyntaxException {
        URL url = new URL("http://www.thingjs.com/uearth/docs/index.html");
        InputStream inputStream = url.openStream();
        System.out.println(IoUtil.read(inputStream,"UTF-8"));
    }

    /**
     * 请求接口
     */
    @Test
    public void run2() throws IOException, URISyntaxException {
        URL url = new URL("http://www.thingjs.com/uinoUser/thingjs/user/userMsgCount?userId=12614");
        final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        System.out.println(IoUtil.read(urlConnection.getInputStream(), "UTF-8"));

    }
}
