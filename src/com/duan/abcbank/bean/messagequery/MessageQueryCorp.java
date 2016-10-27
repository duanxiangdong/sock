package com.duan.abcbank.bean.messagequery;

public class MessageQueryCorp {
	private String StartDate;
	private String EndDate;
	private String NVoucherType;
	
	public MessageQueryCorp() {
		
	}
	
	public MessageQueryCorp(String StartDate,String EndDate,String NVoucherType){
		this.StartDate = StartDate;
		this.EndDate = EndDate;
		this.NVoucherType = NVoucherType;
	}
	
	
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public String getNVoucherType() {
		return NVoucherType;
	}
	public void setNVoucherType(String nVoucherType) {
		NVoucherType = nVoucherType;
	}
	
	
}
