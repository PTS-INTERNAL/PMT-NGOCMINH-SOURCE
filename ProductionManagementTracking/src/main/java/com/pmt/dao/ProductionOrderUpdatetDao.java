package com.pmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pmt.database.DatabaseConnection;
import com.pmt.model.ProductionOrderModel;
import com.pmt.util.Common;



public class ProductionOrderUpdatetDao {
	ProductionOrderModel  product = null;
	
	public ProductionOrderUpdatetDao(ProductionOrderModel product )
	{
		this.product = product;
	}
	
	public int excute() throws SQLException
	{
		int result = 0;
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSQL());
		System.out.println(getSQL());
		sqlStatement.setString(1, product.getCustomerName());
		sqlStatement.setString(2, product.getProduction());
		sqlStatement.setString(3, product.getHD_PO());
		sqlStatement.setString(4, product.getPSX());
		sqlStatement.setString(5, product.getRecieveDt());
		sqlStatement.setString(6, product.getReleaseScheDt());
		sqlStatement.setString(7, product.getNote());
		sqlStatement.setString(8, product.getUpdateId());
		sqlStatement.setString(9, product.getUpdateDt());
		sqlStatement.setString(10, product.getIsMode());
		sqlStatement.setString(11, product.getOrderCd());
		result = sqlStatement.executeUpdate();
		
		return result;
	}
	
	public String getSQL()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" UPDATE");
		sql.append(" production_order");
		sql.append(" SET ");
		sql.append(" 	CUSTOMER_NAME= ?");
		sql.append(" 	,PRODUCTION= ?");
		sql.append(" 	,HD_PO= ?");
		sql.append(" 	,PSX= ?");
		sql.append(" 	,RECIEVE_DT= ?");
		sql.append(" 	,RELEASE_SCHE_DT= ?");
		//sql.append(" 	,RELEASE_REAL_DT=").append("'"+product.getReleaseRelDt()+"'");
		sql.append(" 	,NOTE= ?");
		sql.append(" 	,UPDATE_ID= ?");
		sql.append(" 	,UPDATE_DT= ?");
		sql.append(" 	,IS_MODE= ?");
		sql.append(" WHERE ");
		sql.append(" 	 ORDER_CD =  ?");
		
		return sql.toString();
	}
}
