package io;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将异常日志信息输出到日志文件中
 * @author Administrator
 *
 */
public class ExceptionInfo {

	public static void main(String[] args) throws IOException {
		try {
			int[] arr = new int[2];
			System.out.println(arr[2]);
		} catch (Exception e) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s = sdf.format(date);
			PrintStream ps = new PrintStream("E://ExceptionInfo.log");
			ps.println(s);
			e.printStackTrace(ps);
		}
	}
}
