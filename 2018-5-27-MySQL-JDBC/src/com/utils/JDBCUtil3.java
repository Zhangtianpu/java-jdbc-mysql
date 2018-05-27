package com.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *	the third method to load the properties,and to get detail of configuration of mysql 
 *
 */
public class JDBCUtil3 {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	static
	{
		//establish relation with file of properties 
		try {
			// get the absoulte path of properties in the disc 
			String path = JDBCUtil.class.getResource("/").getPath()+"JDBC.properties";
			
			InputStream is=new FileInputStream(path);
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
}
