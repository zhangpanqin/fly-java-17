package com.fly.blog.nio;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 张攀钦
 * @date 2020-07-12-16:01
 */
public class MMapDemo {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        final URL resource = MMapDemo.class.getClassLoader().getResource("demo.txt");
        final Path path = Paths.get(resource.toURI());
        final FileChannel open = FileChannel.open(path, StandardOpenOption.READ);
        final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        final int read = open.read(byteBuffer);
        byteBuffer.flip();
        System.out.println(StandardCharsets.UTF_8.decode(byteBuffer).toString());
        Thread.sleep(100000);
    }

    private static void asda() throws URISyntaxException, IOException, InterruptedException {
        final URL resource = MMapDemo.class.getClassLoader().getResource("demo.txt");
        final Path path = Paths.get(resource.toURI());
        final FileChannel open = FileChannel.open(path, StandardOpenOption.READ);
        final MappedByteBuffer map = open.map(FileChannel.MapMode.READ_ONLY, 0, open.size());
        final CharBuffer decode = StandardCharsets.UTF_8.decode(map);
        System.out.println(decode.toString());
        open.close();
        Thread.sleep(100000);
    }
}
