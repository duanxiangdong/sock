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

import com.duan.abcbank.bean.balance.AbcBalance;
import com.duan.abcbank.bean.balance.BalanceResult;
import com.duan.abcbank.bean.balance.BalanceCmp;
import com.duan.abcbank.bean.common.CommonMessage;
import com.duan.abcbank.xml.utils.AbcBeanConverter;
import com.duan.socket.client.BalanceSocket;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class BalanceSocketNio {
	private static final Logger log = Logger.getLogger(BalanceSocket.class);
	private static final String addr = "172.16.200.124";//10.100.27.43,localhost,172.16.200.124,10.201.20.31
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
			parseXml(new String(bytes, "GBK"));
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
		map.put(BalanceCmp.class, "Cmp");
		map.put(CommonMessage.class, "");
		AbcBeanConverter nullConverter = new AbcBeanConverter(map);
		xstream.registerConverter(nullConverter);
		BalanceCmp cmp = new BalanceCmp("200101040010880", "31", "01");//200101040010880,171701040002319
		String orderno = DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER);// +"0000000000000001";
		CommonMessage commonMessage = new CommonMessage("CQRA06", "", "", orderno, "", "", "");
		AbcBalance AbcBalance = new AbcBalance(commonMessage, "CQRA06", cmp);
		String comMesXml = xstream.toXML(AbcBalance);
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
		xstream.processAnnotations(BalanceResult.class);
		BalanceResult response = (BalanceResult) xstream.fromXML(xml);
		System.out.println("解析返回结果:" + response.getRespCode());
	}
}
