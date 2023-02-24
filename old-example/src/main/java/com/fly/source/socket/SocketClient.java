package com.fly.source.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author 张攀钦
 * @date 2020-07-23-16:35
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket();
        socket.connect(new InetSocketAddress(10222));
        final InputStream inputStream = socket.getInputStream();
//        final OutputStream outputStream = socket.getOutputStream();
//        outputStream.write(1);
        byte[] data = new byte[2048];
        int length = 0;
        while (true) {
            System.out.println("在这里阻塞读取数据");
            System.in.read();
            while ((length = inputStream.read(data)) > 0) {
                System.out.println("读到一部分数据,等待下次读取");
                System.in.read();
                System.out.println(new String(data, 0, length, StandardCharsets.UTF_8));
            }
        }
    }
}
