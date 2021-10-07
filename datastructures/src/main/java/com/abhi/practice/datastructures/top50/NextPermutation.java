package com.abhi.practice.datastructures.top50;

public class NextPermutation {
	
	public static void main(String[] args) {
		//int[] arr = {3,2,1};
		//int[] arr = {1,2,3};
		int[] arr = {1,5,1};
		sol2(arr);
		for(int i: arr) {
			System.out.print(i+" ");
		}
	}
	
	static void sol(int[] arr) {
		
		for(int i=arr.length-1;i>0;i--) {
			if(arr.length==1) {
				break;
			}
			
			if(arr[i]>arr[i-1]) {
				int r = i;
				while(r+1<arr.length && arr[i] < arr[r+1]) {
					r++;
				}
				
				//swap
				int t = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = t;
				
				
				
				break;
			}
		}
	}
	
	
	
	static void sol2(int[] arr) {
		int i=arr.length-2;
		while(i>=0) {
			if(arr[i]<arr[i+1]) {
				int j=arr.length-1;
				while(arr[j]<=arr[i]) {
					j--;
				}
				int t = arr[j];
				arr[j] = arr[i];
				arr[i] = t;
				//reverse(arr, i+1, arr.length-1);
				break;
			}
			i--;
		}
		reverse(arr, i+1, arr.length-1);
	}
	
	static void reverse(int[] arr, int i, int j) {
		
		while(i<j) {
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
		
	}
	

}
