package com.fly.study.crypt;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.UnsupportedEncodingException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author 张攀钦
 * @date 2019-12-09-9:41
 * @description
 */
public class HutoolTest {

    /**
     * 非对称加密
     */
    @Test
    public void run1() {
        KeyPair keyPair = SecureUtil.generateKeyPair("RSA");
        PrivateKey aPrivate = keyPair.getPrivate();
        byte[] encoded = aPrivate.getEncoded();
        System.out.println(aPrivate.getAlgorithm());
        PublicKey aPublic = keyPair.getPublic();
        System.out.println(aPublic.getAlgorithm());

        String content = "test中文";

//随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

//构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

//加密
        byte[] encrypt = aes.encrypt(content);
//解密
        byte[] decrypt = aes.decrypt(encrypt);

//加密为16进制表示
        String encryptHex = aes.encryptHex(content);
//解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
    }

    @Test
    public void run2() {
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        PrivateKey aPrivate = pair.getPrivate();
        byte[] encoded = aPrivate.getEncoded();
        PublicKey aPublic = pair.getPublic();
    }

    @Test
    public void run3() {
        String PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIL7pbQ+5KKGYRhw7jE31hmA" + "f8Q60ybd+xZuRmuO5kOFBRqXGxKTQ9TfQI+aMW+0lw/kibKzaD/EKV91107xE384qOy6IcuBfaR5lv39OcoqNZ" + "5l+Dah5ABGnVkBP9fKOFhPgghBknTRo0/rZFGI6Q1UHXb+4atP++LNFlDymJcPAgMBAAECgYBammGb1alndta" + "xBmTtLLdveoBmp14p04D8mhkiC33iFKBcLUvvxGg2Vpuc+cbagyu/NZG+R/WDrlgEDUp6861M5BeFN0L9O4hz" + "GAEn8xyTE96f8sh4VlRmBOvVdwZqRO+ilkOM96+KL88A9RKdp8V2tna7TM6oI3LHDyf/JBoXaQJBAMcVN7fKlYP" + "Skzfh/yZzW2fmC0ZNg/qaW8Oa/wfDxlWjgnS0p/EKWZ8BxjR/d199L3i/KMaGdfpaWbYZLvYENqUCQQCobjsuCW" + "nlZhcWajjzpsSuy8/bICVEpUax1fUZ58Mq69CQXfaZemD9Ar4omzuEAAs2/uee3kt3AvCBaeq05NyjAkBme8SwB0iK" + "kLcaeGuJlq7CQIkjSrobIqUEf+CzVZPe+AorG+isS+Cw2w/2bHu+G0p5xSYvdH59P0+ZT0N+f9LFAkA6v3Ae56OrI" + "wfMhrJksfeKbIaMjNLS9b8JynIaXg9iCiyOHmgkMl5gAbPoH/ULXqSKwzBw5mJ2GW1gBlyaSfV3AkA/RJC+adIjsRGg" + "JOkiRjSmPpGv3FOhl9fsBPjupZBEIuoMWOC8GXK/73DHxwmfNmN7C9+sIi4RBcjEeQ5F5FHZ";

        RSA rsa = new RSA(PRIVATE_KEY, null);

        String a = "2707F9FD4288CEF302C972058712F24A5F3EC62C5A14AD2FC59DAB93503AA0FA17113A020EE4EA35EB53F" + "75F36564BA1DABAA20F3B90FD39315C30E68FE8A1803B36C29029B23EB612C06ACF3A34BE815074F5EB5AA3A" + "C0C8832EC42DA725B4E1C38EF4EA1B85904F8B10B2D62EA782B813229F9090E6F7394E42E6F44494BB8";

        byte[] aByte = HexUtil.decodeHex(a);
        byte[] decrypt = rsa.decrypt(aByte, KeyType.PrivateKey);

//Junit单元测试
        Assertions.assertEquals("虎头闯杭州,多抬头看天,切勿只管种地", StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));

    }

    /**
     * 公钥私钥加密解密
     */
    @Test
    public void run4() throws UnsupportedEncodingException {
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        PrivateKey aPrivate = pair.getPrivate();
//        私钥
        byte[] encoded = aPrivate.getEncoded();
        PublicKey aPublic = pair.getPublic();
//        公钥
        byte[] encoded1 = aPublic.getEncoded();
        RSA rsa = new RSA(encoded, encoded1);

        byte[] encrypt = rsa.encrypt("虎头闯杭州,多抬头看天,切勿只管种地", KeyType.PublicKey);
        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);
        System.out.println(new String(decrypt, "UTF-8"));

    }
}
