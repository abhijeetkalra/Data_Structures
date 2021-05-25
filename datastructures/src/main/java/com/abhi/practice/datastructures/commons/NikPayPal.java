package com.abhi.practice.datastructures.commons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NikPayPal {
	
	public static void main(String[] args) {
		System.out.println(solve(1, 12));
	}

	
	
	static Set<Integer> check = new HashSet<Integer>();
	
	
	public static long solve(int l, int r) {
		
		//List<Integer> check = new ArrayList<Integer>();
		/*Set<Integer> check = new HashSet<Integer>();
		check.add(2);
		check.add(3);
		check.add(4);
		check.add(5);
		check.add(6);
		check.add(8);
		check.add(9);*/
		Thread t = new Test();
		t.start();
		
		long res=0;
		List<Integer> c2 = new ArrayList<Integer>();
		for(int i=l;i<=r;i++) {
			int num =i, sum=0, rem;
			c2.clear();
			
			while(sum != 1) {
				sum= 0;
				while(num!=0) {
					rem=num%10;
					sum = sum +(rem*rem);
					num=num/10;
				}
				num =sum;
				if(check.contains(sum) || c2.contains(sum)) {
					check.addAll(c2);
					break;
				};
				c2.add(sum);
			}
			
			
			if(sum ==1) {
				res = res+i;
			}
			
		}
		return res; 
	}
	
	
}


class Test extends Thread {
	public void run() {
		int[] t = new int[] {2,3,4,5,6,8,9};
		for(int i=0;i<t.length;i++) {
			NikPayPal.check.add(t[i]);
			findNonBeatiful(t[i]);
		}
	}
	
	boolean findNonBeatiful(int num) {
		List<Integer> c2 = new ArrayList<Integer>();
		int sum =0,rem;
		while(sum != 1) {
			sum= 0;
			while(num!=0) {
				rem=num%10;
				sum = sum +(rem*rem);
				num=num/10;
			}
			num =sum;
			if(NikPayPal.check.contains(sum) || c2.contains(sum)) {
				NikPayPal.check.addAll(c2);
				break;
			};
			c2.add(sum);
		}
		return true;
	}
}

