package com.duan.abcbank.bean.collection;

public class Corp {
	private String DbAccName;
	private String CrAccName;
	private String NVoucherType;
	private String NFAccNo;
	private String Postscript;
	private String SpAccInd;
	private String RecInd;

	public Corp() {

	}

	public Corp(String NVoucherType, String NFAccNo, String CrAccName, String SpAccInd) {
		this.DbAccName = "";
		this.CrAccName = CrAccName;
		this.NVoucherType = NVoucherType;
		this.NFAccNo = NFAccNo;
		this.Postscript = "";
		this.SpAccInd = SpAccInd;
		this.RecInd = "0";
	}

	public String getDbAccName() {
		return DbAccName;
	}

	public void setDbAccName(String dbAccName) {
		DbAccName = dbAccName;
	}

	public String getCrAccName() {
		return CrAccName;
	}

	public void setCrAccName(String crAccName) {
		CrAccName = crAccName;
	}

	public String getNVoucherType() {
		return NVoucherType;
	}

	public void setNVoucherType(String nVoucherType) {
		NVoucherType = nVoucherType;
	}

	public String getNFAccNo() {
		return NFAccNo;
	}

	public void setNFAccNo(String nFAccNo) {
		NFAccNo = nFAccNo;
	}

	public String getPostscript() {
		return Postscript;
	}

	public void setPostscript(String postscript) {
		Postscript = postscript;
	}

	public String getSpAccInd() {
		return SpAccInd;
	}

	public void setSpAccInd(String spAccInd) {
		SpAccInd = spAccInd;
	}

	public String getRecInd() {
		return RecInd;
	}

	public void setRecInd(String recInd) {
		RecInd = recInd;
	}

}
