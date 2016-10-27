package com.duan.abcbank.bean.issigned;

import com.duan.abcbank.bean.common.CommonMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ap")
public class SignStatus {
	private CommonMessage commonMessage;
	private SignCmp cmp;
	private SignCorp corp;
	private String qryflag;

	public SignStatus(CommonMessage commonMessage, SignCmp cmp, SignCorp corp, String qryflag) {
		this.commonMessage = commonMessage;
		this.cmp = cmp;
		this.corp = corp;
		this.qryflag = qryflag;
	}

	public CommonMessage getCommonMessage() {
		return commonMessage;
	}

	public void setCommonMessage(CommonMessage commonMessage) {
		this.commonMessage = commonMessage;
	}

	public SignCmp getCmp() {
		return cmp;
	}

	public void setCmp(SignCmp cmp) {
		this.cmp = cmp;
	}

	public SignCorp getCorp() {
		return corp;
	}

	public void setCorp(SignCorp corp) {
		this.corp = corp;
	}

	public String getQryflag() {
		return qryflag;
	}

	public void setQryflag(String qryflag) {
		this.qryflag = qryflag;
	}

}
