package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.utils.JDBCUtil;

/**
 * to realize the insert,delete,update and select against the information of user in mydb1 
 *
 */
public class MainApp {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet re;
	
	
	
	//Delete information of user in the mydb1 
		@Test
		public void test2()
		{
			try {
				conn=JDBCUtil.getConnection();
				stmt=conn.prepareStatement("DELETE FROM user WHERE id=?");
				stmt.setInt(1, 1);
				int update = stmt.executeUpdate();
				if(update>0)
				{
					System.out.println("success");
				}
				else
					System.out.println("fail");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally
			{
				JDBCUtil.release(conn, stmt, null);
			}
			
		}
	
	
	//select information of user in the mydb1
	@Test
	public void test1()
	{
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement("SELECT * FROM user");
			re=stmt.executeQuery();
			while(re.next())
			{
				String username=re.getString("username");
				String password=re.getString("password");
				System.out.println(username+":"+password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.release(conn, stmt, null);
		}
		
	}
	//update information of user in the mydb1 
	@Test
	public void test()
	{
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement("UPDATE user SET username=? WHERE id=?");
			stmt.setString(1,"tom");
			stmt.setInt(2, 1);
			int update = stmt.executeUpdate();
			if(update>0)
			{
				System.out.println("success");
			}
			else
				System.out.println("fail");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.release(conn, stmt, null);
		}
		
	}
	
	//insert user to database
	@Test
	public void test3()
	{
		try
		{
			conn=JDBCUtil.getConnection();
			String sql="INSERT INTO user VALUES (?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, 1);
			stmt.setString(2,"jack");
			stmt.setString(3, "123");
			int update = stmt.executeUpdate();
			if(update>0)
			{
				System.out.println("success");
			}
			else
			{
				System.out.println("fail");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.release(conn, stmt, re);
		}
	}
}
