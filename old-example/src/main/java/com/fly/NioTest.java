package com.fly;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @author 张攀钦
 * @date 2020-07-20-23:53
 */
public class NioTest {



    @Test
    public void run1() throws IOException {
        final ServerSocketChannel open = ServerSocketChannel.open();
        open.configureBlocking(false);
        open.bind(new InetSocketAddress(9989), 20);
        open.register(Selector.open(), SelectionKey.OP_ACCEPT);
        System.out.println(open.isRegistered());

    }

    public static void main(String[] args) throws IOException {
        final ServerSocketChannel open = ServerSocketChannel.open();
        open.configureBlocking(false);
        open.bind(new InetSocketAddress(9989), 20);
        open.register(Selector.open(), SelectionKey.OP_ACCEPT);
        final Selector open1 = Selector.open();
        final Selector open2 = Selector.open();
        final ArrayList<SocketChannel> objects = new ArrayList<>();
        new Thread(() -> {
            while (true) {
                try {
                    final SocketChannel accept = open.accept();
                    if (Objects.nonNull(accept)) {
                        objects.add(accept);
                        accept.configureBlocking(false);
                        accept.register(open1, SelectionKey.OP_READ);
                        accept.register(open2, SelectionKey.OP_READ);
                        open1.wakeup();
                        open2.wakeup();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(
                () -> {
                    while (true) {
                        try {
                            final int select = open1.select(20);
                            System.in.read();
                            if (objects.size() > 0) {
                                final SocketChannel socketChannel = objects.get(0);
                                if (Objects.nonNull(socketChannel)) {
                                    System.out.println("客户端注册" + socketChannel.isRegistered() + " size " + select + " " + socketChannel);
                                }
                            }

                            if (select > 0) {
                                final Set<SelectionKey> selectionKeys = open1.selectedKeys();
                                final Iterator<SelectionKey> iterator = selectionKeys.iterator();
                                while (iterator.hasNext()) {
                                    final SelectionKey next = iterator.next();

                                    iterator.remove();
                                    if (next.isReadable()) {
                                        final SocketChannel channel = (SocketChannel) next.channel();
                                        final ByteBuffer allocate = ByteBuffer.allocate(1024);
                                        channel.read(allocate);
                                        allocate.flip();
                                        next.cancel();
                                    }
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
//        new Thread(
//                () -> {
//                    while (true) {
//                        try {
//                            final int select = open2.select(20);
//                            if (select > 0) {
//                                final Set<SelectionKey> selectionKeys = open2.selectedKeys();
//                                final Iterator<SelectionKey> iterator = selectionKeys.iterator();
//                                while (iterator.hasNext()) {
//                                    final SelectionKey next = iterator.next();
//                                    iterator.remove();
//                                    if (next.isReadable()) {
//                                        final SocketChannel channel = (SocketChannel) next.channel();
//                                        final ByteBuffer allocate = ByteBuffer.allocate(1024);
//                                        channel.read(allocate);
//                                        allocate.flip();
//                                        System.out.println("open2: " + StandardCharsets.UTF_8.decode(allocate).toString());
//                                    }
//                                }
//                            }
//                            open2.wakeup();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//        ).start();
    }
}
