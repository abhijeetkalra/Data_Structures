package com.abhi.practice.datastructures.gfgAmazonTag;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateBinaryNumbers {
	
	public static void main(String[] args) {
		sol(16).forEach(e->System.out.println(e));
	}
	
	
	public static List<String> sol(int N){
		List<String> res = new ArrayList<String>();
		
		Queue<String> q = new LinkedList<>();
		
		 q.add("1");
		 
		 int i = 0;
		 while(i<N)
	        {
	            //storing the front element of queue and popping it.
	            String s1 = q.poll();
	            
	            //adding the popped element in answer.
	            res.add(s1);
	            
	            //generating the next two binary numbers by adding to queue 
	            q.add(s1 + '0');
	            q.add(s1 + '1');
	            i++;
	        }
		
		
		return res;
	}

}
