package com.utils;

import java.util.ResourceBundle;

/**
 *	In this class,I will show you the second method to load the properties of mysql.
 *	This method is easier than method introduced in the JDBCUtil.
 *	But this properties must also be put under the directory src. 
 *	In this class,I will not to write method to get Connection and release resource of mysql.
 *
 */
public class JDBCUtil2 {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	
	static
	{
		//establish relation with file of properties 
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		
		//read the detail of configuration
		driverClass = bundle.getString("driverClass");
		url=bundle.getString("url");
		user=bundle.getString("user");
		password=bundle.getString("password");
		
		//to load driver of mysql
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Filed to load driver of mysql");
		}
		
	}
}
