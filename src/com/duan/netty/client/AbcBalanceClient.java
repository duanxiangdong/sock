package com.duan.netty.client;

import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.duan.abcbank.bean.balance.AbcBalance;
import com.duan.abcbank.bean.balance.BalanceCmp;
import com.duan.abcbank.bean.common.CommonMessage;
import com.duan.abcbank.xml.utils.AbcBeanConverter;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;
import com.thoughtworks.xstream.XStream;

public class AbcBalanceClient {
	private static final Logger log = Logger.getLogger(AbcCollectionTest.class);
	private static final String addr = "localhost";
	private static final int port = 15999;			// 8181
	
	public static void main(String[] args) {
		AbcClient abcClient = new AbcClient();
		String xml = composition();
		log.info("发送余额交易报文=======================\r\n"+xml);
		BaseClientHandler abcClientHandler = new BaseClientHandler(xml);
		try {
			abcClient.connect(addr, port, abcClientHandler);
		} catch (Exception e) {
			if(e instanceof ConnectException){
				System.out.println("连接异常");
			}
			log.error("通讯失败", e);
		}		
	}
	
	private static String composition() {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		HashMap<Class<?>, String> map = new HashMap<Class<?>, String>();
		map.put(BalanceCmp.class, "Cmp");
		map.put(CommonMessage.class, "");
		AbcBeanConverter nullConverter = new AbcBeanConverter(map);
		xstream.registerConverter(nullConverter);
		BalanceCmp cmp = new BalanceCmp("200101040010880","31","01");
		String orderno = DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER);//+"0000000000000001";
		CommonMessage commonMessage = new CommonMessage("CQRA06", "", "", orderno, "", "", "");
		AbcBalance AbcBalance = new AbcBalance(commonMessage,"CQRA06",cmp);
		String comMesXml = xstream.toXML(AbcBalance);
		int reqxmlLength = comMesXml.getBytes().length;
		String xmlLength = checkLength(String.valueOf(reqxmlLength));
		String msg = "1" + xmlLength + comMesXml;
		return msg;
	}

	private static String checkLength(String byteLength) {
		int StringLength = byteLength.length();
		int nedbb = 6 - StringLength;
		for (int i = 0; i < nedbb; i++) {
			byteLength += " ";
		}
		return byteLength;
	}
}
