package com.pmt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pmt.database.DatabaseConnection;
import com.pmt.model.ProductionOrderModel;
import com.pmt.model.UserModel;
import com.pmt.util.Common;



public class SyncProductionOrderSelectDao {
	
	
	public SyncProductionOrderSelectDao()
	{
	
	}
	
	
	public List<ProductionOrderModel> excute() throws SQLException
	{
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		Statement stmt = connectString.createStatement();
		ResultSet result = null;
		System.out.println(getSql());
		result = stmt.executeQuery(getSql());
		
		List<ProductionOrderModel> lstProduct =new ArrayList<ProductionOrderModel>();
		while (result.next()) {
			ProductionOrderModel product = new ProductionOrderModel();
			product.setOrderCd(result.getString("ORDER_CD"));
			product.setCustomerName(result.getString("CUSTOMER_NAME")); 
			product.setProduction(result.getString("PRODUCTION")); 
			product.setHD_PO(result.getString("HD_PO")); 
			product.setPSX(result.getString("PSX")); 
			product.setRecieveDt(result.getString("RECIEVE_DT")); 
			product.setReleaseScheDt(result.getString("RELEASE_SCHE_DT")); 
			product.setReleaseRelDt(result.getString("RELEASE_REAL_DT")); 
			product.setNote(result.getString("NOTE")); 
			product.setStatus(result.getString("STATUS")); 
			product.setInsertId(result.getString("INSERT_ID")); 
			product.setInsertDt(result.getString("INSERT_DT")); 
			product.setUpdateId(result.getString("UPDATE_ID")); 
			product.setUpdateDt(result.getString("UPDATE_DT")); 
			product.setDeleteFg(result.getString("DELETE_FG")); 
			
			lstProduct.add(product);
		}
		return lstProduct;
	}
	
	public String getSql()
	{
		StringBuilder sql  = new StringBuilder();
		
		sql.append(" SELECT * ");
		sql.append(" 	  FROM production_order WHERE 1=1 AND ");
		sql.append(" 	  IS_MODE <> 'sync' ");
		return sql.toString();
	}
}
