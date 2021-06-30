package com.pmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pmt.database.DatabaseConnection;
import com.pmt.model.ProductionOrderModel;
import com.pmt.util.Common;



public class ProductionOrderInsertDao {
	ProductionOrderModel  product = null;
	
	public ProductionOrderInsertDao(ProductionOrderModel product )
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
		
		sqlStatement.setString(1,product.getOrderCd());
		sqlStatement.setString(2,product.getCustomerName());
		sqlStatement.setString(3,product.getProduction());
		sqlStatement.setString(4,product.getHD_PO());
		sqlStatement.setString(5,product.getPSX());
		sqlStatement.setString(6,product.getRecieveDt());
		sqlStatement.setString(7,product.getReleaseScheDt());
		sqlStatement.setString(8,"");
		sqlStatement.setString(9,product.getNote());
		sqlStatement.setString(10,product.getStatus());
		sqlStatement.setString(11,product.getInsertId());
		sqlStatement.setString(12,product.getInsertDt());
		sqlStatement.setString(13,product.getUpdateId());
		sqlStatement.setString(14,product.getUpdateDt());
		sqlStatement.setString(15,product.getDeleteFg());
		sqlStatement.setString(16,product.getIsMode());

		
		result = sqlStatement.executeUpdate();
		
		return result;
	}
	
	public String getSQL()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO");
		sql.append(" production_order");
		sql.append(" (");
		sql.append(" 	 ORDER_CD");
		sql.append(" 	,CUSTOMER_NAME");
		sql.append(" 	,PRODUCTION");
		sql.append(" 	,HD_PO");
		sql.append(" 	,PSX");
		sql.append(" 	,RECIEVE_DT");
		sql.append(" 	,RELEASE_SCHE_DT");
		sql.append(" 	,RELEASE_REAL_DT");
		sql.append(" 	,NOTE");
		sql.append(" 	,STATUS");
		sql.append(" 	,INSERT_ID");
		sql.append(" 	,INSERT_DT");
		sql.append(" 	,UPDATE_ID");
		sql.append(" 	,UPDATE_DT");
		sql.append(" 	,DELETE_FG");
		sql.append(" 	,IS_MODE");
		
		sql.append(" )");
		sql.append(" VALUES");
		sql.append(" (");
		sql.append(" 	?");//BORROW_CD
		sql.append(" 	,?");//LOAN_CMPN_CD
		sql.append(" 	,?");//LOAN_DEPT
		sql.append(" 	,?");//ASSET_RFID
		sql.append(" 	,?");//BORROW_CMPN_CD
		sql.append(" 	,?");//BORROW_DEPT
		sql.append(" 	,?");//DATE_START
		sql.append(" 	,?");//DATE_END
		sql.append(" 	,?");//REASON
		sql.append(" 	,?");//USER_TS
		sql.append(" 	,?");//INSERT_DT
		sql.append(" 	,?");//STATUS
		sql.append(" 	,?");//STATUS
		sql.append(" 	,?");//STATUS
		sql.append(" 	,?");//STATUS
		sql.append(" 	,?");//STATUS
		sql.append(" )");
		
		return sql.toString();
	}
}
