package test;

import java.util.HashMap;
import java.util.Map;

public class CommonUtils {

	private static Map<String, String> map = new HashMap<String, String>();
	static{
		map.put("1", "AA");
		map.put("2", "BB");
		map.put("3", "CC");
		map.put("4", "DD");
		map.put("5", "EE");
	}
	
	public static String getValue(String key){
		return map.get(key);
	}
}
