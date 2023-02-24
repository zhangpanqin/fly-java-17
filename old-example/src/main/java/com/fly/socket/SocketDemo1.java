package com.fly.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
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
        final ServerSocketChannel open = ServerSocketChannel.open();
        open.configureBlocking(false);
        open.bind(new InetSocketAddress("10.211.55.8", 10224), 8);
        open.setOption(StandardSocketOptions.SO_RCVBUF, 4096);
        final Selector open1 = Selector.open();
        open.register(open1, SelectionKey.OP_ACCEPT);
        final LinkedBlockingQueue<Runnable> objects = new LinkedBlockingQueue<>(1024);
        Selector open2 = Selector.open();

        new Thread(() -> {
            while (true) {
                try {
                    int select = open2.select();
                    if (select > 0) {
                        final Set<SelectionKey> selectionKeys = open2.selectedKeys();
                        final Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()) {
                            System.out.println("随便输入数据");
                            System.in.read();
                            final SelectionKey next = iterator.next();
                            iterator.remove();
                            if (next.isReadable()) {
                                final SocketChannel channel = (SocketChannel) next.channel();
                                final ByteBuffer allocate = ByteBuffer.allocate(1024);
                                final int read = channel.read(allocate);
                                if (read == -1) {
                                    channel.close();
                                }
                                if (read > 0) {
                                    allocate.flip();
                                    System.out.println(StandardCharsets.UTF_8.decode(allocate).toString());
                                }
                            }
                        }
                    }

                    final Runnable poll = objects.poll();
                    if (Objects.nonNull(poll)) {
                        poll.run();
                    }
                } catch (IOException e) {
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
                                objects.put(() -> {
                                    open2.wakeup();
                                    try {
                                        accept.register(open2, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                                    } catch (ClosedChannelException e) {
                                        e.printStackTrace();
                                    }
                                });
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
