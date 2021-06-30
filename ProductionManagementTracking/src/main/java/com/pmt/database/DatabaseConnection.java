package com.pmt.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.pmt.util.DatabaseCommon;




public class DatabaseConnection {
	public static String DB_IP="192.168.1.50";
	Connection conn = null;
	public DatabaseConnection()
	{
	
	}
	
	public Connection getConnection() throws SQLException { 	
//		 try {
//			 File file = new File("C:\\PMT\\ipconfig.txt"); 
//			  BufferedReader br = new BufferedReader(new FileReader(file)); 
//			  String st; 
//			  System.out.println(InetAddress.getLocalHost().getHostAddress());
//			  while ((st = br.readLine()) != null) 
//			  {
//				  DB_IP=st.trim();
//			  }
			 /*
//			  System.out.println(InetAddress.getLocalHost().getHostName());;
//			   DB_IP = InetAddress.getLocalHost().getHostAddress().trim();
//			   String DB_URL = "jdbc:sqlserver://"+DB_IP+"\\SQLEXPRESS:"+DatabaseCommon.DB_PORT+";databaseName="+DatabaseCommon.DB_NAME+"";
//	            Class.forName(DatabaseCommon.DRIVERSQLSERVER).newInstance();
//	            System.out.println(DB_URL + "  " +  DatabaseCommon.DB_USER  + "  " +  DatabaseCommon.DB_PASS );
//	            conn = DriverManager.getConnection(DB_URL, DatabaseCommon.DB_USER, DatabaseCommon.DB_PASS);
//	            if(conn!=null){
//	            	System.out.println("Ket Noi Thanh Cong!!");
//	            }
//	            else{
//	            	System.out.println("Ket Noi That Bai!!");
//	            }     
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
	        */
		 		try {
					DB_IP = InetAddress.getLocalHost().getHostAddress().trim();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    //String url = "jdbc:mysql://45.77.45.244:3306/production_tracking?serverTimezone=UTC&&useUnicode=yes&characterEncoding=UTF-8";
			    String url = "jdbc:mysql://localhost:3306/ngocminh_production_tracking?serverTimezone=UTC&&useUnicode=yes&characterEncoding=UTF-8";
				String username = "root";
				//String password = "indruino@123";
				String password = "";
				Connection connection = null;
				try
				{
				connection = getConnection(url,username,password);
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println("Conntected to failer !!!");

				}
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
