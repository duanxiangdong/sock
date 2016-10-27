package com.duan.abcbank.bean.detail;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("ap")
public class AccountDetailResult {
	@XStreamAlias("RespCode")
	private String respCode;
	@XStreamAlias("FileFlag")
	private String fileFlag;
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
	@XStreamAlias("respSeqNo")
	private String RespSeqNo;
	@XStreamAlias("Channel")
	private Channel channel;
	@XStreamAlias("Cmp")
	private Cmp cmp;
	@XStreamAlias("Corp")
	private Corp corp;
	@XStreamAlias("Cme")
	private Cme cme;
	public class Channel{
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
		@XStreamAlias("abisRespCode")
		private String AbisRespCode;
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
			return AbisRespCode;
		}
		public void setAbisRespCode(String abisRespCode) {
			AbisRespCode = abisRespCode;
		}
		
	}
	
	public class Cmp{
		@XStreamAlias("QueryCnt")
		private String queryCnt;
		@XStreamAlias("ContFlag")
		private String contFlag;
		@XStreamAlias("DbProv")
		private String dbProv;
		@XStreamAlias("BankNo")
		private String bankNo;
		@XStreamAlias("DbAccNo")
		private String dbAccNo;
		@XStreamAlias("DbCur")
		private String dbCur;
		@XStreamAlias("BatchFileName")
		private String batchFileName;
		@XStreamAlias("RespPrvData")
		private String respPrvData;
		public String getQueryCnt() {
			return queryCnt;
		}
		public void setQueryCnt(String queryCnt) {
			this.queryCnt = queryCnt;
		}
		public String getContFlag() {
			return contFlag;
		}
		public void setContFlag(String contFlag) {
			this.contFlag = contFlag;
		}
		public String getDbProv() {
			return dbProv;
		}
		public void setDbProv(String dbProv) {
			this.dbProv = dbProv;
		}
		
		public String getBankNo() {
			return bankNo;
		}
		public void setBankNo(String bankNo) {
			this.bankNo = bankNo;
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
	
	public class Corp{
		@XStreamAlias("CshDraFlag")
		private String cshDraFlag;
		@XStreamAlias("DbAccName")
		private String dbAccName;
		@XStreamAlias("DbBankName")
		private String dbBankName;
		public String getCshDraFlag() {
			return cshDraFlag;
		}
		public void setCshDraFlag(String cshDraFlag) {
			this.cshDraFlag = cshDraFlag;
		}
		public String getDbAccName() {
			return dbAccName;
		}
		public void setDbAccName(String dbAccName) {
			this.dbAccName = dbAccName;
		}
		public String getDbBankName() {
			return dbBankName;
		}
		public void setDbBankName(String dbBankName) {
			this.dbBankName = dbBankName;
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

	public String getFileFlag() {
		return fileFlag;
	}

	public void setFileFlag(String fileFlag) {
		this.fileFlag = fileFlag;
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

	public String getRespSeqNo() {
		return RespSeqNo;
	}

	public void setRespSeqNo(String respSeqNo) {
		RespSeqNo = respSeqNo;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Cmp getCmp() {
		return cmp;
	}

	public void setCmp(Cmp cmp) {
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