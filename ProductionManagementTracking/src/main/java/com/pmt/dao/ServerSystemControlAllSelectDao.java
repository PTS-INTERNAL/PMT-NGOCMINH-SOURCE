package com.pmt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSException;

import com.pmt.database.DatabaseConnection;
import com.pmt.database.DatabaseConnectionServer;
import com.pmt.model.SystemControlModel;
import com.pmt.model.UserModel;
import com.pmt.util.Common;



public class ServerSystemControlAllSelectDao {
	
	
	public ServerSystemControlAllSelectDao(String param)
	{
		
	}
	
	
	public List<SystemControlModel> excute() throws SQLException
	{
		DatabaseConnectionServer conn = new DatabaseConnectionServer();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		result = stmt.executeQuery(getSql());
		System.out.println(getSql());
		List<SystemControlModel> lst = new ArrayList<SystemControlModel>();
		while (result.next()) {
			SystemControlModel model =new SystemControlModel();
			model.setPrammeter_tx(result.getString("PARAMETER_TX"));
			model.setParam_value(result.getString("PARAMETER_VALUE"));
			lst.add(model);
		}
		
		return lst;
	}
	
	public String getSql()
	{
		StringBuilder sql  = new StringBuilder();
		
		sql.append(" SELECT ");
		sql.append(" 	* ");
		sql.append(" FROM ");
		sql.append(" 	system_control ");
		return sql.toString();
	}
}
