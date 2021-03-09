package com.zhang.dao.impl;




import com.zhang.JdbcUtils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.dao
 * @date:2020/12/3
 */
public abstract class BaseDao {

    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();
    //update、delete、insert
    public  void commonsUpdate(String sql,Object ...args){

        PreparedStatement ps=null;
        try {
            Connection connection = JdbcUtils.getConnection();

            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //select 多条数据
    public <E> List<E> selectList(String sql,Class<E> t,Object...args){
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            List<E> list=new ArrayList<>();
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()){
                E e = t.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i+1);
                    Field field = t.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(e,columnValue);
                }
                list.add(e);
            }


            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //select 单条数据
    public <E> E selectObject(String sql,Class<E> t,Object...args){
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            Connection connection = JdbcUtils.getConnection();

            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (rs.next()){
                E e = t.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i+1);
                    Field field = t.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(e,columnValue);
                }
            return e;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return null;

    }

    //返回特殊字段
    public <E> E selectDiff(String sql,Object...args){
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            Connection connection = JdbcUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            if (rs.next()){
                Object object = rs.getObject(1);

                return (E) object;
                }



        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;

    }


    /**
     * 执行返回一行一列的sql语句
     * @param sql   执行的sql语句
     * @param args  sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args){

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }

//-------------------------------------------------------------------------------------------------------------------------










}
