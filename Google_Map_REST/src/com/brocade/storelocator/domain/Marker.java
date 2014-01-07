package com.brocade.storelocator.domain;

import java.io.Serializable;

public class Marker implements Serializable {
	

private String name;
private String address;
private double lat;
private double lng;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public double getLat() {
	return lat;
}
public void setLat(double lat) {
	this.lat = lat;
}
public double getLng() {
	return lng;
}
public void setLng(double lng) {
	this.lng = lng;
}


@Override
public String toString() {
	return "Marker [name=" + name + ", address=" + address + ", lat=" + lat
			+ ", lng=" + lng + "]";
}

/*
 * Read article and recode
 * 
 * 
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Float.floatToIntBits(lat);
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Marker other = (Marker) obj;
	if (Float.floatToIntBits(lat) != Float.floatToIntBits(other.lat))
		return false;
	return true;
} */




	

}
