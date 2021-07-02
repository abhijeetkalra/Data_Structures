package com.abhi.practice.datastructures.sorting;

public class MergeSort {
	
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 54, 23, 456, 87, 2, 9, 567 };
		mergeSort(arr, 0, arr.length-1);

		for (int e : arr) {
			System.out.println(e);
		}
	}
	
	
	public static void mergeSort(int[] arr, int l, int r) {
		int mid = (l+r)/2;
		if(l>=r) {
			return;
		}
		mergeSort(arr, l, mid);
		mergeSort(arr, mid+1, r);
		merge(arr,l,mid,r);
		
		
	}
	
	public static void merge(int[] arr, int l, int mid, int r) {
		int n1 = mid-l+1;
		int n2 = r-mid;
		int[] lArr = new int[n1];
		int[] rArr = new int[n2];
		
		for(int i=0;i<n1;i++) {
			lArr[i] = arr[l+i];
		}
		for(int i=0;i<n2;i++) {
			rArr[i] = arr[mid+i+1];
		}
		
		int i=0,j=0,k=l;
		while(i<n1 && j<n2) {
			if(lArr[i]<rArr[j]) {
				arr[k] = lArr[i];
				i++;
			} else {
				arr[k] = rArr[j];
				j++;
			}
			k++;
		}
		
		while(i<n1) {
			arr[k] = lArr[i];
			i++;
			k++;
		}
		while(j<n2) {
			arr[k] = rArr[j];
			j++;
			k++;
		}
		
	}

}
