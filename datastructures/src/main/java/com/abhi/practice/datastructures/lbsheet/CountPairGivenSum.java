package com.abhi.practice.datastructures.lbsheet;

import java.util.HashMap;
import java.util.Map;

public class CountPairGivenSum {

		public static void main(String[] args) {
			//int[] arr = {1,5,7,1};
			//int k = 6;
			int[] arr = {1,1,1,1};
			int k = 2;
			
			System.out.println(sol(arr,arr.length,k));
		}
	
	
	
	static int sol(int[] arr, int n, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			map.put(arr[i], map.get(arr[i])==null? 1 : map.get(arr[i])+1 );
		}
		
		int res =0;
		for(int i=0;i<n;i++) {
			if(arr[i] == k-arr[i]) {
				res+=(map.get(arr[i])-1);
			} else {
				if(map.containsKey(k-arr[i])) {
					res+=map.get(k-arr[i]);
				}
			}
		}
		return res/2;
	}
}
