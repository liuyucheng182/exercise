package test;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		list2.add("33");
		List<String> list3 = new ArrayList<String>();
		list3.add("33");
		list1.addAll(list2);
		list1.addAll(list3);
		System.out.println(list1.size());
	}

}
