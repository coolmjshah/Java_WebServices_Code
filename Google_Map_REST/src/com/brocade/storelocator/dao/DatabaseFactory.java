package com.brocade.storelocator.dao;

public class DatabaseFactory {

	public static DatabaseAccessDAO getInstance(){
		return new DefaultVendor();
	}
	
}
