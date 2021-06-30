package com.pmt.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.pmt.util.DatabaseCommon;




public class DatabaseConnectionServer {
	 public  String DB_NAME = "PMT_SEA_SOUTH";
	 public  String DB_IP="45.77.254.67";
	 public  String DB_PORT="1433";
	 public  String DB_URL = "jdbc:sqlserver://"+DB_IP+"\\SQLEXPRESS:"+DB_PORT+";databaseName="+DB_NAME+"";
	 public  String DRIVERSQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	 public   String DB_USER = "sa";
	 public   String DB_PASS = "indruino@123";
	Connection conn = null;
	public DatabaseConnectionServer()
	{
		
	}
	
	public Connection getConnection() {
		
		 String url = "jdbc:mysql://45.77.45.244:3306/ngocminh_production_tracking?serverTimezone=UTC&autoReconnect=true&useSSL=false&&useUnicode=yes&characterEncoding=UTF-8";
		 String username = "root";
		 String password = "indruino@123";
		//String password = "";
		
			  
			// String url = "jdbc:mysql://localhost:3306/production_tracking?serverTimezone=UTC&autoReconnect=true&useSSL=false&&useUnicode=yes&characterEncoding=UTF-8";
				//String username = "root";
				//String password = "";
				Connection connection = null;
				connection = getConnection(url,username,password);
				System.out.println("Conntected to the database server !!!");
		 return connection;
	}
	
	
	/**
  * create connection 
  * 
  * @author viettuts.vn
  * @param dbURL: database's url
  * @param userName: username is used to login
  * @param password: password is used to login
  * @return connection
  */
 public static Connection getConnection(String dbURL, String userName, 
         String password) {
     Connection conn = null;
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(dbURL, userName, password);
         System.out.println("connect successfully!");
     } catch (Exception ex) {
         System.out.println("connect failure!");
         ex.printStackTrace();
     }
     return conn;
 }
	
	public boolean closeConnection() {
		
		try {
			this.conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
