package io;

import java.io.File;

public class DirTest {

	/**
	 * 构建目录
	 * 
	 * @param directory
	 */
	private static void createDirectory(String directory) {
		File file = new File(directory);
		if (!file.exists()) {
			if (!file.getParentFile().exists())
				file.getParentFile().mkdirs();
			file.mkdirs();
		}
	}
	
	public static void main(String[] args) {
		DirTest.createDirectory("E:/test2");
	}
}
