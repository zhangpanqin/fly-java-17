package com.fly.study.java.exception;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author 张攀钦
 * @date 2019-10-27-13:57
 * @description
 */
public class ExceptionStudy {
    @Test
    public void run1() throws IOException {
        long count = Files.walk(Paths.get("D:/Test"))                      // 获得项目目录下的所有目录及文件
                .filter(file -> !Files.isDirectory(file))          // 筛选出文件
                .filter(file -> file.toString().endsWith(".java")) // 筛选出 java 文件
                .flatMap(file -> {
                    try {
                        return Files.lines(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return Stream.empty();
                })                // 按行获得文件中的文本
                .filter(line -> !line.trim().isEmpty())            // 过滤掉空行
                .count();

        System.out.println("代码行数：" + count);
    }

    @Test
    public void run2() throws IOException {
        long count = Files.walk(Paths.get("D:/Test"))              // 获得项目目录下的所有文件
                .filter(file -> !Files.isDirectory(file))          // 筛选出文件
                .filter(file -> file.toString().endsWith(".java")) // 筛选出 java 文件

                .flatMap(Attempt.apply(file -> Files.lines(file)))        // 将 会抛出受检异常的 Lambda 包装为 抛出非受检异常的 Lambda

                .filter(line -> !line.trim().isEmpty())            // 过滤掉空行
                .count();

        System.out.println("代码行数：" + count);
    }

    public interface Attempt {

        static <T, R> Function<T, R> apply(CheckedFunction<T, R> function) {
            Objects.requireNonNull(function);

            return t -> {
                try {
                    return function.apply(t);
                }catch (Throwable ex) {
                    throw new RuntimeException(ex);
                }
            };
        }

    }
    @FunctionalInterface
    interface CheckedFunction<T, R> {
        R apply(T t) throws Throwable;
    }
}
