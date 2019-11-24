package com.lkf.jdbc;

import java.sql.*;

public class DbUtil {
    //数据库驱动名字
    private static String jdbcName = "com.mysql.jdbc.Driver";
    //数据库协议地址
    private static String dbUrl = "jdbc:mysql://localhost:3306/db_user";
    //数据库用户名
    private static String dbUser = "root";
    //数据库密码
    private static String dbPassword = "123456";


    /**
     * 获取连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getCon() throws Exception {
        return  DriverManager.getConnection(dbUrl, dbUser, dbPassword);

    }

    /**
     * 关闭连接
     *
     * @param stmt
     * @param conn
     * @throws Exception
     */
    public static void close(Statement stmt, Connection conn) throws Exception {
        if (stmt != null) {
            stmt.close();
            if (conn != null) {
                conn.close();
            }
        }
    }

    /**
     * 关闭连接
     *
     * @param cstmt
     * @param conn
     * @throws Exception
     */
    public static void close(CallableStatement cstmt, Connection conn) throws Exception {
        if (cstmt != null) {
            cstmt.close();
            if (conn != null) {
                conn.close();
            }
        }
    }


    /**
     * 关闭连接
     *
     * @param pstmt
     * @param conn
     * @throws SQLException
     */
    public static void close(PreparedStatement pstmt, Connection conn) throws SQLException {
        if (pstmt != null) {
            pstmt.close();
            if (conn != null) {
                conn.close();
            }
        }
    }


    /**
     * 重载关闭方法
     *
     * @param pstmt
     * @param conn
     * @throws Exception
     */
    public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) throws Exception {
        if (rs != null) {
            rs.close();
            if (pstmt != null) {
                pstmt.close();
                if (conn != null) {
                    conn.close();
                }
            }
        }

    }
}
