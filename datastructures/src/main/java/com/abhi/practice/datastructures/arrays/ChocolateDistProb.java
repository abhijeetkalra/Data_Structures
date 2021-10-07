package com.abhi.practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistProb {
	
	
	public static long sol(ArrayList<Long> a, long n, long m) {
		

		Collections.sort(a);
		
		int i =0;
		long minDiff = a.get((int) (m-1))-a.get(i);
		while(m<=n) {
			minDiff = Math.min(minDiff, a.get((int) (m-1))-a.get(i));
			m++;
			i++;
		}
		
		return minDiff;
		
	}

}
