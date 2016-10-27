package com.duan.abcbank.bean.messagequery;

public class MessageQueryCmp {
	private String DbProv;
	private String DbAccNo;
	private String DbCur;
	private String DbLogAccNo;
	
	public MessageQueryCmp() {
		
	}
	
	public MessageQueryCmp(String DbProv,String DbAccNo){
		this.DbProv = DbProv;
		this.DbAccNo = DbAccNo;
		this.DbCur = "01";
		this.DbLogAccNo = "";
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

	public String getDbLogAccNo() {
		return DbLogAccNo;
	}

	public void setDbLogAccNo(String dbLogAccNo) {
		DbLogAccNo = dbLogAccNo;
	}

}
