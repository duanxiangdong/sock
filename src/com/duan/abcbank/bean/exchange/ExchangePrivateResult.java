package com.duan.abcbank.bean.exchange;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("ap")
public class ExchangePrivateResult {
	@XStreamAlias("RespCode")
	private String respCode;
	@XStreamAlias("Amt")
	private String amt;
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
	@XStreamAlias("Corp")
	private Corp corp;
	@XStreamAlias("Acc")
	private Acc acc;
	@XStreamAlias("Cmp")
	private Cmp cmp;
	@XStreamAlias("Cme")
	private Cme cme;
	
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

	public class Corp {
		@XStreamAlias("DbAccName")
		private String dbAccName;
		@XStreamAlias("WaitFlag")
		private String waitFlag;

		public String getDbAccName() {
			return dbAccName;
		}

		public void setDbAccName(String dbAccName) {
			this.dbAccName = dbAccName;
		}

		public String getWaitFlag() {
			return waitFlag;
		}

		public void setWaitFlag(String waitFlag) {
			this.waitFlag = waitFlag;
		}
	}

	public class Acc {
		@XStreamAlias("Bal")
		private String bal;
		@XStreamAlias("AvailBal")
		private String availBal;

		public String getBal() {
			return bal;
		}

		public void setBal(String bal) {
			this.bal = bal;
		}

		public String getAvailBal() {
			return availBal;
		}

		public void setAvailBal(String availBal) {
			this.availBal = availBal;
		}

	}
	
	public class Cmp{
		@XStreamAlias("DbProv")
		private String dbProv;
		@XStreamAlias("DbAccNo")
		private String dbAccNo;
		@XStreamAlias("DbCur")
		private String dbCur;
		@XStreamAlias("CrProv")
		private String crProv;
		@XStreamAlias("CrAccNo")
		private String crAccNo;
		@XStreamAlias("CrCur")
		private String crCur;
		@XStreamAlias("BatchFileName")
		private String batchFileName;
		@XStreamAlias("RespPrvData")
		private String respPrvData;
		@XStreamAlias("CmeSeqNo")
		private String cmeSeqNo;
		public String getDbProv() {
			return dbProv;
		}
		public void setDbProv(String dbProv) {
			this.dbProv = dbProv;
		}
		public String getDbAccNo() {
			return dbAccNo;
		}
		public void setDbAccNo(String dbAccNo) {
			this.dbAccNo = dbAccNo;
		}
		public String getDbCur() {
			return dbCur;
		}
		public void setDbCur(String dbCur) {
			this.dbCur = dbCur;
		}
		public String getCrProv() {
			return crProv;
		}
		public void setCrProv(String crProv) {
			this.crProv = crProv;
		}
		public String getCrAccNo() {
			return crAccNo;
		}
		public void setCrAccNo(String crAccNo) {
			this.crAccNo = crAccNo;
		}
		public String getCrCur() {
			return crCur;
		}
		public void setCrCur(String crCur) {
			this.crCur = crCur;
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
		public String getCmeSeqNo() {
			return cmeSeqNo;
		}
		public void setCmeSeqNo(String cmeSeqNo) {
			this.cmeSeqNo = cmeSeqNo;
		}
		
	}
	
	public class Cme{
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

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
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

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Corp getCorp() {
		return corp;
	}

	public void setCorp(Corp corp) {
		this.corp = corp;
	}

	public Acc getAcc() {
		return acc;
	}

	public void setAcc(Acc acc) {
		this.acc = acc;
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