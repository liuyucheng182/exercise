package test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static oracle.net.aso.C05.b;

public class Test {
	
	static String s="";
	public static  String  TestQR(){ //随机输入生成名
		if("".equals(s)){
		System.out.println("请你输入文件的路径：");
		Scanner br=new Scanner(System.in);
		s=br.next();
		}
		return s;
	}
	
	static String swe="";
	public static String TestQRD(){
		if("".equals(swe)){
		Scanner in=new Scanner(System.in);
		System.out.print("请您写入生成二维码的文件名的名称：");
		 swe=in.nextLine();
		}
		return swe;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(TestQRD());
		//System.out.println(TestQRD());
		
//		StringBuffer sb=new StringBuffer();
//		sb.append("1").append("\n");
//		System.out.println(sb.toString());
//		System.out.println(sb.toString());
	//	System.out.println(System.getProperty("java.io.tmpdir"));
		
		
		//System.out.println(CommonUtils.getValue("1"));
		
		/*BigDecimal b = new BigDecimal(50);
		
		BigDecimal b2 = b.subtract(new BigDecimal(10));
		System.out.println(b2);*/
		
		/*String[] array = {"0","1","2"};
		List<String> list = new ArrayList<String>(Arrays.asList(array));
		list.remove("0");*/
		System.out.println("0000000000000000000000000000000000000000".length());
		String a= "1";
		Integer b =1;
		String c = a+b;
		System.out.println(a+b);
		
	}
	
	@org.junit.Test
	public void test03() {
		int total = 0, success = 0, errRepeat = 0;
		for (int i = 0; i < 10; i++) {
			add(success, errRepeat);
		}
		
		System.out.println("success" + success);
		System.out.println("errRpeat" + errRepeat);
	}
	
	public void add(int success, int errRepeat) {
		success ++;
		errRepeat ++;
	}
	

	@org.junit.Test
	public void test033() {
		long s = 1535711143000L;
		System.out.println(new java.sql.Date(s));
		System.out.println(new java.util.Date(s));
		
	}

	@org.junit.Test
	public void test034() {
		// 手机号脱敏 178****5910
		String mob = "17801085910";
		System.out.println(mob.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));

		// 身份证号脱敏 210282********1234
		String idCard = "210282123456781234";
		String idCard1 = "21028212345678123X";
		System.out.println(idCard.replaceAll("(?<=\\w{6})\\w(?=\\w{4})", "*"));
		System.out.println(idCard1.replaceAll("(?<=\\w{6})\\w(?=\\w{4})", "*"));

		// 收款账号脱敏 123**********
		String zh = "123456@qq.com";
		System.out.println(zh.replaceAll("(?<=\\S{3})\\S", "*"));

		// 姓名脱敏 **字
		String name = "js收货人";
		System.out.println(name.replaceAll("\\S(?=\\S{1})", "*"));

		// 收货地址脱敏 **字
		String address = "广东省深圳市南山区";
		System.out.println(address.replaceAll("(?<=市)\\S*", "******"));
	}


	/**
	 * 测试HashMap对key为null时的存储
	 */
	@org.junit.Test
	public void putForNullKey(){
		Map map = new HashMap();
		map.put(null,"11");

		Map map1 = new ConcurrentHashMap();
	}


	@org.junit.Test
	public void link(){
		List linkedList = new LinkedList();
		linkedList.add(0,"A");
		linkedList.add(0,"B");
		int b = linkedList.indexOf("A");
		System.out.println(b);
	}

	@org.junit.Test
	public void set(){
		Set set = new HashSet();
		set.add("A");
		set.add("B");
		String next = set.iterator().next().toString();

		System.out.println(next);
	}
	
}
