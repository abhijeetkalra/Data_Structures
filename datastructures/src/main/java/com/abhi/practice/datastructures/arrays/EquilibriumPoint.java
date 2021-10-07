package com.abhi.practice.datastructures.arrays;

public class EquilibriumPoint {
	
	
	public static void main(String[] args) {
		long[] arr = {1,3,5,2,2};
		equilibriumPoint(arr, arr.length);
	}
	
	public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        long sum = 0;
        for(int i =0;i<n;i++){
            sum+=arr[i];
        }
        
        int i =0;
        long sumL=0;
        while(i<n){
            sum-=arr[i];
            if(sumL==sum) return i+1;
            sumL+=arr[i];
            
            i++;
        }
        
        return -1;
    }

}
