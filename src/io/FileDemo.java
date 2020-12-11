package io;

import java.io.File;

import org.junit.Test;

public class FileDemo {

	@Test
	public void deleteFile1(){
		File f = new File("E://demo2.txt");
		System.out.println(f.delete());
	}
	
	@Test
	public void deleteFile2(){
		File f2 = new File("E://fos.txt");
		f2.deleteOnExit();//当程序退出时删除文件(即使在处理文件中途发生异常，在程序结束时也会删除文件)
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
