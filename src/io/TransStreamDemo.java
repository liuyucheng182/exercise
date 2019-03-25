package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class TransStreamDemo {

	public static void main(String[] args) throws IOException {
		//获取键盘录入对象
		InputStream in = System.in;
		//将字节流对象转换成字符流对象
		InputStreamReader isr = new InputStreamReader(in);
		//为提高效率，将字符串进行缓冲区技术高效操作
		BufferedReader br = new BufferedReader(isr);
		
		//一体化写法
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//获取键盘输出对象
		OutputStream out = System.out;
		//将字节流对象转换成字符流对象
		OutputStreamWriter osw = new OutputStreamWriter(out);
		//为提高效率，将字符串进行缓冲区技术高效操作
		BufferedWriter bw = new BufferedWriter(osw);
		
		//一体化写法
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = null;
		while((line=br.readLine())!=null){
			if("over".equals(line)){
				break;
			}
			//System.out.println(line.toUpperCase());
			bw.write(line.toUpperCase());
			bw.newLine();
			bw.flush();
		}
		br.close();
	}
}
