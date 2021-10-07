package com.abhi.practice.datastructures.arrays;

public class ElementLeftSmallRightBig {
	
	
	public static void main(String[] args) {
		int arr[] = {4,2,5,7};
		sol(arr,arr.length);
	}
	
	public static int sol(int arr[], int n) {
		int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        
        int lMax = arr[0];
        int rMin = arr[n-1];
        for(int i=0;i<n;i++){
            lMax = Math.max(lMax, arr[i]);
            rMin = Math.min(rMin, arr[n-i-1]);
            leftMax[i] = lMax;
            rightMin[n-i-1] = rMin;
        }
        
        for(int i =1;i<n-1;i++) {
        	if(arr[i]>=leftMax[i] && arr[i]<=rightMin[i]) {
        		return arr[i];
        	}
        }
		return -1;
	}

}
