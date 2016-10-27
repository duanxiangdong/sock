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
import com.duan.abcbank.bean.exchange.ExchangePubCmp;
import com.duan.abcbank.bean.exchange.ExchangePubCorp;
import com.duan.abcbank.bean.exchange.ExchangePublic;
import com.duan.abcbank.bean.exchange.ExchangePublicResult;
import com.duan.abcbank.xml.utils.AbcBeanConverter;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ExchangePublicSocketNio {
	private static final Logger log = Logger.getLogger(ExchangePublicSocketNio.class);
	private static final String addr = "10.100.27.43";//172.16.200.124,10.100.27.43
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
					baos.close();
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
		map.put(ExchangePubCorp.class, "Corp");
		map.put(ExchangePubCmp.class, "Cmp");
		map.put(CommonMessage.class, "");
		AbcBeanConverter nullConverter = new AbcBeanConverter(map);
		xstream.registerConverter(nullConverter);
		ExchangePubCorp corp = new ExchangePubCorp("0", "1", "段向东", "光大银行", "北京农信互联科技有限公司","303100000006");//重生万惜舰望蹬笔予慊观速,
		ExchangePubCmp cmp = new ExchangePubCmp("31", "171701040002293", "6214920202993042", "0");//200101040010880,31020201040009631;
		String orderno = DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER);
		CommonMessage commonMessage = new CommonMessage("CFRT02", "", "", orderno, "", "", "");
		ExchangePublic exchange = new ExchangePublic(commonMessage, cmp, corp, "CFRT02", "0.02");
		String comMesXml = xstream.toXML(exchange);
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
		xstream.processAnnotations(ExchangePublicResult.class);
		ExchangePublicResult response = (ExchangePublicResult) xstream.fromXML(xml);
		System.out.println("解析返回结果:" + response.getRespCode());
		System.out.println("返回流水号:"+response.getChannel().getJrnNo());
	}
}
