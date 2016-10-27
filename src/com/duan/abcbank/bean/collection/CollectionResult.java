package com.duan.abcbank.bean.collection;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ap")
public class CollectionResult {
	@XStreamAlias("RespCode")
	private String respCode;
	private String transserialflag;
	@XStreamAlias("CCTransCode")
	private String cCTransCode;
	@XStreamAlias("RespSource")
	private String respSource;
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
	@XStreamAlias("Channel")
	private Channel channel;
	@XStreamAlias("Cme")
	private Cme cme;
	@XStreamAlias("Cmp")
	private Cmp cmp;

	public class Channel {
		@XStreamAlias("AccDate")
		private String accDate;
		@XStreamAlias("JrnNo")
		private String jrnNo;
		@XStreamAlias("VchNo")
		private String vchNo;
		@XStreamAlias("RespInfo")
		private String respInfo;
		@XStreamAlias("RxtInfo")
		private String rxtInfo;
		@XStreamAlias("AbisRespCode")
		private String abisRespCode;

		public String getAccDate() {
			return accDate;
		}

		public void setAccDate(String accDate) {
			this.accDate = accDate;
		}

		public String getJrnNo() {
			return jrnNo;
		}

		public void setJrnNo(String jrnNo) {
			this.jrnNo = jrnNo;
		}

		public String getVchNo() {
			return vchNo;
		}

		public void setVchNo(String vchNo) {
			this.vchNo = vchNo;
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

		public String getAbisRespCode() {
			return abisRespCode;
		}

		public void setAbisRespCode(String abisRespCode) {
			this.abisRespCode = abisRespCode;
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

	public class Cmp {
		@XStreamAlias("BatchFileName")
		private String batchFileName;
		@XStreamAlias("RespPrvData")
		private String respPrvData;

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

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
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

}
