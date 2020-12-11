package io;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemInfo {

	public static void main(String[] args) throws IOException {
		Properties prop = System.getProperties();
		prop.list(new PrintStream("E://SystemInfo.txt"));
		System.out.println(prop);
	}
}
