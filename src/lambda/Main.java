package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
/*
 * 在下面的例子中，我们使用断言(Predicate)函数式接口创建一个测试，
 * 并打印所有通过测试的元素，这样，你就可以使用 Lambda 表达式规定一些逻辑，并以此为基础有所作为：
 */
public class Main {
	
	public static void evaluate(List<Integer> list,Predicate<Integer> predicate){
		for(Integer n:list){
			if(predicate.test(n)){
				System.out.print(n+" ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8);
System.out.println("print all numbers:");
 evaluate(list, (n)->true);
 System.out.println("print no numbers:");
 evaluate(list, (n)->false);
 System.out.println("print even numbers:");
 evaluate(list, (n)->n%2==0);
 System.out.println("print odd numbers:");
 evaluate(list, (n)->n%2!=0);
 System.out.println("print numbers greater than 5:");
 evaluate(list, (n)->n>5);
	}

}
