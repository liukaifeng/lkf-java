package com.lkf.jdbc;

import java.sql.*;

public class StatementDemo {
    private static final String QUERY_SQL = "select id,name,email,country,password from Users";

    public static void main(String[] args) {
        // Step 1: 创建 Connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
                "root", "root");

             // Step 2:创建 statement
             Statement stmt = conn.createStatement();

             // Step 3: 执行SQL
             ResultSet rs = stmt.executeQuery(QUERY_SQL)) {

            // Step 4: 处理 ResultSet 结果集
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        // Step 4: try-with-resource 语句将自动关闭连接。
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
