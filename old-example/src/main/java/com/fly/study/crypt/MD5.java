package com.fly.study.crypt;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.HexUtil;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 张攀钦
 * @date 2019-12-07-15:46
 * @description MD5 加密解密算法
 */
public class MD5 {

    @Test
    public void before() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        InputStream resourceAsStream = MD5.class.getClassLoader().getResourceAsStream("scene.txt");
        String read = IoUtil.read(resourceAsStream, "UTF-8");
        MessageDigest md5 = MessageDigest.getInstance("md5");
        md5.update(read.getBytes(StandardCharsets.UTF_8));
//        md5.update("张攀钦".getBytes(StandardCharsets.UTF_8));
        byte[] digest = md5.digest();
//        fbc793f02a922870d6454c8d1e1571d3
        System.out.println(HexUtil.encodeHexStr(digest));
    }
}
