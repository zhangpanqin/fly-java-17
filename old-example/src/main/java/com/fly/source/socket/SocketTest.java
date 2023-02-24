package com.fly.source.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @author 张攀钦
 * @date 2020-07-22-21:02
 */
public class SocketTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        final Selector open = Selector.open();
        System.out.println("epoll_test: Selector.open");

        final ServerSocketChannel open1 = ServerSocketChannel.open();
        open1.bind(new InetSocketAddress(9012), 200);
        open1.configureBlocking(false);
        open1.register(open, SelectionKey.OP_ACCEPT);
        final Selector open2 = Selector.open();

        while (true) {
            final SocketChannel accept = open1.accept();
            if (Objects.nonNull(accept)) {
                accept.configureBlocking(false);
                accept.register(open2, SelectionKey.OP_READ);
                System.out.println("Selector.accept");
                open2.wakeup();
            }

            final int select = open2.select(500);
            if (select > 0) {
                System.out.println("Selector.select");
                final Set<SelectionKey> selectionKeys = open2.selectedKeys();
                final Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    final SelectionKey next = iterator.next();
                    iterator.remove();
                    final SocketChannel channel = (SocketChannel) next.channel();
                    final ByteBuffer allocate = ByteBuffer.allocate(1024);
                    final int read = channel.read(allocate);
                    allocate.flip();
                    System.out.println(StandardCharsets.UTF_8.decode(allocate).toString());
                }
            }


        }


    }
}
