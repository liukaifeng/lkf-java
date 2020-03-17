package com.lkf.jdbc;

import java.sql.*;

public class SQLExceptionDemo {
    private static String sql = "select id,name,email,country,password from Userswhere id=1";

    public static void main(String[] args) {
        // Step 1: 创建连接对象 connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
             // Step 2:使用 connection 创建 stmt
             Statement stmt = connection.createStatement();
             // Step 3:执行SQL语句
             ResultSet rs = stmt.executeQuery(sql)) {
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
                if (!ignoreSQLException(((SQLException) e).getSQLState())) {
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

    public static boolean ignoreSQLException(String sqlState) {
        if (sqlState == null) {
            System.out.println("The SQL state is not defined!");
            return false;
        }

        // X0Y32: Jar文件已存在
        if (sqlState.equalsIgnoreCase("X0Y32"))
            return true;

        // 42Y55: 该表已存在
        if (sqlState.equalsIgnoreCase("42Y55"))
            return true;
        return false;
    }


    public static void getWarningsFromResultSet(ResultSet rs)
            throws SQLException {
        printWarnings(rs.getWarnings());
    }

    public static void getWarningsFromStatement(Statement stmt)
            throws SQLException {
        printWarnings(stmt.getWarnings());
    }

    public static void printWarnings(SQLWarning warning)
            throws SQLException {

        if (warning != null) {
            System.out.println("\n---Warning---\n");

            while (warning != null) {
                System.out.println("Message: " + warning.getMessage());
                System.out.println("SQLState: " + warning.getSQLState());
                System.out.print("Vendor error code: ");
                System.out.println(warning.getErrorCode());
                System.out.println("");
                warning = warning.getNextWarning();
            }
        }
    }
}
