package com.fly.study;

import org.junit.jupiter.api.Test;
import java.nio.channels.SelectionKey;

/**
 * @author 张攀钦
 * @date 2020-07-21-00:15
 */
public class Demo2 {
    @Test
    public void run1() {
        System.out.println(SelectionKey.OP_READ);
        System.out.println(SelectionKey.OP_ACCEPT);
        System.out.println(SelectionKey.OP_CONNECT);
        System.out.println(SelectionKey.OP_WRITE);
    }
}
