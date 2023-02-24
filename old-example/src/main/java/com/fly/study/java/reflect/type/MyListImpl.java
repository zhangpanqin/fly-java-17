package com.fly.study.java.reflect.type;

import org.junit.jupiter.api.Test;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/**
 * @author 张攀钦
 * @date 2019-12-08-23:17
 * @description
 */
public class MyListImpl implements IMyList<String,Integer> {

    @Test
    public void run1() {
        final Type[] genericInterfaces = MyListImpl.class.getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            if(genericInterface instanceof ParameterizedType){
                ParameterizedType type= (ParameterizedType) genericInterface;
                System.out.println(Arrays.toString(type.getActualTypeArguments()));
                System.out.println(type.getOwnerType());
                System.out.println(type.getRawType());
            }
        }
    }

    @Test
    public void run2() {
        final TypeVariable<Class<IMyBounds>>[] typeParameters = IMyBounds.class.getTypeParameters();
        for (TypeVariable<Class<IMyBounds>> typeParameter : typeParameters) {
            System.out.println(Arrays.toString(typeParameter.getBounds()));
        }
    }

}
