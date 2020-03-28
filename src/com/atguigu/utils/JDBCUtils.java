package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.atguigu.druid.DruidTest;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author DavidWong
 * @create 2020-03-28 11:48
 */
public class JDBCUtils {
   public  static DataSource dataSource;
    static {

        Properties properties = new Properties();
        try {
            InputStream resourceAsStream = DruidTest.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
