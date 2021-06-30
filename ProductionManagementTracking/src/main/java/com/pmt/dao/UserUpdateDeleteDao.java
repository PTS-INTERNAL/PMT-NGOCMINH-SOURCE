package com.pmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pmt.database.DatabaseConnection;
import com.pmt.model.ProductionOrderModel;
import com.pmt.util.Common;



public class UserUpdateDeleteDao {
	String   cd = null;
	
	public UserUpdateDeleteDao(String   cd )
	{
		this.cd = cd;
	}
	
	public int excute() throws SQLException
	{
		int result = 0;
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSQL());
		System.out.println(getSQL());
		result = sqlStatement.executeUpdate();
		
		return result;
	}
	
	public String getSQL()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" DELETE FROM ");
		sql.append(" user_system ");
		sql.append(" WHERE ");
		sql.append(" 	 USER_ID=").append("'"+cd+"'");
	
		return sql.toString();
	}
}
