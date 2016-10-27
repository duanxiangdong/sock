package com.duan.socket.client;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientSocketDemo2 {
	private static final String addr = "localhost";
	private static final int port = 8181;

	public static void main(String[] args) {
		String testXml = "<ap><com>ere</com></ap>";
		int xmlLength = testXml.getBytes().length;

		int isPwd = 1;
//		check("111111111111");
		sengMsg("你好");
	}

	@SuppressWarnings("unused")
	private static void sengMsg(String str) {
		Socket socket = new Socket();
		SocketAddress remoteAddr = new InetSocketAddress(addr, port);
		try {
			socket.connect(remoteAddr, 10000);
			// Writer writer = new OutputStreamWriter(socket.getOutputStream());
			// writer.write(str);
			// writer.flush();
//			OutputStream output = socket.getOutputStream();
//			output.write(str.getBytes());
//			output.flush();
			PrintWriter printWriter =new PrintWriter(socket.getOutputStream(),true);
			printWriter.println(str);
			printWriter.flush();
			socket.shutdownOutput();
			InputStream input = socket.getInputStream();
			// BufferedReader reader = new BufferedReader(new
			// InputStreamReader(input));
			// String resStr = reader.readLine();
			// System.out.println(resStr);
//			byte[] bytes = new byte[10];
//			int length = 0;
//			ByteArrayOutputStream out = new ByteArrayOutputStream();
//			while ((length = input.read(bytes)) != -1) {
//				out.write(bytes, 0, length);
//			}
//			byte[] res = out.toByteArray();
//			String result = new String(res);
//			System.out.println("=========" + result);
//			out.close();
			printWriter.close();
			input.close();
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

	private static void check(String byteLength) {
		int StringLength = byteLength.length();
		int nedbb = 6 - StringLength;
		for (int i = 0; i < nedbb; i++) {
			byteLength +=" ";
		}
		System.out.println(byteLength);
	}
}
