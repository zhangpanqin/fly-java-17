package com.fly.source.socket;

import cn.hutool.core.io.IoUtil;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 张攀钦
 * @date 2020-07-23-16:15
 */
public class SocketDemo1 {
    public static void main(String[] args) throws IOException {
        final InputStream resourceAsStream = SocketDemo1.class.getClassLoader().getResourceAsStream("yan.txt");
        final String read = IoUtil.read(resourceAsStream, StandardCharsets.UTF_8);
        IoUtil.close(resourceAsStream);
        final ServerSocketChannel open = ServerSocketChannel.open();
        open.configureBlocking(false);
        open.bind(new InetSocketAddress(10222), 20);
        final Selector open1 = Selector.open();
        open.register(open1, SelectionKey.OP_ACCEPT);
        final LinkedBlockingQueue<SocketChannel> objects = new LinkedBlockingQueue<>(1024);

        Selector open2 = Selector.open();

        new Thread(() -> {
            while (true) {
                try {
                    final int select = open2.select();
                    if (select > 0) {
                        System.out.println("几个链接" + select);
                        final Set<SelectionKey> selectionKeys = open2.selectedKeys();
                        final SelectionKey next = selectionKeys.iterator().next();
                        System.out.println(next.isReadable());
                        System.out.println(next.isWritable());
                            Thread.sleep(10000);
//                        final Set<SelectionKey> selectionKeys = open2.selectedKeys();
//                        final Iterator<SelectionKey> iterator = selectionKeys.iterator();
//                        while (iterator.hasNext()) {
//                            final SelectionKey next = iterator.next();
//                            iterator.remove();
//                            System.out.println("阻塞运行");
//                            System.in.read();
//                            if (next.isWritable()) {
//                                final SocketChannel channel = (SocketChannel) next.channel();
//                                final ByteBuffer wrap = ByteBuffer.wrap(read.getBytes(StandardCharsets.UTF_8));
//                                System.out.println("写数据开始");
//                                channel.write(wrap);
//                                System.out.println("写数据结束");
//                            } else {
//                                System.out.println("不可写了");
//                            }
//                        }
                    }
                    final SocketChannel poll = objects.poll();
                    if (Objects.nonNull(poll)) {
                        poll.register(open2, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        open2.wakeup();
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    if (open1.select(100) <= 0) {
                        continue;
                    }
                    final Set<SelectionKey> selectionKeys = open1.selectedKeys();
                    final Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        final SelectionKey next = iterator.next();
                        iterator.remove();
                        if (next.isValid() & next.isAcceptable()) {
                            final ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                            final SocketChannel accept = channel.accept();
                            if (Objects.nonNull(accept)) {
                                accept.configureBlocking(false);
                                objects.put(accept);
                                open2.wakeup();
                            }
                        }
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
