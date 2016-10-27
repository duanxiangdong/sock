package com.duan.abcbank.bean.collection;

import com.duan.abcbank.bean.common.CommonMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ap")
public class Collection {
	private CommonMessage commonMessage;
	private Cmp cmp;
	private Corp corp;
	private String Amt;

	public Collection() {

	}

	public Collection(CommonMessage commonMessage, Cmp cmp, Corp corp, String Amt) {
		this.commonMessage = commonMessage;
		this.cmp = cmp;
		this.corp = corp;
		this.Amt = Amt;
	}

	public CommonMessage getCommonMessage() {
		return commonMessage;
	}

	public void setCommonMessage(CommonMessage commonMessage) {
		this.commonMessage = commonMessage;
	}

	public Cmp getCmp() {
		return cmp;
	}

	public void setCmp(Cmp cmp) {
		this.cmp = cmp;
	}

	public Corp getCorp() {
		return corp;
	}

	public void setCorp(Corp corp) {
		this.corp = corp;
	}

	public String getAmt() {
		return Amt;
	}

	public void setAmt(String amt) {
		Amt = amt;
	}

}
