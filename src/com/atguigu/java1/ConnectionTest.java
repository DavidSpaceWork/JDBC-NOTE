package com.atguigu.java1;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author DavidWong
 * @create 2020-03-28 9:32
 */
public class ConnectionTest {
/*
手动获取连接的三种方式
 */
//方式一：
    @Test
    public void test1() throws Exception{

    //获取连接的四个基本要素：
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String name = "root";
        String password = "root";
    // 2.加载驱动

        Class clazz = Class.forName(driverName);
        Driver driver = (Driver) clazz.newInstance();
        DriverManager.registerDriver(driver);

        // 3.获取连接
        Connection connection = DriverManager.getConnection(url, name, password);
        System.out.println(connection);
    }
    //方式二：改进加载
    @Test
    public void test2()throws Exception {
        //获取连接的四个基本要素：
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test";
        String name = "root";
        String password = "root";
        // 2.加载驱动
         Class.forName(driverName);

        // 3.获取连接
        Connection connection = DriverManager.getConnection(url, name, password);

    }
    /*
    方式三：使用配置文件加载
    好处：实现数据和代码的分离，解耦
          省去重新编译的过程
     */
    @Test
    public void test3() throws Exception{
        //使用ClassLoader加载src路径下的配置文件
        Properties properties = new Properties();
        InputStream resourceAsStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(resourceAsStream);

        //获取配置文件的基本信息
        String driverClassName = properties.getProperty("driverClassName");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        //加载驱动类
        Class.forName(driverClassName);

        //获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }
}
