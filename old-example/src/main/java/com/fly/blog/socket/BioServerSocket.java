package com.fly.blog.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author 张攀钦
 * @date 2020-07-08-22:22
 */
public class BioServerSocket {
    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket();
        final SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 10900);
        serverSocket.bind(socketAddress, 10);
        while (true) {
            // 在这里会阻塞等待客户端建立连接
            final Socket accept = serverSocket.accept();
            if (Objects.nonNull(accept)) {
                new SocketClientService(accept).start();
            }
        }
    }

    public static class SocketClientService extends Thread {
        private Socket socket;

        @Override
        public void run() {
            System.out.println("接收到客户端的: " + this.socket.getPort());
            if (!socket.isClosed()) {
                System.out.println("随便输入接收客户端数据");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (InputStream inputStream = socket.getInputStream();) {
                    byte[] data = new byte[8096];
                    int length = 0;
                    while ((length = inputStream.read(data)) != -1) {
                        this.console(data, length);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        public SocketClientService(Socket socket) {
            this.socket = socket;
        }

        public void console(byte[] data, int length) {
            final int port = socket.getPort();
            final InetAddress inetAddress = socket.getInetAddress();
            final String hostAddress = inetAddress.getHostAddress();
            final StringBuilder stringBuilder = new StringBuilder();
            final String data2 = stringBuilder.append("客户端").append(" ip: ").append(hostAddress).append(" 端口: ").append(port).append(" 数据: ").append(new String(data, 0, length, StandardCharsets.UTF_8)).toString();
            System.out.println(data2);
        }
    }
}
