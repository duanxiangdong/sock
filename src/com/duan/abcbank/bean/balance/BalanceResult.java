package com.duan.abcbank.bean.balance;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ap")
public class BalanceResult {
	@XStreamAlias("RespCode")
	private String respCode;
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
	private String channel;
	@XStreamAlias("Acc")
	private Acc acc;
	@XStreamAlias("Cmp")
	private String cmp;
	@XStreamAlias("Corp")
	private Corp corp;
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

	public class Acc {
		@XStreamAlias("FrzAmt")
		private String frzAmt;
		@XStreamAlias("Bal")
		private String bal;
		@XStreamAlias("AvailBal")
		private String availBal;
		@XStreamAlias("LastBal")
		private String lastBal;
		@XStreamAlias("ValDayLmt")
		private String valDayLmt;
		@XStreamAlias("ValMonthLmt")
		private String valMonthLmt;
		@XStreamAlias("ValUDLmt")
		private String valUDLmt;
		@XStreamAlias("LastAvailBal")
		private String lastAvailBal;
		@XStreamAlias("AccSts")
		private String accSts;
		@XStreamAlias("AccType")
		private String accType;
		@XStreamAlias("FrzBal")
		private String frzBal;

		public String getFrzAmt() {
			return frzAmt;
		}

		public void setFrzAmt(String frzAmt) {
			this.frzAmt = frzAmt;
		}

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

		public String getLastBal() {
			return lastBal;
		}

		public void setLastBal(String lastBal) {
			this.lastBal = lastBal;
		}

		public String getValDayLmt() {
			return valDayLmt;
		}

		public void setValDayLmt(String valDayLmt) {
			this.valDayLmt = valDayLmt;
		}

		public String getValMonthLmt() {
			return valMonthLmt;
		}

		public void setValMonthLmt(String valMonthLmt) {
			this.valMonthLmt = valMonthLmt;
		}

		public String getValUDLmt() {
			return valUDLmt;
		}

		public void setValUDLmt(String valUDLmt) {
			this.valUDLmt = valUDLmt;
		}

		public String getLastAvailBal() {
			return lastAvailBal;
		}

		public void setLastAvailBal(String lastAvailBal) {
			this.lastAvailBal = lastAvailBal;
		}

		public String getAccSts() {
			return accSts;
		}

		public void setAccSts(String accSts) {
			this.accSts = accSts;
		}

		public String getAccType() {
			return accType;
		}

		public void setAccType(String accType) {
			this.accType = accType;
		}

		public String getFrzBal() {
			return frzBal;
		}

		public void setFrzBal(String frzBal) {
			this.frzBal = frzBal;
		}

	}

	public class Cmp {
		@XStreamAlias("DbProv")
		private String dbProv;
		@XStreamAlias("DbAccNo")
		private String dbAccNo;
		@XStreamAlias("DbCur")
		private String dbCur;
		@XStreamAlias("RespPrvData1")
		private String respPrvData1;
		@XStreamAlias("BatchFileName")
		private String batchFileName;
		@XStreamAlias("RespPrvData")
		private String respPrvData;

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

		public String getRespPrvData1() {
			return respPrvData1;
		}

		public void setRespPrvData1(String respPrvData1) {
			this.respPrvData1 = respPrvData1;
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

	public class Corp {
		@XStreamAlias("DbAccName")
		private String dbAccName;
		@XStreamAlias("UseState")
		private String useState;

		public String getDbAccName() {
			return dbAccName;
		}

		public void setDbAccName(String dbAccName) {
			this.dbAccName = dbAccName;
		}

		public String getUseState() {
			return useState;
		}

		public void setUseState(String useState) {
			this.useState = useState;
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

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
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

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Acc getAcc() {
		return acc;
	}

	public void setAcc(Acc acc) {
		this.acc = acc;
	}

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public Corp getCorp() {
		return corp;
	}

	public void setCorp(Corp corp) {
		this.corp = corp;
	}

	public Cme getCme() {
		return cme;
	}

	public void setCme(Cme cme) {
		this.cme = cme;
	}
	
}