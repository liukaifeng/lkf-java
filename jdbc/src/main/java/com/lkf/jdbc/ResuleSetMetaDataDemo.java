package com.lkf.jdbc;

import java.sql.*;

public class ResuleSetMetaDataDemo {
    //SQL语句
    private static final String QUERY = "select id,name,email,country,password from Users";

    public static void main(String[] args) {
        // Step 1: 创建连接对象 connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
             // Step 2:使用 connection 创建 stmt
             Statement stmt = connection.createStatement();
             // Step 3:执行SQL语句
             ResultSet rs = stmt.executeQuery(QUERY)) {
            //获取结果集 rs 的元数据对象 resultSetMetaData
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            System.out.println("1. 列数量 :: " + resultSetMetaData.getColumnCount());
            System.out.println("2. 第一列名称 :: " + resultSetMetaData.getColumnName(1));
            System.out.println("3. 数据库名称 :: " + resultSetMetaData.getCatalogName(1));
            ;
            System.out.println("4. 列数据类型 :: " + resultSetMetaData.getColumnTypeName(1));
            System.out.println("5. 表名 :: " + resultSetMetaData.getTableName(1));
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
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
