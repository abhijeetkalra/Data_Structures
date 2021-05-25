package com.abhi.practice.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;


public class Practice {
	
	static class PQS implements Comparator<Integer> {
		public int compare(Integer one, Integer two) {
			return two-one;
		}
	}

	public static void main(String[] args) {
		testToArrayMethod();
		testMap();
		
		PriorityQueue<Integer> pql = new PriorityQueue<Integer>(new PQS());
		
		List myList = new ArrayList();
		myList.add("Test");
		myList.add(12);
		myList.add(true);
		myList.add(new Integer(12));
		
	}
	
	public static void testToArrayMethod() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<5;i++) {
			list.add(i);
		}
		Object[] oa = list.toArray();
		Integer[] ia = new Integer[5];
		ia = list.toArray(ia);
		list.set(0, 6);
	}
	
	public static void testMap() {
		Map<ToDo, String> map = new HashMap<ToDo, String>();
		map.put(new ToDo("Monday"), "a");
		map.put(new ToDo("Monday"), "b");
		map.put(new ToDo("Tuesday"), "c");
		System.out.println(map.size());
		TreeSet<String> s = new TreeSet<String>();
	}
	
	
}

class ToDo{
	String day;
	ToDo(String s){
		day=s;
	}
}


