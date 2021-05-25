package com.abhi.practice.datastructures.commons;

import java.util.ArrayList;
import java.util.List;

public class NthNumDivByAorB {
	
	public static void main(String[] args) {
		int a =2 , b=3, n=250;
		System.out.println(findNthTerm(a, b, n));
		System.out.println(myWay(a, b, n));
	}

	
	static int findNthTerm(int a, int b, int n) {
		
		int low =1, high = Integer.MAX_VALUE, mid;
		int lcm = (a*b)/gcd(a,b);
		int count = 0;
		while(low<high) {
			count++;
			mid = low + (high-low)/2;
			
			if(divTermCount(a, b, lcm, mid) < n)
				low = mid +1;
			else 
				high = mid;
		}
		System.out.println("Total num of iteration in 1st : "+count);
		return low;
		
	}
	
	static int divTermCount(int a, int b, int lcm, int num) {
		int t1 = num/a;
		int t2 = num/b;
		int t3 = num/lcm;
		int res = t1+t2-t3;
		return res;
	}
	
	static int gcd(int a, int b) {
		
		if(a == 0)
			return b;
		
		return gcd(b%a,a);
	}
	
	
	static int myWay(int a, int b, int n) {
		List<Integer> list = new ArrayList<Integer>();
		int x =1, y=1,count=0;
		
		while(list.size() != n) {
			count++;
			if(x*a < y*b) {
				list.add(x*a);
				x++;
			}
			else if (x*a > y*b) {
				list.add(y*b);
				y++;
			}
			else if(x*a == y*b) {
				list.add(x*a);
				x++;
				y++;
			}
		}
		System.out.println("Total num of iteration in 2nd : "+count);
		return list.get(n-1);

	}	
}
