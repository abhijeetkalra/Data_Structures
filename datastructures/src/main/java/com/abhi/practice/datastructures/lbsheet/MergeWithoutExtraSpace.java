package com.abhi.practice.datastructures.lbsheet;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
	
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5, 7};
		int[] arr2 = {0, 2, 6, 8, 9};
		//int[] arr1 = {1, 1, 1, 2, 3, 5, 7, 7, 7, 9, 9, 13, 13, 14, 14, 17, 17, 19, 20, 20};
		//int[] arr2 = {3, 5, 7, 9, 10, 12, 13, 14, 20, 20};
		
		
		sol2(arr1, arr2, arr1.length, arr2.length);
		
		
		
	}
	
	static void sol(int[] arr1, int[] arr2, int n, int m) {
		
		for(int i=0,j=0;i<n && j<m;i++) {
			if(arr1[i]>arr2[j]) {
				int temp = arr1[i];
				int lArr1 = arr1[n-1];
				arr1[i] = arr2[j];
				arr2[j] = lArr1;
				j++;
				for(int k=n-1;k>i;k--) {
					if(k==i+1) {
						arr1[k] = temp;
					} else {
						arr1[k] = arr1[k-1];
					}
				}
			}
		}
		Arrays.sort(arr2);
	}
	
	static void sol2(int[] arr1, int[] arr2, int n, int m) {

		int i=0;
		int j=n-1;
		int k = 0;
		while(i<=j && k<m) {
			if(arr1[i]>=arr2[k]) {
				//int temp = arr1[i];
				int temp = arr1[j];
				arr1[j] = arr2[k];
				arr2[k] = temp;
				k++;
				j--;
			} else {
				i++;
			}
		}
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}
	
	
	
	static int insertion(int a, int[] arr, int l) {
		
		return 0;
	}
	
	
	static void swap(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a:"+a+" b:"+b);
	}

}
