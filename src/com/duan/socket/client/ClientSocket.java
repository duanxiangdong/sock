package com.duan.socket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;

public class ClientSocket {
	private static final String addr = "localhost";
	private static final int port = 8181;

	public static void main(String[] args) {
		sengMsg("234324");
	}
	
	private static void sengMsg(String str){
		Socket socket = new Socket();
		SocketAddress remoteAddr = new InetSocketAddress(addr,port);
		try {
			socket.connect(remoteAddr, 600000);			
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			output.writeUTF(str);
			output.flush();			
			DataInputStream input = new DataInputStream(socket.getInputStream());
			String resStr = input.readUTF();
			System.out.println(resStr);
			output.close();
			input.close();
		} catch (IOException e) {
			if(e instanceof ConnectException){
				System.out.println("连接超时");
			}
			if(e instanceof SocketTimeoutException){
				System.out.println("响应超时");
			}
			e.printStackTrace();
		}finally {
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			}
		}
	}
}
