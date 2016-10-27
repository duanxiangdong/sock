package com.duan.abcbank.bean.messageesult;

public class MessageResultCmp {
	private String DbProv;
	private String DbAccNo;
	private String DbCur;

	public MessageResultCmp() {

	}

	public MessageResultCmp(String DbProv, String DbAccNo) {
		this.DbProv = DbProv;
		this.DbAccNo = DbAccNo;
		this.DbCur = "01";
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

	public String getDbCur() {
		return DbCur;
	}

	public void setDbCur(String dbCur) {
		DbCur = dbCur;
	}

}
