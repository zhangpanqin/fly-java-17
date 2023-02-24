package com.fly.study.guava.reflect;

import com.google.common.reflect.Invokable;
import org.junit.jupiter.api.Test;

/**
 * @author 张攀钦
 * @date 2019-12-06-00:19
 * @description
 */
public class InvokableTest {
    @Test
    public void run1() throws NoSuchMethodException {
        final Invokable<?, Object> run1 = Invokable.from(InvokableTest.class.getMethod("run1"));
        System.out.println(run1.isPublic());
    }

}
