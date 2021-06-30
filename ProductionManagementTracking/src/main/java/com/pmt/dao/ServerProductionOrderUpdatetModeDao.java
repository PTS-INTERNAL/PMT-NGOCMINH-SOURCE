package com.pmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pmt.database.DatabaseConnection;
import com.pmt.database.DatabaseConnectionServer;
import com.pmt.model.ProductionOrderModel;
import com.pmt.util.Common;



public class ServerProductionOrderUpdatetModeDao {
	ProductionOrderModel  product = null;
	
	public ServerProductionOrderUpdatetModeDao(ProductionOrderModel product )
	{
		this.product = product;
	}
	
	public int excute() throws SQLException
	{
		int result = 0;
		
		DatabaseConnectionServer conn = new DatabaseConnectionServer();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSQL());
		System.out.println(getSQL());
		sqlStatement.setString(1, product.getOrderCd());
		result = sqlStatement.executeUpdate();
		
		return result;
	}
	
	public String getSQL()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" UPDATE");
		sql.append(" production_order");
		sql.append(" 	SET IS_MODE= 'sync'");
		sql.append(" WHERE ");
		sql.append(" 	 ORDER_CD =  ?");
		
		return sql.toString();
	}
}
