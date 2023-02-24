package com.fly.study.crypt.tink;

import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.proto.KeyTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author 张攀钦
 * @date 2019-12-09-13:39
 * @description
 */
public class TinkTest {

    @BeforeEach
    public void before() throws GeneralSecurityException {
        TinkConfig.register();
    }

    @Test
    public void run1() throws GeneralSecurityException, IOException {
        KeyTemplate keyTemplate = AeadKeyTemplates.AES128_GCM;
        KeysetHandle keysetHandle = KeysetHandle.generateNew(keyTemplate);
        String keysetFilename = "my_keyset.json";
        CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withFile(
                new File(keysetFilename)));
        KeysetHandle keysetHandle2 = CleartextKeysetHandle.read(
                JsonKeysetReader.withFile(new File(keysetFilename)));
    }
}

