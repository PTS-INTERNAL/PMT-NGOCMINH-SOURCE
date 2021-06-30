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



public class SystemControlSelectDao {
	
private String param = null;
	
	public SystemControlSelectDao(String param)
	{
		this.param = param;
	}
	
	
	public String excute() throws SQLException
	{
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		result = stmt.executeQuery(getSql());
		System.out.println(getSql());
		String value="";
		while (result.next()) {
			value = result.getString("PARAMETER_VALUE");
		}
		
		return value;
	}
	
	public String getSql()
	{
		StringBuilder sql  = new StringBuilder();
		
		sql.append(" SELECT ");
		sql.append(" 	* ");
		sql.append(" FROM ");
		sql.append(" 	system_control ");
		sql.append(" WHERE PARAMETER_TX=").append("'"+param+"'");
		return sql.toString();
	}
}
