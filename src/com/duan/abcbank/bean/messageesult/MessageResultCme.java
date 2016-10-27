package com.duan.abcbank.bean.messageesult;

public class MessageResultCme {
	private String SerialNo;
	
	public MessageResultCme() {
		
	}
	
	public MessageResultCme(String SerialNo){
		this.SerialNo = SerialNo;
	}

	public String getSerialNo() {
		return SerialNo;
	}

	public void setSerialNo(String serialNo) {
		SerialNo = serialNo;
	}

}
