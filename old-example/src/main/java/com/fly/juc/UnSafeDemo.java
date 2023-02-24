package com.fly.juc;

import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;
import java.lang.reflect.Field;

/**
 * @author 张攀钦
 * @date 2020-08-23-17:16
 */
public class UnSafeDemo {
    @Test
    public void run1() throws NoSuchFieldException, IllegalAccessException {
        final Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        final Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        System.out.println(unsafe);
    }
}
