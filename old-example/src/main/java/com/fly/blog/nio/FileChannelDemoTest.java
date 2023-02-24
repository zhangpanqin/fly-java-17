package com.fly.blog.nio;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 张攀钦
 * @date 2020-07-08-14:43
 */
public class FileChannelDemoTest {

    private static final String FILE_NAME = "demo_lock.txt";

    /**
     * 读
     */
    @Test
    public void read() throws IOException {
        final Path path = Paths.get(FILE_NAME);
        final FileChannel open = FileChannel.open(path, StandardOpenOption.READ);
        final ByteBuffer allocate = ByteBuffer.allocate((int) open.size());
        open.read(allocate);
        open.close();
        allocate.flip();
        final CharBuffer decode = StandardCharsets.UTF_8.decode(allocate);
        System.out.println(decode.toString());
    }

    /**
     * 写
     */
    @Test
    public void write() throws IOException {
        final Path path = Paths.get("demo" + FILE_NAME);
        final FileChannel open = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        final ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put("张攀钦aaaaa-1111111".getBytes(StandardCharsets.UTF_8));
        allocate.flip();
        open.write(allocate);
        open.close();
    }

    @Test
    public void create_5g() throws IOException {
        final FileChannel dest = FileChannel.open(Paths.get("new_5g.txt"), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        final FileChannel src = FileChannel.open(Paths.get("5g.txt"), StandardOpenOption.READ);
        final ByteBuffer allocate = ByteBuffer.allocate(1024 * 1024 * 100);
        src.read(allocate);
        src.close();
        System.out.println("当前位置" + dest.position());
        long g5 = 1024 * 1024 * 1024 * 5L;
        System.out.println(g5);
        while (dest.position() < g5) {
            System.out.println(dest.position());
            allocate.rewind();
            dest.write(allocate);
        }
        dest.close();
    }

    /**
     * 从一个文件复制到另一个文件
     */
    @Test
    public void copy() throws IOException {
        final Path srcPath = Paths.get(FILE_NAME);
        final Path destPath = Paths.get("demo" + FILE_NAME);
        final FileChannel srcChannel = FileChannel.open(srcPath, StandardOpenOption.READ);
        final FileChannel destChannel = FileChannel.open(destPath, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        srcChannel.transferTo(0, srcChannel.size(), destChannel);
        destChannel.close();
        srcChannel.close();
    }

    /**
     * 测试大于 5g 的文本能否拷贝全.
     * 最大拷贝 Integer.MAX
     */
    @Test
    public void copyBigFile() throws IOException, InterruptedException {
        String bigFileName = "new_5g.txt";
        final Path srcPath = Paths.get(bigFileName);
        final Path destPath = Paths.get("demo" + bigFileName);
        final FileChannel srcChannel = FileChannel.open(srcPath, StandardOpenOption.READ);
        final FileChannel destChannel = FileChannel.open(destPath, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        srcChannel.transferTo(0, srcChannel.size(), destChannel);
        destChannel.close();
        srcChannel.close();
        Thread.sleep(1000000);
    }
}
