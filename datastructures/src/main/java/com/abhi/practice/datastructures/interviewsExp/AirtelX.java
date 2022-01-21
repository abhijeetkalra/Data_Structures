package com.abhi.practice.datastructures.interviewsExp;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class AirtelX {

	
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(5);
		s.push(2);
		//ßs.push(20);
	//s.push(8);
		s.push(-5);
		sol(s);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
		
		
	}
	
	public static Stack<Integer> sol(Stack<Integer> stk) {
		
		Stack<Integer> stk2 = new Stack<Integer>();
		
		int c = 0;
		
		int n = stk.size();
		
		while(c<stk.size()) {
			
			Integer h1 = Integer.MIN_VALUE;
			
			
			for(int i=0;i<n-c;i++) {
				Integer a  = stk.pop();
				h1 = Math.max(h1, a);
				stk2.push(a);
			}
			
			stk.push(h1);
			while(!stk2.isEmpty()) {
				Integer a = stk2.pop();
				if(!a.equals(h1)) {
					stk.push(a);
				}
			}
			c++;
			
		}
		return stk;
		
	}
	
	
	
	static Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
	
	static int size = 5;
	
	public static Integer get(Integer k) {
		
		if(map.containsKey(k)) {
			Integer v = map.get(k);
			map.remove(k);
			map.put(k, v);
		} else if(map.size()<size) {
			map.put(k, k);
		} else {
			for(Integer i: map.keySet()) {
				map.remove(i);
				break;
			}
			map.put(k, k);
		}
		
		
		return map.get(k);
	}
}

/*
 * 
 * 
 *
 map  3 4 5 6 1
 1
 2
 3
 4 
 5
 6
 */


















