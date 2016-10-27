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
import com.duan.abcbank.bean.issigned.SignCmp;
import com.duan.abcbank.bean.issigned.SignCorp;
import com.duan.abcbank.bean.issigned.SignStatus;
import com.duan.abcbank.bean.issigned.SignStatusRes;
import com.duan.abcbank.xml.utils.AbcBeanConverter;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SignStatusSocketNio {
	private static final Logger log = Logger.getLogger(SignStatusSocketNio.class);
	private static final String addr = "10.100.27.43";//localhost,10.100.27.43,172.16.200.124
	private static final int port = 15999;

	public static void main(String[] args) {
		try {
			String xml = composition();
			System.out.println("发送报文:" + xml);
			SocketAddress remoteAddr = new InetSocketAddress(addr, port);
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
					if(baos != null){
						baos.close();
					}
					
				} catch (IOException e) {

				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private static String composition() throws UnsupportedEncodingException {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		HashMap<Class<?>, String> map = new HashMap<Class<?>, String>();
		map.put(SignCorp.class, "Corp");
		map.put(SignCmp.class, "Cmp");
		map.put(CommonMessage.class, "");
		AbcBeanConverter abcConverter = new AbcBeanConverter(map);
		xstream.registerConverter(abcConverter);
		String orderno = DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER);
		CommonMessage commonMessage = new CommonMessage("CQRB80", "", "", orderno, "", "", "");
		SignCorp corp = new SignCorp("31171701941000109", "99010001");//31200101941000261,99000000
		SignCmp cmp = new SignCmp("171701040002293", "31", "6228480018753709577");
		SignStatus status = new SignStatus(commonMessage, cmp, corp, "1");
		String comMesXml = xstream.toXML(status);
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

	private static void parseXml(String xml) {
		xml = xml.substring(7);
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(SignStatusRes.class);
		SignStatusRes response = (SignStatusRes) xstream.fromXML(xml);
		System.out.println("解析返回结果:" + response.getRespCode());
	}
}