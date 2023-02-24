package com.fly.study.jol;

import lombok.Data;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author 张攀钦
 * @date 2020-06-06-09:06
 */
@Data
public class JavaObjectLayoutTest {
    private Integer test1;

    public static void main(String[] args) throws Exception {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
    }


    public static class A {
        boolean f;
    }
}
