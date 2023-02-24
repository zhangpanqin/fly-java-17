package com.fly.study.guava.reflect;

import com.google.common.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2019-12-06-00:20
 * @description
 */
public class TypeTokenTest {
    @Test
    public void run1() {
        final TypeToken typeToken = new TypeToken<List<String>>(){};
        final Type type = typeToken.getType();
        System.out.println(typeToken.getRawType());
        System.out.println(type.getTypeName());
    }
}
