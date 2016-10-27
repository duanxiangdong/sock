package com.duan.abcbank.bean.exchange;

public class ExchangePubCorp {
	private String PsFlag;
	private String BookingFlag;
	private String BookingDate;
	private String BookingTime;
	private String UrgencyFlag;
	private String OthBankFlag;
	private String CrBankType;
	private String CrAccName;
	private String CrBankName;
	private String CrBankNo;
	private String DbAccName;
	private String WhyUse;
	private String Postscript;
	
	public ExchangePubCorp() {
		
	}
	
	public ExchangePubCorp(String urgencyFlag,String othBankFlag,String crAccName,String crBankName,String dbAccName,String crBankNo){
		this.PsFlag = "";
		this.BookingFlag = "";
		this.BookingDate = "";
		this.BookingTime = "";
		this.UrgencyFlag = urgencyFlag;
		this.OthBankFlag = othBankFlag;
		this.CrBankType = "";
		this.CrAccName = crAccName;
		this.CrBankName = crBankName;
		this.CrBankNo = crBankNo;
		this.DbAccName = dbAccName;
		this.WhyUse = "";
		this.Postscript = "";
	}

	public String getPsFlag() {
		return PsFlag;
	}

	public void setPsFlag(String psFlag) {
		PsFlag = psFlag;
	}

	public String getBookingFlag() {
		return BookingFlag;
	}

	public void setBookingFlag(String bookingFlag) {
		BookingFlag = bookingFlag;
	}

	public String getBookingDate() {
		return BookingDate;
	}

	public void setBookingDate(String bookingDate) {
		BookingDate = bookingDate;
	}

	public String getBookingTime() {
		return BookingTime;
	}

	public void setBookingTime(String bookingTime) {
		BookingTime = bookingTime;
	}

	public String getUrgencyFlag() {
		return UrgencyFlag;
	}

	public void setUrgencyFlag(String urgencyFlag) {
		UrgencyFlag = urgencyFlag;
	}

	public String getOthBankFlag() {
		return OthBankFlag;
	}

	public void setOthBankFlag(String othBankFlag) {
		OthBankFlag = othBankFlag;
	}

	public String getCrBankType() {
		return CrBankType;
	}

	public void setCrBankType(String crBankType) {
		CrBankType = crBankType;
	}

	public String getCrAccName() {
		return CrAccName;
	}

	public void setCrAccName(String crAccName) {
		CrAccName = crAccName;
	}

	public String getCrBankName() {
		return CrBankName;
	}

	public void setCrBankName(String crBankName) {
		CrBankName = crBankName;
	}

	public String getCrBankNo() {
		return CrBankNo;
	}

	public void setCrBankNo(String crBankNo) {
		CrBankNo = crBankNo;
	}

	public String getDbAccName() {
		return DbAccName;
	}

	public void setDbAccName(String dbAccName) {
		DbAccName = dbAccName;
	}

	public String getWhyUse() {
		return WhyUse;
	}

	public void setWhyUse(String whyUse) {
		WhyUse = whyUse;
	}

	public String getPostscript() {
		return Postscript;
	}

	public void setPostscript(String postscript) {
		Postscript = postscript;
	}

}