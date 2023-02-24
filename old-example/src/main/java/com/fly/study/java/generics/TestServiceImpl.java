package com.fly.study.java.generics;

import org.junit.jupiter.api.Test;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author 张攀钦
 * @date 2019-09-16-07:42
 * @description
 */
public class TestServiceImpl implements TestService<String> {
    @Override
    public String getT(String t) {
        return t;
    }
    
    @Test
    public void run3() {
        ParameterizedType parameterizedType = (ParameterizedType) TestServiceImpl.class.getGenericInterfaces()[0];
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument);
        }
    }

}

class TestServiceImpl2<T> implements TestService<T> {

    @Override
    public T getT(T t) {
        return t;
    }
}

class TestServiceImpl3<T> implements TestService<String> {

    @Override
    public String getT(String s) {
        return null;
    }
}