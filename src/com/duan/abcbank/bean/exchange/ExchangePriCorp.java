package com.duan.abcbank.bean.exchange;

public class ExchangePriCorp {
	private String PsFlag;
	private String BookingFlag;
	private String BookingDate;
	private String BookingTime;
	private String UrgencyFlag;
	private String OthBankFlag;
	private String CrAccName;
	private String DbAccName;
	private String WhyUse;
	private String Postscript;

	public ExchangePriCorp(String CrAccName, String WhyUse, String Postscript) {
		this.PsFlag = "";
		this.BookingDate = "";
		this.BookingFlag = "";
		this.BookingTime = "";
		this.UrgencyFlag = "";
		this.OthBankFlag = "0";//0,1
		this.CrAccName = CrAccName;
		this.DbAccName = "";
		this.WhyUse = WhyUse;
		this.Postscript = Postscript;
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

	public String getCrAccName() {
		return CrAccName;
	}

	public void setCrAccName(String crAccName) {
		CrAccName = crAccName;
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
