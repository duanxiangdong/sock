package com.duan.socketnio.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.duan.abcbank.bean.collection.Cmp;
import com.duan.abcbank.bean.collection.Collection;
import com.duan.abcbank.bean.collection.CollectionResult;
import com.duan.abcbank.bean.collection.Corp;
import com.duan.abcbank.bean.common.CommonMessage;
import com.duan.abcbank.xml.utils.AbcBeanConverter;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class CollectionSocketNio {
	private static final Logger log = Logger.getLogger(CollectionSocketNio.class);
	private static final String addr = "172.16.200.124";//localhost,172.16.200.124,10.100.27.43
	private static final int port = 15999;

	public static void main(String[] args) throws UnsupportedEncodingException {
		SocketAddress remoteAddr = new InetSocketAddress(addr, port);
		String xml = composition();
		System.out.println("发送报文:" + xml);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			SocketChannel socketChannel = SocketChannel.open(remoteAddr);
			socketChannel.configureBlocking(false);
			ByteBuffer buffer = ByteBuffer.wrap(xml.getBytes("GBK"));
			socketChannel.write(buffer);
			socketChannel.socket().shutdownOutput();
			ByteBuffer readBuffer = ByteBuffer.allocateDirect(1024);
			byte[] bytes;
			int count = 0;
			while ((count = socketChannel.read(readBuffer)) >= 0) {
				readBuffer.flip();
				bytes = new byte[count];
				readBuffer.get(bytes);
				baos.write(bytes);
				readBuffer.clear();
			}
			bytes = baos.toByteArray();
			System.out.println("返回报文:" + new String(bytes, "GBK"));
			socketChannel.socket().shutdownInput();
			String responseXml = new String(bytes, "GBK");
			parseXml(responseXml);
		} catch (IOException e) {
			log.error("通讯失败___异常信息:" + e.getMessage(), e);
		} finally {
			try {
				baos.close();
			} catch (IOException e) {

			}
		}
	}

	private static String composition() throws UnsupportedEncodingException {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		HashMap<Class<?>, String> map = new HashMap<Class<?>, String>();
		map.put(Corp.class, "Corp");
		map.put(Cmp.class, "Cmp");
		map.put(CommonMessage.class, "");
		AbcBeanConverter nullConverter = new AbcBeanConverter(map);
		xstream.registerConverter(nullConverter);// 姜茔,9559980471095861111
		Corp corp = new Corp("99000000", "31200101941000261", "喻笛","0");//99000000,31200101941000261,喻笛||99010005,31171701941000113,方海龙
		Cmp cmp = new Cmp("31", "200101040010880", "6228230475942279768");//200101040010880,6228230475942279768||171701040002319,6228480010862143715
		String orderno = DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER);
		CommonMessage commonMessage = new CommonMessage("CFRB18", "", "", orderno, "", "", "");
		Collection collection = new Collection(commonMessage, cmp, corp, "0.01");
		String comMesXml = xstream.toXML(collection);
		int reqxmlLength = comMesXml.getBytes("GBK").length;
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
	
	private static void parseXml(String xml){
		xml = xml.substring(7);
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(CollectionResult.class);
		CollectionResult response = (CollectionResult) xstream.fromXML(xml);
		System.out.println("解析返回结果:" + response.getRespCode());
	}
}
