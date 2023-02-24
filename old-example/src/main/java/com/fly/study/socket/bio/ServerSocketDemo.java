package com.fly.study.socket.bio;

import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author 张攀钦
 * @date 2020-07-15-10:02
 */
@Slf4j
public class ServerSocketDemo {
    public static void main(String[] args) throws IOException {
        final ServerSocket serverSocket = new ServerSocket();
        final InetSocketAddress inetSocketAddress = new InetSocketAddress(8011);
        serverSocket.bind(inetSocketAddress, 100);
//        serverSocket.setSoTimeout(10000);
        Socket client;
        while (true) {
            try {
                client = serverSocket.accept();
                System.out.println("有了解了");
            } catch (SocketException socketException) {
                log.error("链接超时了", socketException);
            }
        }
    }
}
