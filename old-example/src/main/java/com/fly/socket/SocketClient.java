package com.fly.socket;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: 马士兵教育
 * @create: 2020-06-06 15:12
 */
public class SocketClient {

    public static void main(String[] args) throws InterruptedException, IOException {
//        InetSocketAddress serverAddr = new InetSocketAddress("192.168.31.200", 10223);
//        final Socket socket = new Socket();
//        socket.connect(serverAddr);
//        System.out.println("clients " + socket.isConnected());
    }

    @Test
    public void demo2() throws IOException {
        final ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("192.168.202.116", 8080), 2000);
        while (true){
            final Socket accept = serverSocket.accept();
            // 用于读取客户端发来的数据
            final InputStream inputStream = accept.getInputStream();
            // 用于往客户端写入数据
            final OutputStream outputStream = accept.getOutputStream();
        }
    }
}
