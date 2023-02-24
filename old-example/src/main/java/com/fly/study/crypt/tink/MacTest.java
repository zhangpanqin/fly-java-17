package com.fly.study.crypt.tink;

import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.mac.MacConfig;
import com.google.crypto.tink.mac.MacKeyTemplates;
import org.junit.jupiter.api.Test;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * @author 张攀钦
 * @date 2019-12-09-13:55
 * @description
 */
public class MacTest {
    @Test
    public void run1() throws GeneralSecurityException, UnsupportedEncodingException {
        MacConfig.register();
        // 1. Generate the key material.
        KeysetHandle keysetHandle = KeysetHandle.generateNew(
                MacKeyTemplates.HMAC_SHA256_128BITTAG);

        // 2. Get the primitive.
        Mac mac = keysetHandle.getPrimitive(Mac.class);

        String str="张攀钦";
        byte[] data = str.getBytes("UTF-8");
        // 3. Use the primitive to compute a tag,
        byte[] tag = mac.computeMac(data);

        // ... or to verify a tag.
        mac.verifyMac(tag, data);
    }
}
