package com.duan.socket.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceSocket {
	public static void main(String[] args) {
		ServiceSocket service = new ServiceSocket();
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
				DataInputStream input = new DataInputStream(socket.getInputStream());
				String inputStr = input.readUTF();
				System.out.println("接收客户端数据: " + inputStr);
				String outputStr = "dddddd";
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				output.writeUTF(outputStr);
				output.flush();
				input.close();
				output.close();
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
