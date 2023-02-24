package com.fly.blog.nio;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 张攀钦
 * @date 2020-07-08-16:39
 */
public class RandomAccessFileDemo {
    private static final String FILE_NAME = "new_5g.txt";
    @Test
    public void map() throws IOException, InterruptedException {
        final StandardOpenOption read = StandardOpenOption.READ;
        final FileChannel open = FileChannel.open(Paths.get(FILE_NAME), read);
        final MappedByteBuffer map = open.map(FileChannel.MapMode.READ_ONLY, 100, 100);
        System.out.println(map.isLoaded());
        System.out.println(map.isDirect());
        Thread.sleep(10000);
    }
}
