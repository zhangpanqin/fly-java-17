package com.fly.study.runtime;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author 张攀钦
 * @date 2020-07-14-11:07
 */
public class GetPId {
    public static void main(String[] args) {
        final RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        System.out.println(runtimeMXBean.getInputArguments());
    }
}
