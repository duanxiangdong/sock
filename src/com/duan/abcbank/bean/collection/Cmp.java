package com.duan.abcbank.bean.collection;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Cmp")
public class Cmp {
	private String DbProv;
	private String DbAccNo;
	private String DbCur;
	private String DbLogAccNo;
	private String CrAccNo;
	private String CrProv;
	private String CrCur;

	public Cmp() {

	}

	public Cmp(String DbProv, String DbAccNo, String CrAccNo) {
		this.DbProv = DbProv;
		this.DbAccNo = DbAccNo;
		this.DbCur = "01";
		this.DbLogAccNo = "";
		this.CrAccNo = CrAccNo;
		this.CrProv = "";
		this.CrCur = "01";
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

	public String getCrAccNo() {
		return CrAccNo;
	}

	public void setCrAccNo(String crAccNo) {
		CrAccNo = crAccNo;
	}

	public String getCrProv() {
		return CrProv;
	}

	public void setCrProv(String crProv) {
		CrProv = crProv;
	}

	public String getCrCur() {
		return CrCur;
	}

	public void setCrCur(String crCur) {
		CrCur = crCur;
	}

}
