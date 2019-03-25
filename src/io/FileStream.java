package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

public class FileStream {

	@Test
	public void writeFile(){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("E://fos.txt");
			fos.write("nihao你好".getBytes("GBK"));
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void readFile1(){
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("E://fos.txt");
			int ch = 0;
			while((ch=fis.read())!=-1){
				System.out.println((char)ch);
			}
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void readFile2(){
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("E://fos.txt");
			byte[] buf = new byte[1024];
			int len = 0;
			while((len=fis.read(buf))!=-1){
				System.out.println(new String(buf,0,len,"GBK"));
			}
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void readFile3(){
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("E://fos.txt");
			int num = fis.available();
			byte[] buf = new byte[num];
			fis.read(buf);
			System.out.println(new String(buf,"GBK"));

			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
