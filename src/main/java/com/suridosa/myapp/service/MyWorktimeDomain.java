package com.suridosa.myapp.service;

import java.io.Serializable;

public class MyWorktimeDomain implements Serializable {
	
	private String sawonNo;
	private String sawonNm;
	private String hpTel;
	private String startDt;
	private String endDt;
	private String acceptIp;
	private String currDate;
	private String status;
	
	
	public String getSawonNo() {
		return sawonNo;
	}
	public void setSawonNo(String sawonNo) {
		this.sawonNo = sawonNo;
	}
	public String getSawonNm() {
		return sawonNm;
	}
	public void setSawonNm(String sawonNm) {
		this.sawonNm = sawonNm;
	}
	public String getHpTel() {
		return hpTel;
	}
	public void setHpTel(String hpTel) {
		this.hpTel = hpTel;
	}
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public String getAcceptIp() {
		return acceptIp;
	}
	public void setAcceptIp(String acceptIp) {
		this.acceptIp = acceptIp;
	}
	public String getCurrDate() {
		return currDate;
	}
	public void setCurrDate(String currDate) {
		this.currDate = currDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MyWorktimeDomain [sawonNo=");
		builder.append(sawonNo);
		builder.append(", sawonNm=");
		builder.append(sawonNm);
		builder.append(", hpTel=");
		builder.append(hpTel);
		builder.append(", startDt=");
		builder.append(startDt);
		builder.append(", endDt=");
		builder.append(endDt);
		builder.append(", acceptIp=");
		builder.append(acceptIp);
		builder.append(", currDate=");
		builder.append(currDate);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
