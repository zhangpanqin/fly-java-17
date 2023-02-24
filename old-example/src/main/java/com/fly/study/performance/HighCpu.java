package com.fly.study.performance;

/**
 * @author 张攀钦
 * @date 2020-06-01-19:58
 * cpu 使用率
 */
public class HighCpu {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    int a = 1 + 1;
                }
            }).start();
        }
    }
}
