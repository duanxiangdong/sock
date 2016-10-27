package com.duan.abcbank.bean.exchange;

public class ExchangePubCmp {
	private String DbProv;
	private String DbAccNo;
	private String DbLogAccNo;
	private String DbCur;
	private String CrProv;
	private String CrAccNo;
	private String CrLogAccNo;
	private String CrCur;
	private String ConFlag;

	public ExchangePubCmp(String DbProv, String DbAccNo, String CrAccNo, String ConFlag) {
		this.DbProv = DbProv;
		this.DbAccNo = DbAccNo;
		this.DbLogAccNo = "";
		this.DbCur = "01";
		this.CrProv = "";
		this.CrAccNo = CrAccNo;
		this.CrLogAccNo = "";
		this.CrCur = "01";
		this.ConFlag = ConFlag;
	}

	public String getDbProv() {
		return DbProv;
	}

	public void setDbProv(String dbProv) {
		DbProv = dbProv;
	}

	public String getDbAccNo() {
		return DbAccNo;
	}

	public void setDbAccNo(String dbAccNo) {
		DbAccNo = dbAccNo;
	}

	public String getDbLogAccNo() {
		return DbLogAccNo;
	}

	public void setDbLogAccNo(String dbLogAccNo) {
		DbLogAccNo = dbLogAccNo;
	}

	public String getDbCur() {
		return DbCur;
	}

	public void setDbCur(String dbCur) {
		DbCur = dbCur;
	}

	public String getCrProv() {
		return CrProv;
	}

	public void setCrProv(String crProv) {
		CrProv = crProv;
	}

	public String getCrAccNo() {
		return CrAccNo;
	}

	public void setCrAccNo(String crAccNo) {
		CrAccNo = crAccNo;
	}

	public String getCrLogAccNo() {
		return CrLogAccNo;
	}

	public void setCrLogAccNo(String crLogAccNo) {
		CrLogAccNo = crLogAccNo;
	}

	public String getCrCur() {
		return CrCur;
	}

	public void setCrCur(String crCur) {
		CrCur = crCur;
	}

	public String getConFlag() {
		return ConFlag;
	}

	public void setConFlag(String conFlag) {
		ConFlag = conFlag;
	}

}
