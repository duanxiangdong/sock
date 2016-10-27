package com.duan.abcbank.bean.detail;

import com.duan.abcbank.bean.common.CommonMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ap")
public class AccountDetail {
	private CommonMessage commonMessage;
	private String CCTransCode;
	private DetailCorp corp;
	private DetailChannel channel;
	private DetailCmp cmp;
	
	public AccountDetail() {
		
	}
	
	public AccountDetail(CommonMessage commonMessage,String CCTransCode,DetailCorp corp,DetailChannel channel,DetailCmp cmp){
		this.commonMessage = commonMessage;
		this.CCTransCode = CCTransCode;
		this.corp = corp;
		this.cmp = cmp;
		this.channel = channel;
	}

	public String getCCTransCode() {
		return CCTransCode;
	}

	public void setCCTransCode(String cCTransCode) {
		CCTransCode = cCTransCode;
	}

	public DetailCorp getCorp() {
		return corp;
	}

	public void setCorp(DetailCorp corp) {
		this.corp = corp;
	}

	public DetailChannel getChannel() {
		return channel;
	}

	public void setChannel(DetailChannel channel) {
		this.channel = channel;
	}

	public DetailCmp getCmp() {
		return cmp;
	}

	public void setCmp(DetailCmp cmp) {
		this.cmp = cmp;
	}

	public CommonMessage getCommonMessage() {
		return commonMessage;
	}

	public void setCommonMessage(CommonMessage commonMessage) {
		this.commonMessage = commonMessage;
	}
	
}
