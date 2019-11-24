package com.lkf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
//    public static void main(String[] args) {
//        //连接对象
//        Connection conn = null;
//        //SQL statement 对象
//        Statement stmt = null;
//        try {
//            //01.加载驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("数据库驱动加载成功 ！");
//            //02.创建连接对象
//            conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
//                    "root", "root");
//            //03.创建Statement
//            stmt = conn.createStatement();
//            System.out.println("连接成功，获取连接对象： " + conn);
//            //04.执行SQL语句
//            String sql = "CREATE TABLE `tb_user2` (\n" +
//                    "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
//                    "  `user_name` varchar(30) DEFAULT NULL COMMENT '用户名',\n" +
//                    "  `sex` int(1) DEFAULT '0' COMMENT '性别(0-男；1-女)',\n" +
//                    "  `age` int(100) DEFAULT '0' COMMENT '年龄',\n" +
//                    "  `birthday` datetime DEFAULT NULL COMMENT '生日',\n" +
//                    "  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',\n" +
//                    "  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',\n" +
//                    "  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
//                    "  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',\n" +
//                    "  `status_flag` int(11) DEFAULT '0' COMMENT '状态（0-正常；1-停用）',\n" +
//                    "  PRIMARY KEY (`id`)\n" +
//                    ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8\n";
//            int count = stmt.executeUpdate(sql);
//            System.out.println("返回结果count：" + count);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            //05、关闭连接对象
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public static void main( String[] args ) {
        try (
                //01-创建连接
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT",
                        "root", "root");
                //02-创建 statement 对象
                Statement stmt = conn.createStatement();
        ) {
            //03-执行SQL语句
            String sql = "CREATE TABLE `tb_user2` (\n" +
                    "  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,\n" +
                    "  `user_name` VARCHAR(30) DEFAULT NULL COMMENT '用户名',\n" +
                    "  `sex` INT(1) DEFAULT '0' COMMENT '性别(0-男；1-女)',\n" +
                    "  `age` INT(100) DEFAULT '0' COMMENT '年龄',\n" +
                    "  `birthday` DATETIME DEFAULT NULL COMMENT '生日',\n" +
                    "  `email` VARCHAR(30) DEFAULT NULL COMMENT '邮箱',\n" +
                    "  `mobile` VARCHAR(20) DEFAULT NULL COMMENT '手机号',\n" +
                    "  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
                    "  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',\n" +
                    "  `status_flag` INT(11) DEFAULT '0' COMMENT '状态（0-正常；1-停用）',\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8\n";
            int count = stmt.executeUpdate(sql);
            System.out.println("返回结果count：" + count);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void printSQLException( SQLException ex ) {
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
