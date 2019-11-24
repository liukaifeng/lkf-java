package com.lkf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDemo {
    //插入记录 SQL
    private static final String INSERT_USERS_SQL = "INSERT INTO users (id, name, email, country, password) VALUES  (?, ?, ?, ?, ?);";
    //修改记录 SQL
    private static final String UPDATE_USERS_SQL = "update users set name = ? where id = ?;";

    public static void main(String[] argv) throws SQLException {
        PreparedStatementDemo preparedStatementDemo = new PreparedStatementDemo();
        //插入记录
        preparedStatementDemo.insertRecord();
        //修改记录
        preparedStatementDemo.updateRecord();
        //复用 PreparedStatement
        preparedStatementDemo.reuseSqlByPreparedStatement();
    }

    /**
     * 插入记录
     */
    public void insertRecord() throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // Step 1: 创建 Connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
                "root", "root");

             // Step 2:使用conn创建statement对象
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "张三");
            preparedStatement.setString(3, "zhangsan@qq.com");
            preparedStatement.setString(4, "china");
            preparedStatement.setString(5, "123456");
            System.out.println(preparedStatement);
            // Step 3: 执行查询
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // 打印SQL异常信息
            printSQLException(e);
        }
    }

    /**
     * 修改记录
     */
    public void updateRecord() throws SQLException {
        System.out.println(UPDATE_USERS_SQL);
        // Step 1: 创建 Connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
                "root", "root");

             // Step 2:使用conn创建statement对象
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, "李四");
            preparedStatement.setInt(2, 1);

            // Step 3: 执行查询
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // 打印SQL异常信息
            printSQLException(e);
        }
    }

    /**
     * 复用 PreparedStatement
     */
    public void reuseSqlByPreparedStatement() throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // Step 1: 创建 Connection
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
                "root", "root");

             // Step 2:使用conn创建statement对象
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "张三");
            preparedStatement.setString(3, "zhangsan@qq.com");
            preparedStatement.setString(4, "china");
            preparedStatement.setString(5, "123456");
            System.out.println(preparedStatement);
            // Step 3: 执行查询
            preparedStatement.executeUpdate();

            // Step 4: 复用 PreparedStatement
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "李四");
            preparedStatement.setString(3, "lisi@qq.com");
            preparedStatement.setString(4, "china");
            preparedStatement.setString(5, "123456");

            // Step 5: 执行查询
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // 打印SQL异常信息
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
