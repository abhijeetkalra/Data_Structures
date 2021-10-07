package com.abhi.practice.datastructures.arrays;

public class RearrangeArrayAlternately {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		mySol(arr, arr.length);
	}
	
	
	static void mySol(int[] arr, int n) {
		
		int x = 0; //min index
		int y = n-1; // max index
		
		int maxD = arr[n-1]+1; //getting value which more than all the elements
		
		for(int i =0;i<n;i++) {
			
			
			//Always access old value using modulus
			//Always access new value using divide
			//arr[i] == max * (new value at arr[i]) + old value at arr[i]
			
			if(i%2==0) {//Highest available
				arr[i] = maxD * (arr[y]%maxD) +arr[i];
				y--;
			}
			else {
				arr[i] = maxD * (arr[x]%maxD) +arr[i];
				x++;
			}
		}
		
		for(int i=0;i<n;i++) {
			arr[i] = arr[i]/maxD;
		}
		
	}
}
