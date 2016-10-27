package com.duan.abcbank.bean.messageesult;

import com.duan.abcbank.bean.common.CommonMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("ap")
public class MessageResult {
	private CommonMessage commonMessage;
	private MessageResultCmp cmp;
	private MessageResultCme cme;
	
	public MessageResult() {
		
	}
	
	public MessageResult(CommonMessage commonMessage,MessageResultCmp cmp,MessageResultCme cme){
		this.commonMessage = commonMessage;
		this.cme = cme;
		this.cmp = cmp;
	}

	public CommonMessage getCommonMessage() {
		return commonMessage;
	}

	public void setCommonMessage(CommonMessage commonMessage) {
		this.commonMessage = commonMessage;
	}

	public MessageResultCmp getCmp() {
		return cmp;
	}

	public void setCmp(MessageResultCmp cmp) {
		this.cmp = cmp;
	}

	public MessageResultCme getCme() {
		return cme;
	}

	public void setCme(MessageResultCme cme) {
		this.cme = cme;
	}

}
