package com.suridosa.callpopup.domain;

public class Address {
	
	//address
	String address_name;
	String region_1depth_name;
	String region_2depth_name;
	String region_3depth_name;
	String main_address_no;
	String sub_address_no;
	String zip_code;
	
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public String getRegion_1depth_name() {
		return region_1depth_name;
	}
	public void setRegion_1depth_name(String region_1depth_name) {
		this.region_1depth_name = region_1depth_name;
	}
	public String getRegion_2depth_name() {
		return region_2depth_name;
	}
	public void setRegion_2depth_name(String region_2depth_name) {
		this.region_2depth_name = region_2depth_name;
	}
	public String getRegion_3depth_name() {
		return region_3depth_name;
	}
	public void setRegion_3depth_name(String region_3depth_name) {
		this.region_3depth_name = region_3depth_name;
	}
	public String getMain_address_no() {
		return main_address_no;
	}
	public void setMain_address_no(String main_address_no) {
		this.main_address_no = main_address_no;
	}
	public String getSub_address_no() {
		return sub_address_no;
	}
	public void setSub_address_no(String sub_address_no) {
		this.sub_address_no = sub_address_no;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [address_name=");
		builder.append(address_name);
		builder.append(", region_1depth_name=");
		builder.append(region_1depth_name);
		builder.append(", region_2depth_name=");
		builder.append(region_2depth_name);
		builder.append(", region_3depth_name=");
		builder.append(region_3depth_name);
		builder.append(", main_address_no=");
		builder.append(main_address_no);
		builder.append(", sub_address_no=");
		builder.append(sub_address_no);
		builder.append(", zip_code=");
		builder.append(zip_code);
		builder.append("]");
		return builder.toString();
	}
	
}