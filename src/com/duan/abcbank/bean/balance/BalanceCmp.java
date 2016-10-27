package com.duan.abcbank.bean.balance;

public class BalanceCmp {
	private String DbAccNo;
	private String DbProv;
	private String DbCur;
	
	public BalanceCmp(String DbAccNo,String DbProv,String DbCur) {
		this.DbAccNo = DbAccNo;
		this.DbProv = DbProv;
		this.DbCur = DbCur;
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

}
