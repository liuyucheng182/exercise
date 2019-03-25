package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestDate {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String rand = sdf.format(new Date());
        System.out.println(rand);
        
        
        //获取当前时间的字符串格式的四种方法
        //new Date().getTime()和System.currentTimeMillis()返回的是
        //当前时间与协调世界时 1970 年 1 月 1 日午夜之间的时间差（以毫秒为单位测量）
        System.out.println(new Long(new Date().getTime()).toString());
        System.out.println(new Long(System.currentTimeMillis()).toString());
        System.out.println(String.valueOf(new Date().getTime()));
        System.out.println(String.valueOf(System.currentTimeMillis()));
	}
	
	@Test
	public void testDateFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String rand = sdf.format(new Date());
        System.out.println(rand);
	}

}
