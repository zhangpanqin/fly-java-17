package com.fly.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemoGetDataBaseInfo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 查询所有的分类信息
        // 注意：使用JDBC规范，采用都是java.sql包下的内容
        //1 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2 获得连接
        String url = "jdbc:mysql://localhost:3306/test1?serverTimezone=Asia/Shanghai";
        Connection conn = DriverManager.getConnection(url, "root", "123456");
        conn.setCatalog("zf3d");
        final Statement statement = conn.createStatement();
        statement.execute("SELECT * FROM zf3d_user");
        final ResultSet rs = statement.getResultSet();
        while (rs.next()) {
            // 获得一行数据

            String cname = rs.getString("username");
            System.out.println(" , " + cname);
        }

        conn.close();
    }
}
