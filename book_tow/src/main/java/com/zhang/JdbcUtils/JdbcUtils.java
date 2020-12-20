package com.zhang.JdbcUtils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;

    private static ThreadLocal<Connection> con1=new ThreadLocal<Connection>();
    static {
        try {
            Properties properties = new Properties();
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从流中加载数据
            properties.load(inputStream);
            // 创建 数据库连接 池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null,说明获取连接失败<br/>有值就是获取连接成功
     */
    public static Connection getConnection(){

        Connection con = con1.get();
        if(con == null){

            try {
                DruidPooledConnection connection = dataSource.getConnection();
                connection.setAutoCommit(false); //设置为自动提交
                con1.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    /**
     * 提交事务并 ，关闭连接
     * @param conn
     */
    public static void close(ResultSet rs, PreparedStatement ps ,Connection conn) {

    }

}
