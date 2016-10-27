package com.duan.abcbank.bean.messagesigned;

public class MessageCmp {
	private String DbProv;
	private String DbAccNo;
	private String DbCur;
	private String DbLogAccNo;
	private String SumNum;
	private String BatchFileName;

	public MessageCmp(String DbProv, String DbAccNo, String SumNum, String BatchFileName) {
		this.DbProv = DbProv;
		this.DbAccNo = DbAccNo;
		this.DbCur = "01";
		this.SumNum = SumNum;
		this.BatchFileName = BatchFileName;
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

	public String getSumNum() {
		return SumNum;
	}

	public void setSumNum(String sumNum) {
		SumNum = sumNum;
	}

	public String getBatchFileName() {
		return BatchFileName;
	}

	public void setBatchFileName(String batchFileName) {
		BatchFileName = batchFileName;
	}

}
