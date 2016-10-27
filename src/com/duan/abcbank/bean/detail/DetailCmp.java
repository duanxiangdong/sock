package com.duan.abcbank.bean.detail;

public class DetailCmp {
	private String DbAccNo;
	private String DbProv;
	private String DbCur;
	private String StartTime;

	public DetailCmp() {

	}

	public DetailCmp(String DbAccNo, String DbProv, String DbCur, String StartTime) {
		this.DbAccNo = DbAccNo;
		this.DbProv = DbProv;
		this.DbCur = DbCur;
		this.StartTime = StartTime;
	}

	public String getDbAccNo() {
		return DbAccNo;
	}

	public void setDbAccNo(String dbAccNo) {
		DbAccNo = dbAccNo;
	}

	public String getDbProv() {
		return DbProv;
	}

	public void setDbProv(String dbProv) {
		DbProv = dbProv;
	}

	public String getDbCur() {
		return DbCur;
	}

	public void setDbCur(String dbCur) {
		DbCur = dbCur;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

}
