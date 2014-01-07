package com.brocade.storelocator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DefaultVendor implements DatabaseAccessDAO {

   	private Connection connect = null;
	 
	
	
	@Override
	public Connection getDBConnection() {
		// TODO Auto-generated method stub
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
			connect = DriverManager
		          .getConnection("jdbc:mysql://localhost/store_locator?"
		              + "user=root&password=welcome1");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return connect;
	}
	
	
	
	
	
	

}
