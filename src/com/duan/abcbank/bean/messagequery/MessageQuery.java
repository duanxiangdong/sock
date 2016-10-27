package com.duan.abcbank.bean.messagequery;

import com.duan.abcbank.bean.common.CommonMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("ap")
public class MessageQuery {
	private CommonMessage commonMessage;
	private MessageQueryCmp cmp;
	private MessageQueryCorp corp;

	public MessageQuery() {

	}

	public MessageQuery(CommonMessage commonMessage, MessageQueryCmp cmp, MessageQueryCorp corp) {
		this.commonMessage = commonMessage;
		this.cmp = cmp;
		this.corp = corp;
	}

	public MessageQueryCmp getCmp() {
		return cmp;
	}

	public void setCmp(MessageQueryCmp cmp) {
		this.cmp = cmp;
	}

	public MessageQueryCorp getCorp() {
		return corp;
	}

	public void setCorp(MessageQueryCorp corp) {
		this.corp = corp;
	}

	public CommonMessage getCommonMessage() {
		return commonMessage;
	}

	public void setCommonMessage(CommonMessage commonMessage) {
		this.commonMessage = commonMessage;
	}
	
}