package com.briup.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.commons.beanutils.BeanUtils;

import com.briup.bean.User;

/**
 * 简化Dao层操作
 * */
public class BaseDao {
	//MySQL连接参数
	
		/*private static final String URL = "jdbc:mysql://localhost:3306/estore?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=TRUE&useSSL=false";
		private static final String USER = "root";
		private static final String PASSWORD = "xxxxx1355832099";
		private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";*/
	//oracle连接参数
		private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		private static final String USER = "bookstore";
		private static final String PASSWORD = "bookstore";
		private static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
		
		//注册驱动
		static {
			try {
				Class.forName(DRIVER_CLASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		/**
		 * 得到连接对象
		 * @return
		 */
		public Connection getConnection() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return conn;
		}
		/**
		 * 关闭连接对象
		 */
		public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	 
		/**
		 * 关闭连接对象
		 */
		public void closeAll(Connection conn, Statement stmt) {
			this.closeAll(conn, stmt, null);
		}
		
		/**
		 * 通用的增删改的方法
		 * @return 返回影响的行数
		 */
		public int executeUpdate(String sql, Object[] params) {
			//得到连接对象
			Connection conn = null;
			PreparedStatement stmt = null;
			//影响的行数
			int rows = 0;
			try {
				 conn = getConnection();
				 stmt = conn.prepareStatement(sql);
				 //通过参数元数据得到参数个数
				ParameterMetaData pmd =  stmt.getParameterMetaData();
				//设置参数
				for (int i = 0; i < pmd.getParameterCount(); i++) {
					stmt.setObject(i+1, params[i]);
				}
				rows  = stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll(conn, stmt);
			}
			return rows;
		}
		
		/**
		 * 通用的查询方法，封装成List<T>
		 * 使用了泛型方法
		 * 使用这个方法的前提：数据库表的字段名称和JavaBean的属性名称保持一致
		 * 在这个方法调用了
		 * BeanUtils.setProperty(obj, columnName, value)
		 * 来实现，不然就要使用反射来完成类似的操作了
		 * @param sql 查询语句
		 * @param params 执行sql语句的参数
		 * @param clazz 查找后的数据要封装的对象
		 */
		public <T> List<T> find(String sql, Object[] params, Class<T> clazz) {
			//得到连接对象
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			//创建集合
			List<T> list = new ArrayList<T>();
			try {
				conn = getConnection();
				stmt = conn.prepareStatement(sql);
				//得到参数的个数
				ParameterMetaData pmd = stmt.getParameterMetaData();
				for (int i = 0; i < pmd.getParameterCount(); i++) {
					//给参数赋值
					stmt.setObject(i+1, params[i]);
				}
				//运行得到结果集
				rs = stmt.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				//遍历结果集
				while (rs.next()) {
					T obj = clazz.newInstance(); //实例化对象
					//得到结果集的列数
					for (int i = 0; i < rsmd.getColumnCount(); i++) {
						//得到列名
						String colName = rsmd.getColumnName(i+1);
						//将大写的列名转成全小写，和属性名保持一致
						colName = colName.toLowerCase();
						//列号从1开始，得到每1列的值
						Object value = rs.getObject(colName);
						//把名字和值赋值到对象中
						BeanUtils.setProperty(obj, colName, value);
					}
					//添加到列表中
					list.add(obj);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(conn, stmt, rs);
			}
			return list;
		}

}
