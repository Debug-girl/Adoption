package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 工具类 (Util)
 * 提供与 MySQL 数据库的连接功能
 */
public class DBUtil {

    // MySQL 数据库的 URL，用户名，密码
    private static final String URL = "jdbc:mysql://localhost:3306/adoption"; // 数据库URL
    private static final String USER = "root"; // 数据库用户名
    private static final String PASSWORD = "123456"; // 数据库密码

    /**
     * 获取数据库连接的方法
     * @return Connection 数据库连接对象
     * @throws SQLException 如果连接失败抛出SQL异常
     */
    public static Connection getConnection() {  //返回一个与数据库的连接
        Connection connection = null;
        try {
            // 加载MySQL驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取数据库连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到 MySQL JDBC 驱动程序");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("无法连接到数据库");
            e.printStackTrace();
            //throw e;  // 抛出SQL异常，供上层处理
        }
        return connection;
    }

    /**
     * 关闭数据库连接的方法
     * @param connection 需要关闭的数据库连接对象
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("数据库连接已关闭");
            } catch (SQLException e) {
                System.out.println("未能关闭连接");
                e.printStackTrace();
            }
        }
    }




}
