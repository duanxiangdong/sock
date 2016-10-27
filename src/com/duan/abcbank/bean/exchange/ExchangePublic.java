package com.duan.abcbank.bean.exchange;

import com.duan.abcbank.bean.common.CommonMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ap")
public class ExchangePublic {
	private CommonMessage commonMessage;
	private ExchangePubCmp cmp;
	private ExchangePubCorp corp;
	private String CCTransCode;
	private String Amt;

	public ExchangePublic() {

	}

	public ExchangePublic(CommonMessage commonMessage, ExchangePubCmp cmp, ExchangePubCorp corp, String CCTransCode,String Amt) {
		this.commonMessage = commonMessage;
		this.cmp = cmp;
		this.corp = corp;
		this.CCTransCode = CCTransCode;
		this.Amt = Amt;
	}

	public CommonMessage getCommonMessage() {
		return commonMessage;
	}

	public void setCommonMessage(CommonMessage commonMessage) {
		this.commonMessage = commonMessage;
	}

	public ExchangePubCmp getCmp() {
		return cmp;
	}

	public void setCmp(ExchangePubCmp cmp) {
		this.cmp = cmp;
	}

	public ExchangePubCorp getCorp() {
		return corp;
	}

	public void setCorp(ExchangePubCorp corp) {
		this.corp = corp;
	}

	public String getCCTransCode() {
		return CCTransCode;
	}

	public void setCCTransCode(String cCTransCode) {
		CCTransCode = cCTransCode;
	}

	public String getAmt() {
		return Amt;
	}

	public void setAmt(String amt) {
		Amt = amt;
	}
}
