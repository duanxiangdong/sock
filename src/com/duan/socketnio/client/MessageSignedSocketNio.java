package com.duan.socketnio.client;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.duan.abcbank.bean.common.CommonMessage;
import com.duan.abcbank.bean.messagesigned.MessageCmp;
import com.duan.abcbank.bean.messagesigned.MessageCorp;
import com.duan.abcbank.bean.messagesigned.MessageSigned;
import com.duan.abcbank.bean.messagesigned.MessageSignedResult;
import com.duan.abcbank.ftp.FtpClientUtil;
import com.duan.abcbank.xml.utils.AbcBeanConverter;
import com.nxin.sysmodule.exception.ServiceException;
import com.nxin.sysmodule.util.Constants;
import com.nxin.sysmodule.util.DateUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MessageSignedSocketNio {
	private static final Logger log = Logger.getLogger(MessageSignedSocketNio.class);
	private static final String addr = "172.16.200.124";//,localhost,10.100.27.43,172.16.200.124
	private static final int port = 15999;
	private static final String Path = "D://中国农业银行银企通平台//data";

	public static void main(String[] args) {
		try {
			String fileName = getFileName();
			String filePath = Path + File.separator + fileName;
			String file = geFile();
//			writeToFile(file, filePath);
			System.out.println("生成文件名:"+fileName);
			Boolean upLoadFlag = FtpClientUtil.uploadFile("172.16.200.124", 21, "ftp01", "VagmmH3#6qM6", "C:\\Program Files (x86)\\abcBank\\abcBankPlatform\\data", fileName, file.getBytes("GBK"));
			//测试环境ftp:172.16.200.124,21,ftp01,VagmmH3#6qM6
			//本地生产环境:10.100.27.43,21,long,long.com
			String xml = composition(fileName);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String composition(String fileName) throws UnsupportedEncodingException {
		XStream xstream = new XStream();
		xstream.autodetectAnnotations(true);
		HashMap<Class<?>, String> map = new HashMap<Class<?>, String>();
		map.put(MessageCorp.class, "Corp");
		map.put(MessageCmp.class, "Cmp");
		map.put(CommonMessage.class, "");
		AbcBeanConverter nullConverter = new AbcBeanConverter(map);
		xstream.registerConverter(nullConverter);
		String orderno = DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER);
		CommonMessage commonMessage = new CommonMessage("IBBF19", "", "", orderno, "", "", "");
		MessageCorp corp = new MessageCorp("99000000", "31200101941000261");//99000000,31200101941000261,99010005,171701941000113
		MessageCmp cmp = new MessageCmp("31", "200101040010880", "1", fileName);//200101040010880,171701040002319
		MessageSigned message = new MessageSigned(commonMessage, cmp, corp, "0");
		String comMesXml = xstream.toXML(message);
		int reqxmlLength = comMesXml.getBytes("GBK").length;
		String xmlLength = checkLength(String.valueOf(reqxmlLength));
		String msg = "1" + xmlLength + comMesXml;
		return msg;
	}

	private static String geFile() {
		StringBuffer sb = new StringBuffer();
		String userAcno = "6228480478263087577";//6228480010862143715
		String cur = "01";
		String userName = "朱道平";//方海龙
		String mobile = "13717738210";//15210283563
		String pnumber = "360425196412076334";//411503198804064211
		sb.append(userAcno + "|_|").append(cur + "|_|").append(userName + "|_|").append(mobile + "|_|").append(pnumber);
		return sb.toString();
	}

	private static String checkLength(String byteLength) {
		int StringLength = byteLength.length();
		int nedbb = 6 - StringLength;
		for (int i = 0; i < nedbb; i++) {
			byteLength += " ";
		}
		return byteLength;
	}
	
	private static String getFileName(){
		return UUID.randomUUID().toString()+DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER);
	}
	
	private static void parseXml(String xml){
		xml = xml.substring(7);
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(MessageSignedResult.class);
		MessageSignedResult response = (MessageSignedResult) xstream.fromXML(xml);
		System.out.println("解析返回结果:" + response.getRespCode());
	}
	
}