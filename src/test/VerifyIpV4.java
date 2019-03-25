package test;

public class VerifyIpV4 {

	public static boolean isIpv4(String ipv4) {
		if(ipv4==null || ipv4.length()==0){  
	        return false;//字符串为空或者空串  
	    }  
	    String[] parts=ipv4.split("\\.");//因为java doc里已经说明, split的参数是reg, 即正则表达式, 如果用"|"分割, 则需使用"\\|"  
	    if(parts.length!=4){  
	        return false;//分割开的数组根本就不是4个数字  
	    }  
	    for(int i=0;i<parts.length;i++){  
	        try{  
	        int n=Integer.parseInt(parts[i]);  
	        if(n<0 || n>255){  
	            return false;//数字不在正确范围内  
	        }  
	        }catch (NumberFormatException e) {  
	            return false;//转换数字不正确  
	        }  
	    }  
	    return true; 
	}
	
	public static void main(String[] args) {
/*		System.out.println(VerifyIpV4.isIpv4("127.0.256.1"));
		
		Object o1 = new Object();
		Object o2 = o1;
		if(o1.equals(o2)) {
			System.out.println("Equal");
		}
		
		String s1 = "hello";
		String s2 = "he" + new String("llo");
		System.out.println(s1==s2);*/
		
		try {
			//System.exit(0);
		} finally {
			System.out.println("dd");
		}
	}
}
