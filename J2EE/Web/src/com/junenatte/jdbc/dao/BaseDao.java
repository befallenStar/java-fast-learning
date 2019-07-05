package com.junenatte.jdbc.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ReadProperties properties = ReadProperties.getInstance();

    private Connection getConnection() {
        try {
            Class.forName(properties.driver);
            conn = DriverManager.getConnection(properties.url, properties.username, properties.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    int update(String sql, Object... objects) {
        if (getConnection() == null)
            return -1;
        try {
            stmt = addAddition(sql, objects);
            if (stmt != null)
                return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    ResultSet query(String sql, Object... objects) {
        if (getConnection() == null)
            return null;
        try {
            stmt = addAddition(sql, objects);
            if (stmt != null)
                return stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PreparedStatement addAddition(String sql, Object... objects) {
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            if (objects != null && objects.length > 0) {
                int i = 1;
                for (Object obj : objects) {
                    stmt.setObject(i, obj);
                    i++;
                }
            }
            return stmt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> getListBySql(Class<T> tClass, String sql, Object... objects) {
        ResultSet rs = this.query(sql, objects);
        List<T> list = new ArrayList<>();
        try {
            Field[] fields = tClass.getDeclaredFields();
            while (rs.next()) {
                T t = tClass.newInstance();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    Object objValue = rs.getObject(fieldName);
                    field.set(t, objValue);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return list;
    }

    private void close() {
        try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
