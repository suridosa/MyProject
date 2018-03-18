package com.suridosa.callpopup.domain;

public class Documents {
			
	private Address address;
	private RoadAddress road_address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public RoadAddress getRoad_address() {
		return road_address;
	}
	public void setRoad_address(RoadAddress road_address) {
		this.road_address = road_address;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Documents [address=");
		builder.append(address);
		builder.append(", road_address=");
		builder.append(road_address);
		builder.append("]");
		return builder.toString();
	} 

}
