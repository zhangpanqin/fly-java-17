package com.fly.study.java.io.inputstream;

import com.fly.study.java.generics.ArgsParent;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author 张攀钦
 * @date 2019-09-22-15:47
 * @description
 */
public class ObjectInputStreamTest {

    @Test
    public void run1() throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream =new FileOutputStream("object.tmp");
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
        final ArgsParent argsParent = new ArgsParent();
        argsParent.setName("测试");
        objectOutputStream.writeObject(argsParent);
        FileInputStream fileInputStream =new FileInputStream("object.tmp");
        final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        final Object o = objectInputStream.readObject();
        System.out.println(o);
        objectInputStream.close();
        objectOutputStream.close();
    }


}
