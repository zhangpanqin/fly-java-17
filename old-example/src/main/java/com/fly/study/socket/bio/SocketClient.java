package com.fly.study.socket.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author 张攀钦
 * @date 2020-07-14-16:25
 * nc -l 9099 在 9099 启动监听
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket();
        final InetSocketAddress inetSocketAddress = new InetSocketAddress(10999);
        final InetSocketAddress clientAddress = new InetSocketAddress(11000);
        socket.bind(clientAddress);
        socket.connect(inetSocketAddress);
        System.out.println("绑定本机 ip 和 端口" + socket.isBound());

        int count = 0;
        final InputStream inputStream = socket.getInputStream();
        final OutputStream outputStream = socket.getOutputStream();
        byte[] data = new byte[1024];
        int readLength = 0;
        while (true) {
            try {
                if (inputStream.available() > 0) {
                    System.out.println("有数据到来,随便输入数据接收");
                    System.in.read();
                    System.out.println("socket 接收到的数据" + new String(data, 0, readLength));
                    count++;
                    final String s = "接收到数了-" + count + "\r\n";
                    outputStream.write(s.getBytes(StandardCharsets.UTF_8));
                }
            } catch (Exception e) {
                System.out.println("远程关闭了服务器");
                socket.shutdownInput();
                socket.shutdownOutput();
                socket.close();
                return;
            }
        }


    }
}
