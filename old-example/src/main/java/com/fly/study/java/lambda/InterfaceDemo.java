package com.fly.study.java.lambda;

/**
 * @author 张攀钦
 * @date 2019-09-29-14:26
 * @description 测试接口
 */
@FunctionalInterface
public interface InterfaceDemo {


    int getAge();


    default String getName(){
        return "我叫阿良，我是一名剑客";
    }
    default String getName1(){
        return "我叫阿良，我是一名剑客";
    }

    static String getGender(){
        return "男";
    }
    static String getGender1(){
        return "男";
    }
        public static void main(String[] args) {
                System.out.println(1);

        }
}
