package kr.co.trito.json;

import java.io.Serializable;

public class JsonDomain implements Serializable {

	private String id;
	private String name;
	private String number;
	private String address;
	private String recvDt;
	private String lat;
	private String lng;
	
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getRecvDt() {
		return recvDt;
	}
	public void setRecvDt(String recvDt) {
		this.recvDt = recvDt;
	}


	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JsonDomain [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", number=");
		builder.append(number);
		builder.append(", address=");
		builder.append(address);
		builder.append(", recvDt=");
		builder.append(recvDt);
		builder.append(", lat=");
		builder.append(lat);
		builder.append(", lng=");
		builder.append(lng);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
