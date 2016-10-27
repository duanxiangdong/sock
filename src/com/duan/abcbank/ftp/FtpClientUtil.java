package com.duan.abcbank.ftp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FtpClientUtil {
	private static final Logger logger = LoggerFactory.getLogger(FtpClientUtil.class);

	public static boolean uploadFile(String url, Integer port, String username, String password, String path,String filename, byte[] bytes) {
		boolean returnValue = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port); // 连接FTP服务器
			returnValue = ftp.login(username, password); // 登录
			if (!returnValue) {
				return returnValue;
			}
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return returnValue;
			}
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.setBufferSize(1024 * 1024);
			ftp.changeWorkingDirectory(path);
			BufferedInputStream input = new BufferedInputStream(new ByteArrayInputStream(bytes));
			returnValue = ftp.storeFile(filename, input);
			if (!returnValue) {
				return returnValue;
			}
			input.close();
			ftp.logout();
		} catch (IOException e) {
			logger.info("FTPUPLOADUTIL UPLOD FILE ERROR :" + e);
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return returnValue;
	}

	public static String readFile(String url, Integer port, String username, String password, String path,String fileName) {
		boolean returnValue = false;
		StringBuilder sb = new StringBuilder(); 
		InputStream in = null;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(url, port); // 连接FTP服务器
			returnValue = ftp.login(username, password); // 登录
			if (!returnValue) {
				return "";
			}
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return "";
			}
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.setBufferSize(1024 * 1024);
			ftp.changeWorkingDirectory(path);
			in = ftp.retrieveFileStream(fileName);
			if (in != null) {
				BufferedReader br = new BufferedReader(new InputStreamReader(in,"GBK"));
				String data = null;
				while ((data = br.readLine()) != null) {
					sb.append(data+"\r\n");
				}
			}
		} catch (Exception e) {
			logger.error("FTPUPLOADUTIL UPLOD FILE ERROR :" + e);
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return sb.toString();
	}
}