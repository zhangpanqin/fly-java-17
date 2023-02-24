package com.fly.study.nginx;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author 张攀钦
 * @date 2020-03-18-22:22
 */
public class HttpSecureLink {
    public static final String site = "http://localhost:8888";
    public static final String secret = " hello";


    public static String createLink(String path, long expireTime) {
        final long l = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")) + expireTime;
        String time = String.valueOf(l);
        String md5 = Base64.encodeBase64URLSafeString(DigestUtils.md5("abc" + time + path + secret));
        String url = site + path + "?md5=" + md5 + "&expires=" + time;
        return url;
    }

    public static void main(String[] args) {

        System.out.println(createLink("/s/a.jpg", 10L));

    }
}
