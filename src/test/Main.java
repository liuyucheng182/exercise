package test;

import java.util.ArrayList;
import java.util.List;

import test.Demo.Inner2;

public class Main {

	
	public void print(int num){
		for(int i=0;i<num;i++) {
			for(int j=0;j<num-i-1;j++){
			System.out.print(" ");
			}
			for (int K = 0; K <2*i+1; K++) {
			System.out.print("*");
			}
			System.out.println(); 
			}	
	}
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("1");
		
		Demo d = new Demo();
		//Inner i = d.getInner(); //私有的内部类不能访问
		Inner2 i2 = d.getInner2(); //公有的内部类可以访问
		String s2 = d.s2;//公有变量可以访问
		//String s = d.s;//私有变量可以访问
	}
	
	

}


class Demo{
	
	private String s;
	public String s2;
	
	private Inner getInner(){
		return new Inner();
	}
	
	public Inner2 getInner2(){
		return new Inner2();
	}
	
	private class Inner{
		
	}
    public class Inner2{
		
	}
    
    public static void main(String[] args) {
		//Inner i = new Inner();
    	
    	String s = "hello";
    	String s1 = "he" + new String("llo");
    	String s2 = "he" + "llo";
    	System.out.println(s==s1);
    	System.err.println(s==s2);
	}
	
}