package com.fly.study.crypt.tink;

import cn.hutool.core.util.HexUtil;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.signature.SignatureConfig;
import com.google.crypto.tink.signature.SignatureKeyTemplates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * @author 张攀钦
 * @date 2019-12-09-14:46
 * @description 数据签名
 */
public class RsaTest {

    private KeysetHandle privateKeySetHandle;
    private KeysetHandle publicKeySetHandle;

    private static final String privateKeySetPath="private.json";
    private static final String publicKeySetPath="public.json";
    @BeforeEach
    public void before() throws GeneralSecurityException, IOException {
        SignatureConfig.register();
        privateKeySetHandle = CleartextKeysetHandle.read(
                JsonKeysetReader.withFile(new File(privateKeySetPath)));
        publicKeySetHandle = CleartextKeysetHandle.read(
                JsonKeysetReader.withFile(new File(publicKeySetPath)));
    }

    @Test
    public void run1() throws GeneralSecurityException, IOException {

        KeysetHandle keysetHandle = KeysetHandle.generateNew(SignatureKeyTemplates.RSA_SSA_PKCS1_3072_SHA256_F4);
        // and write it to a file.
        String keysetFilename = "private.json";
        CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withFile(
                new File(keysetFilename)));
        String publicKeyset="public.json";

        KeysetHandle publicKeysetHandle = keysetHandle.getPublicKeysetHandle();
        CleartextKeysetHandle.write(publicKeysetHandle, JsonKeysetWriter.withFile(
                new File(publicKeyset)));
    }

    @Test
    public void run2() throws GeneralSecurityException, UnsupportedEncodingException {
        PublicKeySign primitive = privateKeySetHandle.getPrimitive(PublicKeySign.class);
        byte[] bytes = "张攀钦1134123541235".getBytes("utf-8");
        byte[] sign = primitive.sign(bytes);
        System.out.println(HexUtil.encodeHexStr(bytes));
        System.out.println(HexUtil.encodeHexStr(sign));
    }

    @Test
    public void run3() throws GeneralSecurityException {
        String signature="017def7c0374efdd5cdd87d79988097ceb8a561e51251332746825cb46fc5548c7edbf901bf1094f0111a0268bf94488d818b01e7ddff505a7f9330d58f4db37040bafc379cad55a636a1377e1b405c0a5d7279c5aededcfacbec090bc7b0140221c1a047f4746fbb4ea7e946c6dbf8cb3245805f1beb580568f699b62a76e07190b110283e4c010327fb4b80b8952a4a6543c816335a3b740868ca60e999f6538d0865b555c0e4e42a1ff70e086217835a50cc8e8ba17fdc74aab748bfa7c9b2d2bd9b99568f361f5d635253d00ea57d9a61fc24d023321a4d659319aaf254bdf707157484e2287b2050a98e3d344f319194339450d34790319ef6e692c89fe8383c3a58f99489f22d984ad39ea679473c0d79020c25b9e2226f19be54ed7827ac971205347ed71db5c1caa9896bc12202f8dbdf894ae011b375096e8e725a7396287e70fd8d137edffbbc138b9f6133897bf8184a7db2b29d43b8b9824bbd5ec490526e057f8b163853881de0a95fa80237285e5a5ff098785dc2897f73bff47e3e11012";
        PublicKeyVerify primitive = publicKeySetHandle.getPrimitive(PublicKeyVerify.class);
        primitive.verify(HexUtil.decodeHex(signature),HexUtil.decodeHex("e5bca0e69480e992a631313334313233353431323335"));
    }
}
