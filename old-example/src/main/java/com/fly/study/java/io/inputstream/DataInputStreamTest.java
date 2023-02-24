package com.fly.study.java.io.inputstream;

import org.junit.jupiter.api.Test;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 张攀钦
 * @date 2019-09-20-08:05
 * @description DataInputStreamTest
 */
public class DataInputStreamTest {
    @Test
    public void run1() throws IOException {
        File file =new File("demo.txt");
        FileInputStream fileInputStream =new FileInputStream(file);
        DataInputStream dataInputStream =new DataInputStream(fileInputStream);
        System.out.println(dataInputStream.readUTF());
        dataInputStream.close();
    }

}
