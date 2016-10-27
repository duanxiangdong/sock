package com.duan.abcbank.bean.balance;

import com.duan.abcbank.bean.common.CommonMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ap")
public class AbcBalance {
	private CommonMessage commonMessage;
	private String CCTransCode;
	private BalanceCmp cmp;

	public AbcBalance(CommonMessage commonMessage, String CCTransCode, BalanceCmp cmp) {
		this.commonMessage = commonMessage;
		this.CCTransCode = CCTransCode;
		this.cmp = cmp;
	}

	public CommonMessage getCommonMessage() {
		return commonMessage;
	}

	public void setCommonMessage(CommonMessage commonMessage) {
		this.commonMessage = commonMessage;
	}

	public String getCCTransCode() {
		return CCTransCode;
	}

	public void setCCTransCode(String cCTransCode) {
		CCTransCode = cCTransCode;
	}

	public BalanceCmp getCmp() {
		return cmp;
	}

	public void setCmp(BalanceCmp cmp) {
		this.cmp = cmp;
	}

}
