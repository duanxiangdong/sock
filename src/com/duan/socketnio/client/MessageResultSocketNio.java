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

import com.duan.abcbank.bean.common.CommonMessage;
import com.duan.abcbank.bean.messageesult.MessageResult;
import com.duan.abcbank.bean.messageesult.MessageResultCme;
import com.duan.abcbank.bean.messageesult.MessageResultCmp;
import com.duan.abcbank.xml.utils.AbcBeanConverter;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;
import com.thoughtworks.xstream.XStream;

public class MessageResultSocketNio {
	private static final Logger log = Logger.getLogger(MessageQuerySocketNio.class);
	private static final String addr = "172.16.200.124";//localhost
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
		map.put(MessageResultCme.class, "Cme");
		map.put(MessageResultCmp.class, "Cmp");
		map.put(CommonMessage.class, "");
		AbcBeanConverter nullConverter = new AbcBeanConverter(map);
		xstream.registerConverter(nullConverter);
		MessageResultCme cme = new MessageResultCme("010992793465");
		MessageResultCmp cmp = new MessageResultCmp("31","200101040010880");
		String orderno = DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER);
		CommonMessage commonMessage = new CommonMessage("CQRB85", "", "", orderno, "", "", "");
		MessageResult messageResult = new MessageResult(commonMessage, cmp, cme);
		String comMesXml = xstream.toXML(messageResult);
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
}
