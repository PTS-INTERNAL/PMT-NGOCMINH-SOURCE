package com.pmt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pmt.database.DatabaseConnection;
import com.pmt.database.DatabaseConnectionServer;
import com.pmt.model.ProductionOrderModel;
import com.pmt.model.UserModel;
import com.pmt.util.Common;



public class ServerProductionOrderSelectDao {
	
private ProductionOrderModel production = null;
	
	public ServerProductionOrderSelectDao(ProductionOrderModel production)
	{
		this.production = production;
	}
	
	
	public List<ProductionOrderModel> excute() throws SQLException
	{
		DatabaseConnectionServer conn = new DatabaseConnectionServer();
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
			product.setIsMode(result.getString("IS_MODE")); 
			
			lstProduct.add(product);
		}
		return lstProduct;
	}
	
	public String getSql()
	{
		StringBuilder sql  = new StringBuilder();
		
		sql.append(" SELECT ORDER_CD ");
		sql.append(" 	      ,CUSTOMER_NAME ");
		sql.append(" 	      ,PRODUCTION ");
		sql.append(" 	      ,HD_PO ");
		sql.append(" 	      ,PSX ");
		sql.append(" 	      ,RECIEVE_DT ");
		sql.append(" 	      ,RELEASE_SCHE_DT ");
		sql.append(" 	      ,RELEASE_REAL_DT ");
		sql.append(" 	      ,NOTE ");
		sql.append(" 	      ,STATUS ");
		sql.append(" 	      ,INSERT_ID ");
		sql.append(" 	      ,INSERT_DT ");
		sql.append(" 	      ,UPDATE_ID ");
		sql.append(" 	      ,UPDATE_DT ");
		sql.append(" 	      ,IS_MODE ");
		sql.append(" 	      ,STR_TO_DATE(RELEASE_SCHE_DT, '%d,%m,%Y') AS DATE_CONVERT1 ");
		sql.append(" 	      ,STR_TO_DATE(RECIEVE_DT, '%d,%m,%Y') AS DATE_CONVERT2 ");
		sql.append(" 	  FROM production_order WHERE 1=1");
		if(production !=null)
		{
			if(Common.isNotEmpty(production.getOrderCd()))
			{
				sql.append(" 	  AND  ORDER_CD = ").append("'"+production.getOrderCd()+"'");
			}
			if(Common.isNotEmpty(production.getCustomerName()))
			{
				sql.append(" 	  AND  CUSTOMER_NAME = ").append("'"+production.getCustomerName()+"'");
			}
			if(Common.isNotEmpty(production.getProduction()))
			{
				sql.append(" 	  AND  PRODUCTION = ").append("'"+production.getProduction()+"'");
			}
			if(Common.isNotEmpty(production.getHD_PO()))
			{
				sql.append(" 	  AND  HD_PO = ").append("'"+production.getOrderCd()+"'");
			}
			if(Common.isNotEmpty(production.getPSX()))
			{
				sql.append(" 	  AND  PSX = ").append("'"+production.getOrderCd()+"'");
			}
			if(Common.isNotEmpty(production.getRecieveDt()))
			{
				sql.append(" 	  AND  RECIEVE_DT >= ").append("'"+production.getRecieveDt()+"'");
			}
			if(Common.isNotEmpty(production.getRecieveDtEnd()))
			{
				sql.append(" 	  AND  RECIEVE_DT <= ").append("'"+production.getRecieveDtEnd()+"'");
			}
			if(Common.isNotEmpty(production.getReleaseScheDt()))
			{
				sql.append(" 	  AND  RELEASE_SCHE_DT >= ").append("'"+production.getReleaseScheDt()+"'");
			}
			if(Common.isNotEmpty(production.getReleaseScheDtEnd()))
			{
				sql.append(" 	  AND  RELEASE_SCHE_DT <= ").append("'"+production.getReleaseScheDtEnd()+"'");
			}
			if(Common.isNotEmpty(production.getStatus()))
			{
				sql.append(" 	  AND  STATUS = ").append("'"+production.getStatus()+"'");
			}
			if(Common.isNotEmpty(production.getDeleteFg()))
			{
				sql.append(" 	  AND  DELETE_FG = ").append("'"+production.getDeleteFg()+"'");
			}
		}
		sql.append(" 	  ORDER BY DATE_CONVERT1, DATE_CONVERT2 ASC ");
		
		
		
		return sql.toString();
	}
}
