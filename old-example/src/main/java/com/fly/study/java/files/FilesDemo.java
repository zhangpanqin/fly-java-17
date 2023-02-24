package com.fly.study.java.files;

import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 张攀钦
 * @date 2020-02-05-12:48
 * @description
 */
@Slf4j
public class FilesDemo {

    Path path;

    public void init() throws IOException {
        final Path path = Paths.get("test/demo.txt");
        this.path = path;
        if (Files.notExists(path)) {
            final Path parent = path.getParent();
            Files.createDirectories(parent);
        }
        if (Files.notExists(path)) {
            final Set<PosixFilePermission> rwx = PosixFilePermissions.fromString("rwxrwxrwx");
            final FileAttribute<Set<PosixFilePermission>> setFileAttribute = PosixFilePermissions.asFileAttribute(rwx);
            final Path file = Files.createFile(path, setFileAttribute);
        }
    }

    public static void main(String[] args) throws IOException {
        final FilesDemo filesDemo = new FilesDemo();
        filesDemo.init();

        final ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                reentrantLock.lock();
                try {
                    final byte[] bytes = Files.readAllBytes(filesDemo.path);
                    final String s = new String(bytes, StandardCharsets.UTF_8);
                    int a = 0;
                    if (Objects.nonNull(s) && s.length() > 0) {
                        a = Integer.valueOf(s);
                    }
                    a++;
                    Files.write(filesDemo.path, String.valueOf(a).getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    log.error("读取文件失败", e);
                } finally {
                    reentrantLock.unlock();
                }
            }).start();

        }

    }
}
