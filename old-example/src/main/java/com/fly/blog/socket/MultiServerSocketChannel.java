package com.fly.blog.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 张攀钦
 * @date 2020-07-10-16:11
 */
public class MultiServerSocketChannel {
    public static void main(String[] args) throws IOException {
        final ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress("127.0.0.1", 10902), 10);
        // 非阻塞
        server.configureBlocking(false);
        final Selector read = Selector.open();
        final Selector accept = Selector.open();
        server.register(accept, SelectionKey.OP_ACCEPT);


        new Thread(() -> {
            while (true) {
                try {
                    if (read.select(500) > 0) {
                        final Set<SelectionKey> selectionKeys = read.selectedKeys();
                        System.out.println("接收到客户端" + selectionKeys.size());
                        final Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        if (iterator.hasNext()) {
                            final SelectionKey next = iterator.next();
                            iterator.remove();
                            if (next.isReadable()) {
                                SocketChannel client = (SocketChannel) next.channel();
                                ByteBuffer buffer = (ByteBuffer) next.attachment();
                                buffer.clear();
                                client.read(buffer);
                                buffer.flip();
                                final CharBuffer decode = StandardCharsets.UTF_8.decode(buffer);
                                System.out.println(decode.toString());
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    if (accept.select(500) > 0) {
                        final Set<SelectionKey> selectionKeys = accept.selectedKeys();
                        System.out.println("建立多少个链接" + selectionKeys.size());
                        final Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()) {
                            final SelectionKey next = iterator.next();
                            System.out.println(next);
                            iterator.remove();
                            if (next.isAcceptable()) {
                                ServerSocketChannel ssc = (ServerSocketChannel) next.channel();
                                SocketChannel client = ssc.accept();
                                client.configureBlocking(false);
                                ByteBuffer buffer = ByteBuffer.allocate(8192);
                                client.register(read, SelectionKey.OP_READ, buffer);
                                System.out.println("-------------------------------------------");
                                System.out.println("新客户端：" + client.getRemoteAddress());
                                System.out.println("-------------------------------------------");
                            }
                        }
                    }
                } catch (ClosedChannelException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


}
