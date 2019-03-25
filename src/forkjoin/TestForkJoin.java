package forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class TestForkJoin {
	
	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		for(int i = 0 ; i <1000 ; i++){ //1000 
			User newUser = new User();
			newUser.setId(i);
			newUser.setName("兄阿明： " + i*3 +"\t\t");
			userList.add(newUser);
		}
		
		MyTask myTask = new MyTask(0,userList.size()-1,userList);
		new ForkJoinPool(16).invoke(myTask);
	}
}

class MyTask extends RecursiveTask<User>{
	private  Integer start ;
	private  Integer end ;
	private  List<User> userlist ;
	
	private Integer max_BAK = 100;
	
	public MyTask(Integer start , Integer end , List<User> userlist) {
		this.start = start;
		this.end = end;
		this.userlist = userlist;
	}

	@Override
	protected User compute() {
		if( (end - start)<max_BAK ){
			for(int i = start ; i<=end ; i++){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(userlist.get(i).getId()  + "\t\t\t |||  end : " + end );
			}
		}else {
			int midd = end+start >>1;
			MyTask leftTask = new MyTask(start, midd,userlist);
			MyTask rightTask = new MyTask(midd+1, end,userlist);
			System.out.println("拆分任务并执行  \t   拆分成： "+ start + " ~ "+ midd + " || " + (midd+1) + " ~ " + end );
			leftTask.fork();
            rightTask.fork();
        	leftTask.join();
            rightTask.join();
		}
		return null;
	}
	
}
