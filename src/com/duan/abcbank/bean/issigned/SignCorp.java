package com.duan.abcbank.bean.issigned;

public class SignCorp {
	private String NFAccNo;
	private String NVoucherType;

	public SignCorp(String NFAccNo, String NVoucherType) {
		this.NFAccNo = NFAccNo;
		this.NVoucherType = NVoucherType;
	}

	public String getNFAccNo() {
		return NFAccNo;
	}

	public void setNFAccNo(String nFAccNo) {
		NFAccNo = nFAccNo;
	}

	public String getNVoucherType() {
		return NVoucherType;
	}

	public void setNVoucherType(String nVoucherType) {
		NVoucherType = nVoucherType;
	}

}
