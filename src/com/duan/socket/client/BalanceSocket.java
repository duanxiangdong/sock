package com.duan.socket.client;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
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

public class BalanceSocket {
	private static final Logger log = Logger.getLogger(BalanceSocket.class);
	private static final String addr = "localhost";
	private static final int port = 15999;
	private static final int headLength = 7;

	public static void main(String[] args) {
		Socket socket = new Socket();
		SocketAddress remoteAddr = new InetSocketAddress(addr, port);
		try {
			String xml = composition();
			log.info("\r\n交易发送报文\r\n" + xml);
			socket.connect(remoteAddr, 600000);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			printWriter.println(xml);
			printWriter.flush();
			InputStream inputstream = socket.getInputStream();
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			// BufferedReader reader = new BufferedReader(new
			// InputStreamReader(inputstream));
			// String resStr = reader.readLine();
			// System.out.println(resStr);
			// byte tmp[] = new byte[7];
			// int j;
			// for (int i = 0; i < 7; i += j) {
			// j = inputstream.read(tmp, i, 7 - i);
			// if (j < 0)
			// throw new Exception("invalid_packet_head");
			// }
			// System.out.println("报文头:" + new String(tmp));
			// byte checkByte[] = new byte[1];
			// System.arraycopy(tmp, 0, checkByte, 0, 1);
			// int checkFlag = Integer.parseInt(new String(checkByte));
			// System.out.println("检查标志位:" + checkFlag);
			// byte[] packetLenByte = new byte[6];
			// System.arraycopy(tmp, 1, packetLenByte, 0, 5);
			// int packetLen = Integer.parseInt(new String(packetLenByte,
			// "GBK").trim());
			// System.out.println("文件长度:" + packetLen);
			// byte[] body = new byte[1360];
			// int length;
			// for (int l = 0; l < 1360;) {
			// int i1 = inputstream.read(body, 0, 1360);
			// if (i1 >= 0) {
			// l += i1;
			// } else {
			//
			// }
			// }
			//// if((length = inputstream.read(body, 0, body.length)) != -1){
			////
			//// }
			// while((length = inputstream.read(body, 0, body.length)) != -1){
			// byteArrayOutputStream.write(body, 0, length);
			// System.out.println(new
			// String(byteArrayOutputStream.toByteArray(),"GBK"));
			// }
			//
			byte[] body = new byte[1024];
			int count;
			while((count = inputstream.read(body)) > 0){
				byteArrayOutputStream.write(body, 0, count);
			}			
			System.out.println("交易返回报文:" + new String(byteArrayOutputStream.toByteArray(), "GBK"));
			byte[] test = byteArrayOutputStream.toByteArray();
			System.out.println(test.length);
		} catch (Exception e) {
			log.error("" + e.getMessage(), e);
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
		BalanceCmp cmp = new BalanceCmp("200101040010880", "31", "01");
		String orderno = DateUtils.formatDate(new Date(), Constants.DATE_TIME_FORMAT_OTHER);// +"0000000000000001";
		CommonMessage commonMessage = new CommonMessage("CQRA06", "", "", orderno, "", "", "");
		AbcBalance AbcBalance = new AbcBalance(commonMessage, "CQRA06", cmp);
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
