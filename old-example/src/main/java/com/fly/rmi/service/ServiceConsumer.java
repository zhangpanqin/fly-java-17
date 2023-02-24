package com.fly.rmi.service;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author 张攀钦
 * @date 2020-08-23-13:29
 */
public class ServiceConsumer {
    public static void main(String[] args) throws Exception {
            final Registry registry = LocateRegistry.getRegistry("192.168.31.80", 11122);
            final ITestRmiService testRmiService = (ITestRmiService) registry.lookup("testRmiService");
            System.out.println(testRmiService.test("11"));
    }
}
