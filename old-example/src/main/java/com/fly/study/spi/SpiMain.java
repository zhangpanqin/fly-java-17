package com.fly.study.spi;

import java.util.ServiceLoader;

/**
 * @author 张攀钦
 * @date 2019-11-30-18:50
 * @description
 */
public class SpiMain {
    public static void main(String[] args) {
        ServiceLoader<Spi1> printerLoader = ServiceLoader.load(Spi1.class);
        for (Spi1 printer : printerLoader) {
            printer.log1();
        }
    }
}
