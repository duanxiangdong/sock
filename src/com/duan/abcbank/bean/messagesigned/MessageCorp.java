package com.duan.abcbank.bean.messagesigned;

public class MessageCorp {
	private String DbAccName;
	private String NVoucherType;
	private String NFAccNo;

	public MessageCorp(String NVoucherType, String NFAccNo) {
		this.NVoucherType = NVoucherType;
		this.NFAccNo = NFAccNo;
		this.DbAccName = "重庆农信生猪交易有限公司";//重全收枭胜拽关姑仔越教逸子星
	}

	public String getDbAccName() {
		return DbAccName;
	}

	public void setDbAccName(String dbAccName) {
		DbAccName = dbAccName;
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
	
}
