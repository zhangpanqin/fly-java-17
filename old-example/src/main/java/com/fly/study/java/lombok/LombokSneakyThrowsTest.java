package com.fly.study.java.lombok;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author 张攀钦
 * @date 2019-10-11-10:09
 * @description lombok 学习
 */
@Slf4j
public class LombokSneakyThrowsTest {

    @SneakyThrows
    public String str(byte[] bytes) {
        return new String(bytes, "utf-8");
    }

    private LombokSneakyThrowsTest lombokSneakyThrowsTest;

    @BeforeEach
    public void before() {
        lombokSneakyThrowsTest = new LombokSneakyThrowsTest();
    }

    @SneakyThrows
    public void io() {
        File file = new File("");
        new FileInputStream(file);
    }

    public void ioNoWithSneakyThrows() throws FileNotFoundException {
        File file = new File("");
        new FileInputStream(file);
    }

    @Test
    public void run1() {
        try {
            lombokSneakyThrowsTest.str(null);
        } catch (Exception e) {
            log.error("异常了", e);
        }
    }

    @Test
    public void run2() {

        try {
            lombokSneakyThrowsTest.io();
        } catch (Exception e) {
            log.error("发现异常", e);
        } finally {
        }
    }

    @Test
    public void run3() throws FileNotFoundException {
        lombokSneakyThrowsTest.ioNoWithSneakyThrows();
    }

    @Test
    public void run4() {
        lombokSneakyThrowsTest.io();
    }
}
