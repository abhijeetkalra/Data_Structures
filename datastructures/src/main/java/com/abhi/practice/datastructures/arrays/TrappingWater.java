package com.abhi.practice.datastructures.arrays;

public class TrappingWater {

	static long trappingWater(int arr[], int n) { 
        // Your code here
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        int lMax = arr[0];
        int rMax = arr[n-1];
        for(int i=0;i<n;i++){
            lMax = Math.max(lMax, arr[i]);
            rMax = Math.max(rMax, arr[n-i-1]);
            leftMax[i] = lMax;
            rightMax[n-i-1] = rMax;
        }
        
        long res = 0;
        for(int i=0;i<n;i++){
            int l = Math.min(leftMax[i],rightMax[i]);
            res+=l-arr[i];
        }
        return res;
    } 
	
}
