package com.fly.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSchmaDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 查询所有的分类信息
        // 注意：使用JDBC规范，采用都是java.sql包下的内容
        //1 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2 获得连接
        String url = "jdbc:mysql://localhost:3306/test1?serverTimezone=Asia/Shanghai";
        Connection conn = DriverManager.getConnection(url, "root", "123456");

        System.out.println(conn.getSchema());

        conn.close();
    }
}
