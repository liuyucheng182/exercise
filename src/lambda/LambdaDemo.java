package lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  /*
   * �߳̿���ͨ�����·�����ʼ����
   */
		//�ɷ���
		new Thread(new Runnable() {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hello from thread");
	}
}).start();
  
		//�·���
  new Thread(()->System.out.println("hello form lambda")).start();
	

	/*
	 * ���´���������Ǵ�ӡ�����������е�����Ԫ�ء�ע�⣬ʹ�� Lambda ���ʽ�ķ�����ֹһ�֡�������������У�
	 * ���������ó��õļ�ͷ�﷨���� Lambda ���ʽ��֮��ʹ�� Java 8 ȫ�µ�˫ð��(::)��������һ�����淽��ת��Ϊ Lambda ���ʽ��
	 */
	//�ɷ���
  List<Integer> list=Arrays.asList(1,2,3,4,5,6,7);
	for(Integer n:list){
		System.out.println(n);
	}
	
	//�·���
	list.forEach(n->System.out.println(n));
	
	//or we can use :: double colon operator in Java 8
	list.forEach(System.out::println);
	
	}
 
}
