package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class TransStreamDemo2 {

	public static void main(String[] args) throws IOException {
		//改变标准输入输出设备（输入流改变成从磁盘读取而不是键盘录入，输出流改变成在文件中输出而不是控制台输出）
		System.setIn(new FileInputStream("E://demo.txt"));
		System.setOut(new PrintStream("E://demo2.txt"));
		
		//一体化写法
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//一体化写法
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = null;
		while((line=br.readLine())!=null){
			if("over".equals(line)){
				break;
			}
			bw.write(line.toUpperCase());
			bw.newLine();
			bw.flush();
		}
		br.close();
	}
	
	 
}
