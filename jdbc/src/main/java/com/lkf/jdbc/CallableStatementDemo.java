package com.lkf.jdbc;

import java.sql.*;

public class CallableStatementDemo {
    //数据库连接地址
    private final String jdbcUrl = "jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    //用户名
    private final String username = "root";
    //密码
    private final String password = "root";
    //调用返回单个结果集存储过程语句
    private final String proc_single_select_sql = "call proc_single_select()";
    //调用返回多个结果集存储过程语句
    private final String proc_multi_select_sql = "call proc_multi_select()";
    private final String proc_in_select_sql = "call proc_getUserByName(?)";
    private final String proc_out_select_sql = "call proc_getUserNumByName(?,?)";


    public static void main(String[] args) throws SQLException {
        CallableStatementDemo callableStatementDemo = new CallableStatementDemo();
        //返回单个结果集
//        callableStatementDemo.singleResultSet();
        //返回多个结果集
//        callableStatementDemo.multipleResultSet();
//        callableStatementDemo.procInParam();
        callableStatementDemo.procOutParam();
    }

    /**
     * 返回多个结果集
     */
    public void multipleResultSet() {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(proc_multi_select_sql);) {
            //执行存储过程
            boolean hasRs = stmt.execute();
            System.out.println();
            // 解析名字的结果集
            if (hasRs) {
                try (ResultSet rs = stmt.getResultSet()) {
                    while (rs.next()) {
                        System.out.println("NAME = " + rs.getString(1));
                    }
                }
            }

            // 解析邮箱的结果集
            if (stmt.getMoreResults()) {
                try (ResultSet rs = stmt.getResultSet()) {
                    if (rs.next()) {
                        System.out.println("Email = " + rs.getString(1));
                    }
                }
            }

            // 获取统计的用户数量
            if (stmt.getMoreResults()) {
                try (ResultSet rs = stmt.getResultSet()) {
                    if (rs.next()) {
                        System.out.println("Users count = " + rs.getInt(1));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回单个结果集
     */
    public void singleResultSet() {
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             CallableStatement stmt = conn.prepareCall(proc_in_select_sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID = " + rs.getInt(1) + ", NAME = " + rs.getString(2) + ", Email = " +
                        rs.getString(3) + ", Country = " + rs.getString(4) + ", Password = " + rs.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 带有输入参数（IN）的存储过程
     */
    public void procInParam() throws SQLException {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            //获取连接对象
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            //预编译
            stmt = conn.prepareCall(proc_in_select_sql);
            //传递输入参数
            stmt.setString(1, "张三");
            //执行存储过程
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID = " + rs.getInt(1) + ", NAME = " + rs.getString(2) + ", Email = " +
                        rs.getString(3) + ", Country = " + rs.getString(4) + ", Password = " + rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
                stmt.close();
                conn.close();
            }
        }
    }

    /**
     * 带有输出参数（OUT）的存储过程
     */
    public void procOutParam() throws SQLException {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            //获取连接对象
            conn = DriverManager.getConnection(jdbcUrl, username, password);
            //预编译
            stmt = conn.prepareCall(proc_out_select_sql);
            //传递输入参数
            stmt.setString(1, "张三");
            //设置输出参数(注册输出参数)
            /**
             * 参数一： 参数位置
             * 参数二： 存储过程中的输出参数的jdbc类型
             */
            stmt.registerOutParameter(2, Types.INTEGER);
            //执行存储过程
            rs = stmt.executeQuery();
            /**
             * 得到输出参数的值
             * 索引值： 预编译sql中的输出参数的位置
             * getXX方法专门用于获取存储过程中的输出参数
             */
            Integer result = stmt.getInt(2);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
                stmt.close();
                conn.close();
            }
        }
    }

}
