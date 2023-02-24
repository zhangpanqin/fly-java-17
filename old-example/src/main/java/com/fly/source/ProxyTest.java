package com.fly.source;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 张攀钦
 * @date 2020-06-16-17:56
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 判断是否是代理类
        Class<UserService> cl = UserService.class;
        System.out.println(Proxy.isProxyClass(cl));
        Class[] cls = {cl};
        UserServiceImpl userService = new UserServiceImpl();
        InvocationHandler invocationHandler = (Object proxy, Method method, Object[] args2) -> {
            return method.invoke(userService, args2);
        };
        UserService o = (UserService) Proxy.newProxyInstance(cl.getClassLoader(), cls, invocationHandler);
        System.out.println(o.getUserName());

    }

    public static class UserServiceImpl implements UserService {

        @Override
        public String getUserName() {
            return "张";
        }
    }

    public interface UserService {
        String getUserName();
    }
}
