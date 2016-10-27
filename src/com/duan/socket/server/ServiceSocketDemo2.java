package com.duan.socket.server;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceSocketDemo2 {
	public static void main(String[] args) {
		ServiceSocketDemo2 service = new ServiceSocketDemo2();
		service.init();
	}

	public void init() {
		try {
			ServerSocket socket = new ServerSocket(8181);
			while (true) {
				Socket client = socket.accept();
				new Thread(new HandlerThread(client)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class HandlerThread implements Runnable {
		private Socket socket;

		public HandlerThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
//				BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream()));
//				String result = bufferedReader.readLine();
				InputStream input = socket.getInputStream();   
				byte[] bytes = new byte[1024];
				int length = 0;
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				while((length = input.read(bytes)) != -1){
					out.write(bytes, 0, length);
				}
				byte[] res = out.toByteArray();
				String result = new String(res);
				System.out.println("获取客户端参数: "+result);
				PrintWriter printWriter =new PrintWriter(socket.getOutputStream());
				printWriter.print("hello Client, I am Server!");
				printWriter.flush();
				printWriter.close();
//				bufferedReader.close();
				out.close();
				input.close();
			} catch (IOException e) {
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

	}
}
