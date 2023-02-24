package com.fly.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author: 马士兵教育
 * @create: 2020-06-06 15:12
 */
public class C10Kclient {

    public static void main(String[] args) throws InterruptedException {
        InetSocketAddress serverAddr = new InetSocketAddress("10.211.55.8", 10224);

        for (int i = 1; i <= 8; i++) {
            try {
                final Socket socket = new Socket();
                socket.connect(serverAddr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            Thread.sleep(1000);
            System.out.println(1);
        }
    }
}
