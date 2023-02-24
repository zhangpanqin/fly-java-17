package com.fly.rmi.service;

import java.rmi.Remote;

/**
 * @author 张攀钦
 * @date 2020-08-23-13:22
 * 测试远程调用
 */
public interface ITestRmiService extends Remote {

    // 这个要抛出异常
    String test(String aa) throws Exception;

}
