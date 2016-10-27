package com.duan.abcbank.bean.exchange;

import com.duan.abcbank.bean.common.CommonMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ap")
public class ExchangePrivate {
	private CommonMessage commonMessage;
	private ExchangePriCmp cmp;
	private ExchangePriCorp corp;
	private String Amt;

	public ExchangePrivate(CommonMessage commonMessage, ExchangePriCmp cmp, ExchangePriCorp corp, String Amt) {
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

	public ExchangePriCmp getCmp() {
		return cmp;
	}

	public void setCmp(ExchangePriCmp cmp) {
		this.cmp = cmp;
	}

	public ExchangePriCorp getCorp() {
		return corp;
	}

	public void setCorp(ExchangePriCorp corp) {
		this.corp = corp;
	}

	public String getAmt() {
		return Amt;
	}

	public void setAmt(String amt) {
		Amt = amt;
	}

}
