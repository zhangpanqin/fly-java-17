package com.fly.study.java.pid;

import org.junit.jupiter.api.Test;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author 张攀钦
 * @date 2019-12-13-13:15
 * @description 获取启动 pid
 */
public class PidTest {

    @Test
    public void run1() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getClassPath());
        System.out.println(runtimeMXBean.getBootClassPath());
        String jvmName = runtimeMXBean.getName();
        System.out.println(jvmName.split("@")[0]);
    }
}
