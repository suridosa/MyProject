package com.suridosa.callpopup.domain;

public class Meta {

	private String total_count;

	public String getTotal_count() {
		return total_count;
	}

	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Meta [total_count=");
		builder.append(total_count);
		builder.append("]");
		return builder.toString();
	}
	
	
}
