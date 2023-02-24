package com.fly.source;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2020-06-16-17:30
 * 测试获取权限修饰符
 */
public class ModifierTest {

    @Test
    public void run2(){
        Class<List> listClass = List.class;
        int modifiers = listClass.getModifiers();
        System.out.println(Modifier.isInterface(modifiers));

        Class<ArrayList> arrayListClass = ArrayList.class;
        int modifiers1 = arrayListClass.getModifiers();
        System.out.println(Modifier.isInterface(modifiers1));
    }
}
