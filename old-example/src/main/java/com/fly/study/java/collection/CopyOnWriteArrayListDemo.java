package com.fly.study.java.collection;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 张攀钦
 * @date 2019-12-03-15:58
 * @description
 */
public class CopyOnWriteArrayListDemo {

    @Test
    public void run11() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < 1000; i++) {
            copyOnWriteArrayList.add(i);
        }
    }
    
}
