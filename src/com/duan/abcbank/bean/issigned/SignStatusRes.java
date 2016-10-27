package com.duan.abcbank.bean.issigned;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ap")
public class SignStatusRes {
	@XStreamAlias("Channel")
	private SignChannelRes channel;
	@XStreamAlias("Cmp")
	private SignCmpRes cmp;
	@XStreamAlias("Cme")
	private SignCmeRes cme;
	private String RespCode;
	private String RespInfo;
	private String CCTransCode;
	private String RespSource;
	private String RxtInfo;
	private String RespDate;
	private String RespTime;
	private String FileFlag;
	private String RespSeqNo;

	public static class SignChannelRes {
		private String AccDate;
		private String JrnNo;
		private String VchNo;
		private String RespInfo;
		private String RxtInfo;
		private String AbisRespCode;

		public String getAccDate() {
			return AccDate;
		}

		public void setAccDate(String accDate) {
			AccDate = accDate;
		}

		public String getJrnNo() {
			return JrnNo;
		}

		public void setJrnNo(String jrnNo) {
			JrnNo = jrnNo;
		}

		public String getVchNo() {
			return VchNo;
		}

		public void setVchNo(String vchNo) {
			VchNo = vchNo;
		}

		public String getRespInfo() {
			return RespInfo;
		}

		public void setRespInfo(String respInfo) {
			RespInfo = respInfo;
		}

		public String getRxtInfo() {
			return RxtInfo;
		}

		public void setRxtInfo(String rxtInfo) {
			RxtInfo = rxtInfo;
		}

		public String getAbisRespCode() {
			return AbisRespCode;
		}

		public void setAbisRespCode(String abisRespCode) {
			AbisRespCode = abisRespCode;
		}

	}

	public static class SignCmpRes {
		private String ConFlag;
		private String RespCodeMean;
		private String BatchFileName;
		private String RespPrvData;

		public String getConFlag() {
			return ConFlag;
		}

		public void setConFlag(String conFlag) {
			ConFlag = conFlag;
		}

		public String getRespCodeMean() {
			return RespCodeMean;
		}

		public void setRespCodeMean(String respCodeMean) {
			RespCodeMean = respCodeMean;
		}

		public String getBatchFileName() {
			return BatchFileName;
		}

		public void setBatchFileName(String batchFileName) {
			BatchFileName = batchFileName;
		}

		public String getRespPrvData() {
			return RespPrvData;
		}

		public void setRespPrvData(String respPrvData) {
			RespPrvData = respPrvData;
		}

	}

	public static class SignCmeRes {
		private String RecordNum;
		private String FieldNum;

		public String getRecordNum() {
			return RecordNum;
		}

		public void setRecordNum(String recordNum) {
			RecordNum = recordNum;
		}

		public String getFieldNum() {
			return FieldNum;
		}

		public void setFieldNum(String fieldNum) {
			FieldNum = fieldNum;
		}

	}

	public String getRespCode() {
		return RespCode;
	}

	public void setRespCode(String respCode) {
		RespCode = respCode;
	}

	public String getRespInfo() {
		return RespInfo;
	}

	public void setRespInfo(String respInfo) {
		RespInfo = respInfo;
	}

	public SignChannelRes getChannel() {
		return channel;
	}

	public void setChannel(SignChannelRes channel) {
		this.channel = channel;
	}

	public SignCmpRes getCmp() {
		return cmp;
	}

	public void setCmp(SignCmpRes cmp) {
		this.cmp = cmp;
	}

	public String getCCTransCode() {
		return CCTransCode;
	}

	public void setCCTransCode(String cCTransCode) {
		CCTransCode = cCTransCode;
	}

	public String getRespSource() {
		return RespSource;
	}

	public void setRespSource(String respSource) {
		RespSource = respSource;
	}

	public String getRxtInfo() {
		return RxtInfo;
	}

	public void setRxtInfo(String rxtInfo) {
		RxtInfo = rxtInfo;
	}

	public String getRespDate() {
		return RespDate;
	}

	public void setRespDate(String respDate) {
		RespDate = respDate;
	}

	public String getRespTime() {
		return RespTime;
	}

	public void setRespTime(String respTime) {
		RespTime = respTime;
	}

	public String getFileFlag() {
		return FileFlag;
	}

	public void setFileFlag(String fileFlag) {
		FileFlag = fileFlag;
	}

	public String getRespSeqNo() {
		return RespSeqNo;
	}

	public void setRespSeqNo(String respSeqNo) {
		RespSeqNo = respSeqNo;
	}

}