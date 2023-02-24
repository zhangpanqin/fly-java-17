package com.fly.study.java.io.inputstream;

import lombok.Data;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 张攀钦
 * @date 2019-12-08-21:08
 * @description
 */
public class ObjectInOrOutStreamTest implements Serializable {
    @Test
    public void run1() throws IOException, ClassNotFoundException {
        final MyList myList = new MyList();
        myList.setName("张攀钦");
        myList.setAge("18");
        myList.setA(100);
        final File file = new File("demo.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(myList);
        final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        final Object o = objectInputStream.readObject();
        System.out.println(o);
    }

}

@Data
class MyList implements Serializable {
    private static final long serialVersionUID = 2940246471120908898L;
    private String name;
    private String age;
    private transient int a=0;

    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.a= s.readInt();
        this.name = (String) s.readObject();
        this.age= (String) s.readObject();
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        s.defaultWriteObject();
        s.writeInt(a);
        s.writeObject(this.name);
        s.writeObject(this.age);
    }
}