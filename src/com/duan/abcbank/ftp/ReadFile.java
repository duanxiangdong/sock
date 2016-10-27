package com.duan.abcbank.ftp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {
	public static void main(String[] args) throws IOException {
		String str;
			//str = FtpClientUtil.readFile("172.16.200.124", 2121, "ftp01", "VagmmH3#6qM6","C:\\Program Files (x86)\\abcBank\\abcBankPlatform\\detail","7505.31999953100000536.301837288208103-D-03");		
		str = readFileByIoBufferedReader("C:\\Users\\Administrator\\Desktop\\7505.31999953100000536.011627029532651-D-02");
		System.out.println("文件内容:" + str);			
		String[] strs = str.split("\r\n");
		System.out.println(strs);	
	}

	@SuppressWarnings("all")
	public static String readFileByIoBufferedReader(String filePath) throws IOException {
		File file = new File(filePath);
		FileInputStream fis = null;
		BufferedReader reader = null;
		String line = null;
		StringBuffer sb = new StringBuffer();
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\r\n");
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			return e.getMessage();
		} catch (IOException e) {
			return e.getMessage();
		}finally{
			if(fis != null){
				fis.close();
			}if(reader != null){
				reader.close();
			}
		}
	}
}