package io;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.Test;

public class FileWriterDemo {

	public static void main(String[] args) throws IOException {		
		FileWriter fw = new FileWriter("E://demo.txt", true);//文件续写
		fw.write("sfsdfasdfasdf\r\nasdfjaskdjl");//只能写英文
		fw.close();
	}
	
	@Test
	public void write2() throws IOException{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E://demo.txt", true),"GBK");//更改编码方式，可以写入中文
		osw.write("asdfas阿斯顿发送到");
		osw.close();
	}
}
