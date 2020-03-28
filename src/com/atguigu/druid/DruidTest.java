package com.atguigu.druid;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author DavidWong
 * @create 2020-03-28 10:48
 */
public class DruidTest {

    //不使用配置文件的方式
    @Test
    public void test1() throws Exception{
        DruidDataSource dataSource = new DruidDataSource();
        //设置连接的基本参数
        //把set后面的词语当成一个单词，配置文件中的参数名与之对应
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
                //配置其他参数
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
                //获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
    //使用配置文件的方式
    @Test
    public void test2() throws Exception{
        //加载配置文件
        Properties properties = new Properties();
        InputStream resourceAsStream = DruidTest.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        //使用配置文件，返回DataSource实例
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
