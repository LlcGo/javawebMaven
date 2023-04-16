package com.lc.bbs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC操作工具类-提供数据库通用操作增删改查方法，减少代码冗余
 * @author zhukang
 *
 */
public class JDBCUtil {

	/**
	 * 获取数据库连接的通用方法
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		
		// 1 准备数据库连接的基本参数
		String driverClass = "com.mysql.cj.jdbc.Driver";
		String jdbcUrl = "jdbc:mysql://192.168.190.100:3306/bbsdb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
		String user = "root";
		String password = "root";
		
		// 2 加载驱动
		Class.forName(driverClass);
		
		// 3 获取数据库连接
		return DriverManager.getConnection(jdbcUrl, user, password);
	}
	
	/**
	 * 增删改的通用方法，只需要提供执行的SQL语句和SQL语句中对应的参数，就可以执行执行并返回影响行数
	 * 细节：Object ... params 写法含义：... 代表任意多个参数，必须写在方法形参的最后，用于从该参数位置开始，后续所有的参数都自动接收，获取成参数数组
	 * @return
	 */
	public static int executeUpate(String executeSql, Object ... params){
		
		// 定义数据库连接和操作对象
		// 数据库连接对象
		Connection conn = null;
		// 预处理数据库操作对象
		PreparedStatement pstmt = null;
		
		// 定义执行增删改SQL语句，影响行数变量
		int row = 0;
		
		// 公共的增删改操作处理
		try {
			// 获取数据库连接
			conn = getConnection();
			
			// 创建预处理数据库操作对象
			pstmt = conn.prepareStatement(executeSql);
			
			// 动态参数处理：根据传入的预编译SQL语句，替换其中 ? ,
			// 前提：预编译SQL语句中的?个数，要和传入多个参数个数匹配
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			
			// 执行增删改操作，返回影响行数
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放数据库资源
			releaseJDBCResource(conn, pstmt, null);
		}
		
		// 返回影响行数
		return row;
	}
	
	/**
	 * 查询的通用方法，只需要提供执行的SQL语句和SQL语句中对应的参数，就可以执行执行并返回查询结果集
	 * 细节：Object ... params 写法含义：... 代表任意多个参数，必须写在方法形参的最后，用于从该参数位置开始，后续所有的参数都自动接收，获取成参数数组
	 * @return
	 */
	public static ResultSet executeSelect(String executeSql, Object ... params){
		
		// 定义数据库连接和操作对象
		// 数据库连接对象
		Connection conn = null;
		// 预处理数据库操作对象
		PreparedStatement pstmt = null;
		// 查询结果集对象
		ResultSet rs = null;
		
		// 公共的查询操作处理
		try {
			// 获取数据库连接
			conn = getConnection();
			
			// 创建预处理数据库操作对象
			pstmt = conn.prepareStatement(executeSql);
			
			// 动态参数处理：根据传入的预编译SQL语句，替换其中 ? ,
			// 前提：预编译SQL语句中的?个数，要和传入多个参数个数匹配
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			
			// 执行增删改操作，返回影响行数
			rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放数据库资源，此处不能释放，rs有结果集，要返回，在返回结果集之前不能释放，否则外层获取的rs不可用
			// releaseJDBCResource(conn, pstmt, null);
		}
		
		// 返回查询的结果集对象
		return rs;
	}
	
	/**
	 * 释放数据库连接资源的通用方法
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void releaseJDBCResource(Connection conn, Statement stmt, ResultSet rs){
		
		// 释放数据库连接资源
		try {
			if (null != rs) {
				rs.close();
			}
			if (null != stmt) {
				stmt.close();
			}
			if (null != conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

















