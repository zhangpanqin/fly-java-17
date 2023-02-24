package com.fly.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 查询所有的分类信息
        // 注意：使用JDBC规范，采用都是java.sql包下的内容
        //1 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2 获得连接
        String url = "jdbc:mysql://localhost:3306/test1?serverTimezone=Asia/Shanghai";
        Connection conn = DriverManager.getConnection(url, "root", "123456");
        //3获得语句执行者
        PreparedStatement st = conn.prepareStatement("select * from drone_task_status where id = ?");

        st.setString(1, "1");
        final boolean execute = st.execute();
        final ResultSet rs = st.getResultSet();
        //4执行SQL语句
//        ResultSet rs = st.executeQuery("select * from drone_task_status");
        //5处理结果集
        while (rs.next()) {
            // 获得一行数据
            Integer cid = rs.getInt("id");
            String cname = rs.getString("aa");
            System.out.println(cid + " , " + cname);
        }
        st.clearParameters();
        st.setString(1,"2");
        st.execute();
        final ResultSet resultSet = st.getResultSet();
        while (resultSet.next()) {
            // 获得一行数据
            Integer cid = resultSet.getInt("id");
            String cname = resultSet.getString("aa");
            System.out.println(cid + " , " + cname);
        }
        //6释放资源
        rs.close();
        st.close();
        conn.close();
    }
}
