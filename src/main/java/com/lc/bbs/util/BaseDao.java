package com.lc.bbs.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;

/**
 * @Author Lc
 * @Date 2023/4/22
 * @Description
 */
public class BaseDao<T> {
    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;
    private static Properties p = new Properties();
    private final String DRIVER = p.getProperty("driver");
    private final String URL = p.getProperty("url");
    private final String NAME = p.getProperty("name");
    private final String PWD = p.getProperty("pwd");
    private T t;
//    private List<T> tList;
//
//    public List<T> getTList() {
//        return tList;
//    }
//
//    public void setTList(List<T> tList) {
//        this.tList = tList;
//    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    static {
        try {
            p.load(new FileInputStream("E:\\ideaJava\\javawebMaven\\src\\main\\resources\\database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initConnection() throws Exception {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL,NAME,PWD);
    }

    public int update(String sql,String... params) throws SQLException {
        pst = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++){
            pst.setObject(i+1,params[i]);
        }
        return pst.executeUpdate();
    }

    public T  query(String sql,String...params) throws Exception{
        pst = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pst.setObject(i+1,params[i]);
        }
        rs =pst.executeQuery();
        if(rs.next()){
            Class<?> tc = t.getClass();
            Field[] fields = tc.getDeclaredFields();
            for (Field f : fields) {
                f.set(t,rs.getObject(f.getName()));
            }
        }
        return t;
    }

    public ResultSet batchQuery(String sql, String...params) throws SQLException{
        pst = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pst.setObject(i+1,params[i]);
        }
        return pst.executeQuery();
    }

    public ResultSet selectPage(String sql, Integer index,Integer count) throws SQLException{
        pst = connection.prepareStatement(sql);
        pst.setInt(1,index);
        pst.setInt(2,count);
        return pst.executeQuery();
    }
}
