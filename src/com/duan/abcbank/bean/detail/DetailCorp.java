package com.duan.abcbank.bean.detail;

public class DetailCorp {
	private String StartDate;
	private String EndDate;
	
	public DetailCorp() {
		
	}
	
	public DetailCorp(String StartDate,String EndDate){
		this.StartDate = StartDate;
		this.EndDate = EndDate;
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

}
