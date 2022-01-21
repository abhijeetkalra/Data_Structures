package com.abhi.practice.datastructures.interviewsExp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Oracle2 {
	
	
	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('a', 1);
		map.put('b', 2);
		map.put('c', 3);
		sol(map);
		
	}
	
	
	public static void sol(Map<Character, Integer> map) {
		
		List<Obj> lis = new ArrayList<Obj>();
		for(Entry<Character, Integer> e : map.entrySet()) {
			lis.add(new Obj(e.getKey(), e.getValue()));
			
		}
		
		Collections.sort(lis, new Comparator<Obj>() {

			@Override
			public int compare(Obj o1, Obj o2) {
				// TODO Auto-generated method stub
				return o2.num-o1.num;
			}
		});
		
		for(Obj o:lis) {
			System.out.println( o.c+"="+o.num);
		}
		
	}
	
	

}


class Obj{
	
	char c;
	int num;
	
	public Obj(char c, int num) {
		this.c = c;
		this.num = num;
	}
}
