package com.abhi.practice.datastructures.commons;

import java.util.Arrays;

public class AmazonAdi1 {
	
	public static void main(String[] args) {
		int[] weights = {3,2,3};
		System.out.println(sol(weights));
	}
	
	public static int sol(int[] weight) {
		int res = 0;
		
		Arrays.sort(weight);
		
		for(int i =0; i<weight.length;i++) {
			int diff = weight[i]*(weight.length-1-i);
			int add = weight[i]*i;
			res+=add-diff;
		}
		
		return res;
		
	}

}
