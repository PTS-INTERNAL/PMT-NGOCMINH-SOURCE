package com.pmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pmt.database.DatabaseConnection;
import com.pmt.model.ProductionOrderModel;
import com.pmt.model.UserModel;
import com.pmt.util.Common;



public class UserInsertDao {
	UserModel  user = null;
	
	public UserInsertDao(UserModel  user )
	{
		this.user = user;
	}
	
	public int excute() throws SQLException
	{
		int result = 0;
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection connectString = conn.getConnection();
		PreparedStatement sqlStatement = connectString.prepareStatement(getSQL());
		System.out.println(getSQL());
		
		sqlStatement.setString(1,user.getUserCd());
		sqlStatement.setString(2,user.getFullName());
		sqlStatement.setString(3,user.getUserName());
		sqlStatement.setString(4,user.getPassword());
		sqlStatement.setString(5,user.getRole());
		sqlStatement.setString(6,user.getInsertId());
		sqlStatement.setString(7,user.getInsertDt());
		sqlStatement.setString(8,user.getUpdateId());
		sqlStatement.setString(9,user.getUpdateDt());
		

		
		result = sqlStatement.executeUpdate();
		
		return result;
	}
	
	public String getSQL()
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append(" INSERT INTO");
		sql.append(" user_system");
		sql.append(" (");
		sql.append(" 	 USER_ID");
		sql.append(" 	,FULL_NAME");
		sql.append(" 	,USERNAME");
		sql.append(" 	,PASSWORD");
		sql.append(" 	,ROLE");
		sql.append(" 	,INSERT_ID");
		sql.append(" 	,INSERT_DT");
		sql.append(" 	,UPDATE_ID");
		sql.append(" 	,UPDATE_DT");
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
		sql.append(" )");
		
		return sql.toString();
	}
}
