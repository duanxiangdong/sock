package com.duan.abcbank.bean.messagesigned;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ap")
public class MessageSignedResult {
	private String transserialflag;
	@XStreamAlias("CCTransCode")
	private String cCTransCode;
	@XStreamAlias("RespSource")
	private String respSource;
	@XStreamAlias("RespCode")
	private String respCode;
	@XStreamAlias("RespInfo")
	private String respInfo;
	@XStreamAlias("RxtInfo")
	private String rxtInfo;
	@XStreamAlias("RespDate")
	private String respDate;
	@XStreamAlias("RespTime")
	private String respTime;
	@XStreamAlias("FileFlag")
	private String fileFlag;
	@XStreamAlias("RespSeqNo")
	private String respSeqNo;
	@XStreamAlias("Cmp")
	private Cmp cmp;
	@XStreamAlias("Cme")
	private Cme cme;

	public class Cmp {
		@XStreamAlias("CmeSeqNo")
		private String cmeSeqNo;
		@XStreamAlias("BatchFileName")
		private String batchFileName;
		@XStreamAlias("RespPrvData")
		private String respPrvData;

		public String getCmeSeqNo() {
			return cmeSeqNo;
		}

		public void setCmeSeqNo(String cmeSeqNo) {
			this.cmeSeqNo = cmeSeqNo;
		}

		public String getBatchFileName() {
			return batchFileName;
		}

		public void setBatchFileName(String batchFileName) {
			this.batchFileName = batchFileName;
		}

		public String getRespPrvData() {
			return respPrvData;
		}

		public void setRespPrvData(String respPrvData) {
			this.respPrvData = respPrvData;
		}

	}

	public class Cme {
		@XStreamAlias("RecordNum")
		private String recordNum;
		@XStreamAlias("FieldNum")
		private String fieldNum;

		public String getRecordNum() {
			return recordNum;
		}

		public void setRecordNum(String recordNum) {
			this.recordNum = recordNum;
		}

		public String getFieldNum() {
			return fieldNum;
		}

		public void setFieldNum(String fieldNum) {
			this.fieldNum = fieldNum;
		}

	}

	public String getTransserialflag() {
		return transserialflag;
	}

	public void setTransserialflag(String transserialflag) {
		this.transserialflag = transserialflag;
	}

	public String getcCTransCode() {
		return cCTransCode;
	}

	public void setcCTransCode(String cCTransCode) {
		this.cCTransCode = cCTransCode;
	}

	public String getRespSource() {
		return respSource;
	}

	public void setRespSource(String respSource) {
		this.respSource = respSource;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespInfo() {
		return respInfo;
	}

	public void setRespInfo(String respInfo) {
		this.respInfo = respInfo;
	}

	public String getRxtInfo() {
		return rxtInfo;
	}

	public void setRxtInfo(String rxtInfo) {
		this.rxtInfo = rxtInfo;
	}

	public String getRespDate() {
		return respDate;
	}

	public void setRespDate(String respDate) {
		this.respDate = respDate;
	}

	public String getRespTime() {
		return respTime;
	}

	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}

	public String getFileFlag() {
		return fileFlag;
	}

	public void setFileFlag(String fileFlag) {
		this.fileFlag = fileFlag;
	}

	public String getRespSeqNo() {
		return respSeqNo;
	}

	public void setRespSeqNo(String respSeqNo) {
		this.respSeqNo = respSeqNo;
	}

	public Cmp getCmp() {
		return cmp;
	}

	public void setCmp(Cmp cmp) {
		this.cmp = cmp;
	}

	public Cme getCme() {
		return cme;
	}

	public void setCme(Cme cme) {
		this.cme = cme;
	}
	
}