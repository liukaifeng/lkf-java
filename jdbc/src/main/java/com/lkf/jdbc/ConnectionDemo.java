package com.lkf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDemo {
    private static final String createTableSQL = "create table Users(\r\n" + "  id  int(3) primary key,\r\n" +
            "  name varchar(20),\r\n" + "  email varchar(20),\r\n" + "  country varchar(20),\r\n" +
            "  password varchar(20)\r\n" + "  );";

    public static void main(String[] argv) throws SQLException {
        createTable();
    }

    public static void createTable() throws SQLException {
        System.out.println(createTableSQL);
        // Step 1: 创建 Connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
                "root", "root");

             // Step 2:使用 connection 创建 statement 对象
             Statement statement = conn.createStatement();) {

            // Step 3: 执行SQL语句
            statement.execute(createTableSQL);
        } catch (SQLException e) {

        }
        // Step 4: 使用 try-with-resource 将自动关闭 conn.
    }
}
