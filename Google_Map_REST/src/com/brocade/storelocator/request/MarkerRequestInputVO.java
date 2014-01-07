package com.brocade.storelocator.request;

import java.io.Serializable;

import com.brocade.storelocator.domain.Marker;

public class MarkerRequestInputVO implements Serializable {
	
	private double center_lat;
	private double center_lng;
	private int distance;
	
	
	public double getCenter_lat() {
		return center_lat;
	}
	public void setCenter_lat(double center_lat) {
		this.center_lat = center_lat;
	}
	public double getCenter_lng() {
		return center_lng;
	}
	public void setCenter_lng(double center_lng) {
		this.center_lng = center_lng;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	

}
