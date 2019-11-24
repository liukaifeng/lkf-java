package com.lkf.jdbc;

import java.sql.*;
import java.util.Arrays;

public class ResultSetDemo {
    private static final String QUERY = "select id,name,email,country,password from Users";

    public static void main(String[] args) throws SQLException {
        insertRowInResultSetObject();
    }


    private static void insertRowInResultSetObject() {
        String QUERY = "select id,name,email,country,password from Users where id = 1";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
             Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);
             ResultSet uprs = stmt.executeQuery(QUERY)) {
            uprs.moveToInsertRow();
            uprs.updateInt(1, 100);
            uprs.updateString(2, "博士生");
            uprs.updateString(3, "boss@qq.com");
            uprs.updateString(4, "China");
            uprs.updateString(5, "325468");
            uprs.insertRow();
            uprs.beforeFirst();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    private static void parameterizedBatchUpdate() {
        String INSERT_USERS_SQL = "INSERT INTO users" + "  (id, name, email, country, password) VALUES " +
                " (?, ?, ?, ?, ?);";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            connection.setAutoCommit(false);

            preparedStatement.setInt(1, 8);
            preparedStatement.setString(2, "悟空");
            preparedStatement.setString(3, "wukong@qq.com");
            preparedStatement.setString(4, "China");
            preparedStatement.setString(5, "189398");
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 9);
            preparedStatement.setString(2, "八戒");
            preparedStatement.setString(3, "bajie@qq.com");
            preparedStatement.setString(4, "China");
            preparedStatement.setString(5, "189398");
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 10);
            preparedStatement.setString(2, "唐生");
            preparedStatement.setString(3, "tangsheng@qq.com");
            preparedStatement.setString(4, "China");
            preparedStatement.setString(5, "189398");
            preparedStatement.addBatch();

            preparedStatement.setInt(1, 11);
            preparedStatement.setString(2, "沙和尚");
            preparedStatement.setString(3, "shaheshang.com");
            preparedStatement.setString(4, "China");
            preparedStatement.setString(5, "189398");
            preparedStatement.addBatch();

            int[] updateCounts = preparedStatement.executeBatch();
            System.out.println(Arrays.toString(updateCounts));
            connection.commit();
            connection.setAutoCommit(true);
        } catch (BatchUpdateException batchUpdateException) {
            printBatchUpdateException(batchUpdateException);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    /**
     * 使用 Statement 对象进行批处理更新
     */
    private static void batchUpdate() {
        //Step 1: 创建 Connection 对象
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
             // Step 2:使用 connection 创建 statement 对象
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.addBatch("INSERT INTO Users VALUES (3, '李梅', 'limei@qq.com', 'China', '123789');");
            statement.addBatch("INSERT INTO Users VALUES (4, '韩磊磊', 'hanleilei@qq.com', 'China', '123789');");
            statement.addBatch("INSERT INTO Users VALUES (5, '乔治', 'qiaozhi@qq.com', 'China', '123789');");
            statement.addBatch("INSERT INTO Users VALUES (6, '佩奇', 'peiqi@qq.com', 'China', '123789');");
            statement.addBatch("INSERT INTO Users VALUES (7, '光头强', 'guangtouqiang@qq.com', 'China', '123789');");
            int[] updateCounts = statement.executeBatch();
            System.out.println(Arrays.toString(updateCounts));
            connection.commit();
        } catch (BatchUpdateException batchUpdateException) {
            printBatchUpdateException(batchUpdateException);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    public static void printBatchUpdateException(BatchUpdateException b) {
        System.err.println("----BatchUpdateException----");
        System.err.println("SQLState:  " + b.getSQLState());
        System.err.println("Message:  " + b.getMessage());
        System.err.println("Vendor:  " + b.getErrorCode());
        System.err.print("Update counts:  ");
        int[] updateCounts = b.getUpdateCounts();

        for (int i = 0; i < updateCounts.length; i++) {
            System.err.print(updateCounts[i] + "   ");
        }
    }


    public static void retrievingValueByDigital() {
        // Step 1: 创建 Connection 对象
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");

             // Step 2:使用 connection 创建 statement 对象
             Statement stmt = connection.createStatement();

             // Step 3: 执行查询或更新
             ResultSet rs = stmt.executeQuery(QUERY)) {

            // Step 4: 处理 ResultSet 对象
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
    }

    public static void cursorHoldabilitySupport(Connection conn)
            throws SQLException {

        DatabaseMetaData dbMetaData = conn.getMetaData();
        System.out.println("ResultSet.HOLD_CURSORS_OVER_COMMIT = " +
                ResultSet.HOLD_CURSORS_OVER_COMMIT);

        System.out.println("ResultSet.CLOSE_CURSORS_AT_COMMIT = " +
                ResultSet.CLOSE_CURSORS_AT_COMMIT);

        System.out.println("Default cursor holdability: " +
                dbMetaData.getResultSetHoldability());

        System.out.println("Supports HOLD_CURSORS_OVER_COMMIT? " +
                dbMetaData.supportsResultSetHoldability(
                        ResultSet.HOLD_CURSORS_OVER_COMMIT));

        System.out.println("Supports CLOSE_CURSORS_AT_COMMIT? " +
                dbMetaData.supportsResultSetHoldability(
                        ResultSet.CLOSE_CURSORS_AT_COMMIT));
    }

    private static void modifyUserName() {
        String QUERY = "select id,name,email,country,password from Users where id = 1";
        // Step 1:创建 connection 对象
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/lkf_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT", "root", "root");
             // Step 2:使用connection 对象创建一个statement 对象
             Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);
             // Step 3: 执行查询或更新操作
             ResultSet rs = stmt.executeQuery(QUERY)) {
            // Step 4: 处理结果集对象ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("更新之前的用户名 : " + name);
                rs.updateString("name", name + "_update");
                rs.updateRow();
                System.out.println("更新之后的用户名  : " + rs.getString("name"));
            }
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
