package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateToMillisecond {

	public static void main(String[] args) throws ParseException {// 日期转毫秒 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long millionSeconds = sdf.parse("2019-03-01 14:58:00").getTime();//毫秒
		System.out.println(millionSeconds);
		
		// 毫秒转日期
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(1551345300000L); 
		Date date = c.getTime();
		System.out.println(sdf.format(date));
		
}

}
