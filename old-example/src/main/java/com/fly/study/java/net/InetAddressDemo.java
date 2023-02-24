package com.fly.study.java.net;

import org.junit.jupiter.api.Test;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 张攀钦
 * @date 2019-12-04-10:04
 * @description
 */
public class InetAddressDemo {
    @Test
    public void run11() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostAddress());

        InetAddress[] allByName = InetAddress.getAllByName("mflyyou.com");
        for (InetAddress inetAddress : allByName) {
            System.out.println(inetAddress.getHostAddress());
        }
    }

}
