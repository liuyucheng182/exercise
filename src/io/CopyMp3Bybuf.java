package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyMp3Bybuf {

	public static void copy() throws IOException{
		BufferedInputStream bis = new BufferedInputStream(
				new FileInputStream(
						"D:\\我的文档\\Tencent Files\\1297987218\\FileRecv\\林忆莲 - 再见悲哀.mp3"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E://2.mp3"));
		int buf=0;
		while((buf=bis.read())!=-1){
			bos.write(buf);
		}
		bis.close();
		bos.close();
	}
	
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		copy();
		long end = System.currentTimeMillis();
		System.out.println((end-start)+"毫秒");
		
	}
}
