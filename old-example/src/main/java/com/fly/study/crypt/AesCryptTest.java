package com.fly.study.crypt;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import org.junit.jupiter.api.Test;

/**
 * @author 张攀钦
 * @date 2019-12-07-16:15
 * @description 对称加密
 */
public class AesCryptTest {
    @Test
    public void run1() {
        AES aes = SecureUtil.aes();

    }
}
