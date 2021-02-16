package com.abhi.practice.datastructures.arrays;

public class KadaneAlgorithm {
	
	public static void main(String[] args) {
		KadaneAlgorithm obj = new KadaneAlgorithm();
		//int[] arr = {1,2,3,-20,5};
		int[] arr = {-1,-2,-3,20,-40,10};
		System.out.println(obj.mySol(arr, arr.length));
		System.out.println(obj.mySolHint(arr, arr.length));
	}
	
	
	public int mySol(int[] arr, int n) {
		int sum = arr[0];
		
		for(int i=0;i<n;i++) {
			if(arr[i]>sum) {
				sum=arr[i];
			}
			int tempSum = arr[i];
			for(int j=i+1;j<n;j++) {
				tempSum+=arr[j];
				//int tempSum = sum+arr[j];
				if(tempSum>sum) {
					sum = tempSum;
				}
			}
		}
		
		return sum;
	}
	
	public int mySolHint(int[] arr, int n) {
		int maxF=arr[0],maxE=0;
		for(int i=0;i<n;i++) {
			maxE+=arr[i];
			if(maxF<maxE)
				maxF=maxE;
			if(maxE<0)
				maxE=0;
			
		}
		return maxF;
	}

}
