package test;

import java.math.BigDecimal;

import org.junit.Test;

public class Test1 {

	public static void main(String[] args) {
    /* int a = 10;
     int b = 10;
     method(a,b);
     System.out.println("a="+a);
     System.out.println("b="+a);*/
		String i = null;
		switch(i){
		case "1" : System.out.println(i);
		break;
		}
	}

	private static void method(int a, int b){
		System.out.println("a=100");
	     System.out.println("b=200");
	     System.exit(0);
	}
	
	@Test
	public void test(){
		String i = "";
		switch(i){
		case "1" : System.out.println("");
		break;
		}
	}
	
	@Test
	public void test2() {
		if (BigDecimal.ZERO.compareTo(new BigDecimal("0.02")) != 0) {
			System.out.println("1111111111");
		} else {
			System.out.println("22222");
		}
	}
}
