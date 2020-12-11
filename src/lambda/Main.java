package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
/*
 * ������������У�����ʹ�ö���(Predicate)����ʽ�ӿڴ���һ�����ԣ�
 * ����ӡ����ͨ�����Ե�Ԫ�أ���������Ϳ���ʹ�� Lambda ���ʽ�涨һЩ�߼������Դ�Ϊ����������Ϊ��
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
