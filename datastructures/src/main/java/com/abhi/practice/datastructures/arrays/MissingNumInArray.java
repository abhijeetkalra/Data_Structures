package com.abhi.practice.datastructures.arrays;

public class MissingNumInArray {
	
	public static void main(String[] args) {
		MissingNumInArray obj = new MissingNumInArray();
		int[] arr= {1,2,3,5};
		System.out.println(obj.mySol(arr, arr.length+1));
	}
	
	public int mySol(int[] arr, int n) {
		int sum = 0;
		for(int i:arr) {
			sum+=i;
		}
		return (n*(n+1)/2) - sum;
	}

}
