package com.atguigu.druid;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;

import java.sql.Connection;

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
}
