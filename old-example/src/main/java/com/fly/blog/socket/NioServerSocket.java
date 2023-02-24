package com.fly.blog.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author 张攀钦
 * @date 2020-07-08-23:08
 */
public class NioServerSocket {
    public static void main(String[] args) throws IOException {
        final ServerSocketChannel open = ServerSocketChannel.open();
        open.bind(new InetSocketAddress("127.0.0.1", 10901), 10);
        // 非阻塞
        open.configureBlocking(false);
        while (true) {
            final SocketChannel accept = open.accept();
            if (Objects.nonNull(accept)) {
                accept.configureBlocking(false);
                new BioSocketClientService(accept).start();
            }
        }
    }

    public static class BioSocketClientService extends Thread {
        private SocketChannel socket;

        @Override
        public void run() {
            final Socket socket = this.socket.socket();
            String client = "id: " + socket.getInetAddress() + " port: " + socket.getPort();
            System.out.println("随便输入接收客户端数据");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            final ByteBuffer allocate = ByteBuffer.allocate(1024);
            while (true) {
                try {
                    final int read = this.socket.read(allocate);
                    if (read > 0) {
                        allocate.flip();
                        System.out.println("接收到客户端" + client + " 的数据为: " + StandardCharsets.UTF_8.decode(allocate));
                        allocate.clear();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public BioSocketClientService(SocketChannel socket) {
            this.socket = socket;
        }
    }
}
