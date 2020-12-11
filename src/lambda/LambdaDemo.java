package lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  /*
   * 线程可以通过以下方法初始化：
   */
		//旧方法
		new Thread(new Runnable() {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hello from thread");
	}
}).start();
  
		//新方法
  new Thread(()->System.out.println("hello form lambda")).start();
	

	/*
	 * 以下代码的作用是打印出给定数组中的所有元素。注意，使用 Lambda 表达式的方法不止一种。在下面的例子中，
	 * 我们先是用常用的箭头语法创建 Lambda 表达式，之后，使用 Java 8 全新的双冒号(::)操作符将一个常规方法转化为 Lambda 表达式：
	 */
	//旧方法
  List<Integer> list=Arrays.asList(1,2,3,4,5,6,7);
	for(Integer n:list){
		System.out.println(n);
	}
	
	//新方法
	list.forEach(n->System.out.println(n));
	
	//or we can use :: double colon operator in Java 8
	list.forEach(System.out::println);
	
	}
 
}
