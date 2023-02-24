package com.fly.study.java.object;

import lombok.Data;

/**
 * @author 张攀钦
 * @date 2019-12-03-13:53
 * @description 测试克隆接口
 */
@Data
public class CloneableDemo implements Cloneable {
    private String name;

    @Override
    protected CloneableDemo clone() throws CloneNotSupportedException {
        System.out.println("执行了克隆方法");
        CloneableDemo cloneableDemo = new CloneableDemo();
        cloneableDemo.setName(this.getName());
        return cloneableDemo;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneableDemo cloneableDemo = new CloneableDemo();
        cloneableDemo.setName("测试");
        Object clone = cloneableDemo.clone();
        System.out.println(clone == cloneableDemo);
    }
}
