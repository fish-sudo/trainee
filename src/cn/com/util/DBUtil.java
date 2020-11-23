package cn.com.util;


import cn.com.config.JDBCAndChatContentCconfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * 数据存储层
 * @author dsl1999
 *
 */
public abstract class DBUtil {
    private static Properties properties = null;
    private static Connection connection = null;
    static {
        properties = JDBCAndChatContentCconfig.getJDBCConfig();
        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private DBUtil(){

    }
    /**
     * 得到连接
     * @return 连接
     */
    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void free(Connection conn, Statement pstm){
        if(pstm != null){
            try {
                pstm.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 对于查询的关流
     * @param conn 连接对象
     * @param pstm 句柄对象
     * @param rs 结果集对象
     */
    public static void free(Connection conn, Statement pstm, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(pstm != null){
            try {
                pstm.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
