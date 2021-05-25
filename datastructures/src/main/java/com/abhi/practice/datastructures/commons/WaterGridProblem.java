package com.abhi.practice.datastructures.commons;

public class WaterGridProblem {
	
	public static void main(String[] args) {
		int arr[] = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		int arr1[] = new int[] {2,0,2};
		int arr2[] = new int[] {3,0,2,0,4};
		
		System.out.println(findWater(arr));
		System.out.println(findWater(arr1));
		System.out.println(findWater(arr2));
	}
	
	static int findWater(int[] arr) {
		
		int n = arr.length;
		int leftHighest[] = new int[n];
		int rightHighest[] = new int[n];
		
		leftHighest[0] = arr[0];
		for(int i=1; i<n; i++) {
			leftHighest[i] = Math.max(leftHighest[i-1], arr[i]);
		}
		
		rightHighest[n-1]=arr[n-1];
		for(int i=n-2; i>=0;i--) {
			rightHighest[i]= Math.max(rightHighest[i+1], arr[i]);
		}
		
		int res = 0;
		for(int i=0;i<n;i++) {
			int t1 = Math.min(leftHighest[i], rightHighest[i])-arr[i];
			res+=t1;
		}
		
		return res;
	}

}
