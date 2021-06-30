package com.pmt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pmt.database.DatabaseConnection;
import com.pmt.model.UserModel;
import com.pmt.util.Common;



public class UserSelectDao {
	
private UserModel user = null;
	
	public UserSelectDao(UserModel user)
	{
		this.user = user;
	}
	
	
	public List<UserModel> excute() throws SQLException
	{
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		result = stmt.executeQuery(getSql());
		System.out.println(getSql());
		List<UserModel> lstUser =new ArrayList<UserModel>();
		while (result.next()) {
			UserModel user = new UserModel();
			user.setFullName(result.getString("FULL_NAME"));
			user.setUserCd(result.getString("USER_ID"));
			user.setUserName(result.getString("USERNAME"));
			user.setPassword(result.getNString("PASSWORD"));
			user.setRole(result.getString("ROLE"));
			user.setUserCd(result.getString("USER_ID"));
			lstUser.add(user);
		}
		
		return lstUser;
	}
	
	public String getSql()
	{
		StringBuilder sql  = new StringBuilder();
		
		sql.append(" SELECT ");
		sql.append(" 	USER_ID ");
		sql.append(" 	,FULL_NAME ");
		sql.append(" 	,USERNAME ");
		sql.append(" 	,PASSWORD ");
		sql.append(" 	,ROLE ");
		sql.append(" FROM ");
		sql.append(" 	user_system ");
		sql.append(" WHERE 1=1");
		if(user!=null)
		{
			if(Common.isNotEmpty(user.getUserName()))
			{
				sql.append(" 	AND USERNAME= ").append("'"+ user.getUserName().trim() +"'");
			}
			if(Common.isNotEmpty(user.getPassword()))
			{
				sql.append(" 	AND PASSWORD= ").append("'"+ user.getPassword().trim() +"'");
			}
			if(Common.isNotEmpty(user.getUserCd()))
			{
				sql.append(" 	AND USER_ID= ").append("'"+ user.getUserCd().trim() +"'");
			}
		}
		
		
		
		return sql.toString();
	}
}
