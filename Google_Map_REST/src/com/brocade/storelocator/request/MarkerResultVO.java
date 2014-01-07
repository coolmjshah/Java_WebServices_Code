package com.brocade.storelocator.request;

import com.brocade.storelocator.domain.Marker;

public class MarkerResultVO {
	
	Marker marker;
	private double dist;
	
	
	public Marker getMarker() {
		return marker;
	}
	public void setMarker(Marker marker) {
		this.marker = marker;
	}
	public double getDist() {
		return dist;
	}
	public void setDist(double dist) {
		this.dist = dist;
	}

}
