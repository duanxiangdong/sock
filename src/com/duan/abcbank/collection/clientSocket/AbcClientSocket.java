package com.duan.abcbank.collection.clientSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;

import com.duan.abcbank.bean.collection.Cmp;
import com.duan.abcbank.bean.collection.Collection;
import com.duan.abcbank.bean.collection.Corp;
import com.duan.abcbank.bean.common.CommonMessage;
import com.duan.abcbank.xml.utils.AbcBeanConverter;
import com.thoughtworks.xstream.XStream;

public class AbcClientSocket {
	private static final String addr = "localhost";
	private static final int port = 15999;// 8181

	public static void main(String[] args) {
		String reqXml = composition();
		int reqxmlLength = reqXml.getBytes().length;
		String xmlLength = checkLength(String.valueOf(reqxmlLength));
		sendMsg("1" + xmlLength + reqXml);
	}

	private static void sendMsg(String xml) {
		System.out.println("发送数据: " + xml);
		Socket socket = new Socket();
		SocketAddress remoteAddr = new InetSocketAddress(addr, port);
		try {
			socket.connect(remoteAddr, 10000);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
			printWriter.println(xml);
			printWriter.flush();
			socket.shutdownOutput();
			 
//			byte[] bytes = new byte[10];
			int length = 0;
//			ByteArrayOutputStream out = new ByteArrayOutputStream();
//			while ((length = input.read(bytes)) != -1) {
//				out.write(bytes, 0, length);
//			}
//			byte[] res = out.toByteArray();
//			String result = new String(res);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			String result = reader.readLine();
			String readStr = null;
			StringBuffer sb = new StringBuffer();
			while((readStr =reader.readLine()) != null){
				sb.append(readStr);
			}
			String result = sb.toString();
			System.out.println("=========" + result);
//			out.close();
			printWriter.close();			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				 } catch (IOException e) {
					e.printStackTrace();
				}
			}
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
		return comMesXml;
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
