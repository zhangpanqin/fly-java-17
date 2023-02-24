package com.fly.study.crypt.tink;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.HMac;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.hybrid.HybridConfig;
import com.google.crypto.tink.hybrid.HybridKeyTemplates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * @author 张攀钦
 * @date 2019-12-09-14:19
 * @description
 */
public class HybridTest {

    @BeforeEach
    public void before() throws GeneralSecurityException {
        HybridConfig.register();
    }

    @Test
    public void run1() throws GeneralSecurityException, UnsupportedEncodingException {
        // 1. Generate the private key material.
        KeysetHandle privateKeysetHandle = KeysetHandle.generateNew(
                HybridKeyTemplates.ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM);

        // Obtain the public key material.
        KeysetHandle publicKeysetHandle =
                privateKeysetHandle.getPublicKeysetHandle();

        // ENCRYPTING

        // 2. Get the primitive.
        HybridEncrypt hybridEncrypt =
                publicKeysetHandle.getPrimitive(HybridEncrypt.class);

        byte[] plaintext = "张攀钦".getBytes("UTF-8");

        HMac a = SecureUtil.hmacMd5("张攀钦12412");
        String asdf = a.digestHex("张攀钦");
        byte[] contextinfo = HexUtil.decodeHex(asdf);
        // 3. Use the primitive.
        byte[] ciphertext = hybridEncrypt.encrypt(plaintext, contextinfo);

        // DECRYPTING

        // 2. Get the primitive.
        HybridDecrypt hybridDecrypt = privateKeysetHandle.getPrimitive(
                HybridDecrypt.class);

        // 3. Use the primitive.
        byte[] plaintext2 = hybridDecrypt.decrypt(ciphertext, contextinfo);
        System.out.println(new String(plaintext2, "utf-8"));
    }
}
