package com.abhi.practice.datastructures.arrays;

public class ZigZagArray {
	
	
	public static void sol(int arr[], int n) {
		
		boolean flag = true;
		
		for(int i =0;i<n-1;i++) {
			
			if(flag) {  /// < 
				if(arr[i]>arr[i+1]) {
					int t = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = t;
				}
			} else {  /// >
				if(arr[i]<arr[i+1]) {
					int t = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = t;
				}
			}
			
			flag = !flag;
			
		}
	}

}
