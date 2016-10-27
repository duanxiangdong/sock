package com.duan.abcbank.bean.common;

import com.thoughtworks.xstream.annotations.XStreamAlias;
/**
 * 公共报头
 * @author duan
 *
 */
@XStreamAlias("ap")
public class CommonMessage {
	private String CCTransCode;
	private String ProductID;
	private String ChannelType;
	private String CorpNo;
	private String OpNo;
	private String AuthNo;
	private String ReqSeqNo;
	private String ReqDate;
	private String ReqTime;
	private String Sign;

	public CommonMessage() {
		
	}

	public CommonMessage(String CCTransCode, String OpNo,String AuthNo, String ReqSeqNo, String ReqDate, String ReqTime, String Sign) {
		this.CCTransCode = CCTransCode;
		this.ProductID = "ICC";
		this.ChannelType = "ERP";
		this.CorpNo = "";
		this.OpNo = OpNo;
		this.AuthNo = AuthNo;
		this.ReqSeqNo = ReqSeqNo;
		this.ReqDate = ReqDate;
		this.ReqTime = ReqTime;
		this.Sign = Sign;
	}

	public String getCCTransCode() {
		return CCTransCode;
	}

	public void setCCTransCode(String cCTransCode) {
		CCTransCode = cCTransCode;
	}

	public String getProductID() {
		return ProductID;
	}

	public void setProductID(String productID) {
		ProductID = productID;
	}

	public String getChannelType() {
		return ChannelType;
	}

	public void setChannelType(String channelType) {
		ChannelType = channelType;
	}

	public String getCorpNo() {
		return CorpNo;
	}

	public void setCorpNo(String corpNo) {
		CorpNo = corpNo;
	}

	public String getOpNo() {
		return OpNo;
	}

	public void setOpNo(String opNo) {
		OpNo = opNo;
	}

	public String getAuthNo() {
		return AuthNo;
	}

	public void setAuthNo(String authNo) {
		AuthNo = authNo;
	}

	public String getReqSeqNo() {
		return ReqSeqNo;
	}

	public void setReqSeqNo(String reqSeqNo) {
		ReqSeqNo = reqSeqNo;
	}

	public String getReqDate() {
		return ReqDate;
	}

	public void setReqDate(String reqDate) {
		ReqDate = reqDate;
	}

	public String getReqTime() {
		return ReqTime;
	}

	public void setReqTime(String reqTime) {
		ReqTime = reqTime;
	}

	public String getSign() {
		return Sign;
	}

	public void setSign(String sign) {
		Sign = sign;
	}

}
