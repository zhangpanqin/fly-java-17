package com.fly.study.java.io.inputstream;

import lombok.Data;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author 张攀钦
 * @date 2019-12-03-15:28
 * @description
 */
@Data
public class DemoIo implements Serializable {
    private static final long serialVersionUID = 1714761892327112097L;
    private transient Object[] name = new Object[1];

    public void add(Object a) {
        name[0] = a;
    }

    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        s.readInt();
        name[0] = s.readObject();
    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.write(1);
        s.writeObject(name[0]);
    }


}
