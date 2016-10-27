package com.duan.netty.client;

import java.net.ConnectException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.duan.abcbank.bean.collection.Cmp;
import com.duan.abcbank.bean.collection.Collection;
import com.duan.abcbank.bean.collection.Corp;
import com.duan.abcbank.bean.common.CommonMessage;
import com.duan.abcbank.xml.utils.AbcBeanConverter;

import com.thoughtworks.xstream.XStream;

public class AbcCollectionTest {
	private static final Logger log = Logger.getLogger(AbcCollectionTest.class);
	private static final String addr = "localhost";
	private static final int port = 15999;			// 8181

	public static void main(String[] args) {
		AbcClient abcClient = new AbcClient();
		String xml = composition();
		System.out.println("发送代扣交易报文=======================\r\n"+xml);
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
		map.put(Corp.class, "Corp");
		map.put(Cmp.class, "Cmp");
		map.put(CommonMessage.class, "");
		AbcBeanConverter nullConverter = new AbcBeanConverter(map);
		xstream.registerConverter(nullConverter);
		Corp corp = new Corp("11", "121","","");
		Cmp cmp = new Cmp("11", "", "31200101040010880");
		CommonMessage commonMessage = new CommonMessage("CFRB18", "", "", "", "", "", "");
		Collection Collection = new Collection(commonMessage, cmp, corp, "");
		String comMesXml = xstream.toXML(Collection);
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
