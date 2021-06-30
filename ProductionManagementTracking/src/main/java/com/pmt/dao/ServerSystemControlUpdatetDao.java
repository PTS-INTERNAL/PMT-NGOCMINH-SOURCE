package com.pmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pmt.database.DatabaseConnection;
import com.pmt.database.DatabaseConnectionServer;
import com.pmt.model.ProductionOrderModel;
import com.pmt.util.Common;



public class ServerSystemControlUpdatetDao {
	String param = null;
	String value = null;
	
	public ServerSystemControlUpdatetDao(String p, String v )
	{
		this.param = p;
		this.value = v;
	}
	
	public int excute() throws SQLException
	{
		int result = 0;
		
		DatabaseConnectionServer conn = new DatabaseConnectionServer();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSQL());
		System.out.println(getSQL());
		result = sqlStatement.executeUpdate();
		
		return result;
	}
	
	public String getSQL()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" UPDATE");
		sql.append(" system_control");
		sql.append(" SET ");
		sql.append(" 	PARAMETER_VALUE=").append("'"+value+"'");
		sql.append(" WHERE ");
		sql.append(" 	 PARAMETER_TX = ").append("'"+param+"'");
		
		return sql.toString();
	}
}
