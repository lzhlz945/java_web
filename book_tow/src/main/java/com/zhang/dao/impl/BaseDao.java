package com.zhang.dao.impl;




import com.zhang.JdbcUtils.JdbcUtils;

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

    //update、delete、insert
    public static void commonsUpdate(Connection con,String sql,Object ...args){

        PreparedStatement ps=null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null,ps,con);
        }
    }

    //select 多条数据
    public <E> List<E> selectList(Connection con,String sql,Class<E> t,Object...args){
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            List<E> list=new ArrayList<>();
            ps = con.prepareStatement(sql);
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
        } finally {
            JdbcUtils.close(rs,ps,null);
        }
        return null;

    }

    //select 单条数据
    public <E> E selectObject(Connection con,String sql,Class<E> t,Object...args){
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            ps = con.prepareStatement(sql);
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
        } finally {
            JdbcUtils.close(rs,ps,null);
        }
        return null;

    }

    //返回特殊字段
    public <E> E selectDiff(Connection con,String sql,Object...args){
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            if (rs.next()){
                Object object = rs.getObject(1);

                return (E) object;
                }



        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            JdbcUtils.close(rs,ps,null);
        }
        return null;

    }

//-------------------------------------------------------------------------------------------------------------------------










}
