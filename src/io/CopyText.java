package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyText {

	public static void main(String[] args) throws IOException {
		copy2();
	}

	public static void copy1() throws IOException{
		FileWriter fw = new FileWriter("D://demo.txt", true);
		FileReader fr = new FileReader("E://demo.txt");
	    int ch = 0;
		while((ch=fr.read())!=-1){
	    	fw.write(ch);
	    }
		fr.close();
		fw.close();
	}
	
	public static void copy2() throws IOException{
		FileWriter fw = new FileWriter("D://demo.txt", true);
		FileReader fr = new FileReader("E://demo.txt");
	    int len = 0;
	    char buf[] = new char[1024];
		while((len=fr.read(buf))!=-1){
	    	fw.write(buf,0,len);
	    }
		fr.close();
		fw.close();
	}
}
