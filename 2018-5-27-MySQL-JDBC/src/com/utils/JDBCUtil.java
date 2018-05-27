package com.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *	to load the properties of mysql.
 *	The file of properties of mysql must be put in the directory of src in the follow condition. 
 *	This is the first method to load properties.
 *	The second method will show in the JDBCUtil2
 */
public class JDBCUtil {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	//initialize properties
	static
	{
		// get the inputStream of the properties of jdbc.
		try {
			InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties p=new Properties();
			p.load(is);
			//get the Driver of mysql from jdbc.properties
			driverClass=p.getProperty("driverClass");
			url=p.getProperty("url");
			user=p.getProperty("user");
			password=p.getProperty("password");
			Class.forName(driverClass);
		} catch (Exception e) {
			throw new RuntimeException("there's a excepton to load driver of mysql");
		}
	}
	//get connection of mysql
	public static Connection getConnection()
	{
		try {
			return DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			throw new RuntimeException("there's a exception to get connection of mysql");
		}
	}
	// release resources
	public static void release(Connection conn,Statement stmt,ResultSet rs)
	{
		//release the object of resulteSet
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs=null;
		}
		//release the object of Statement
		if(stmt!=null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt=null;
		}
		//release the object of Connection
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn=null;
		}
		
	}
}
