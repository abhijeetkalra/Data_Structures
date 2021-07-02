package com.abhi.practice.datastructures.lbsheet;

public class KthMinElement {
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 54, 23, 456, 87, 2, 9, 567 };
		System.out.println(kthElement(arr, 0, arr.length-1, 3));
	}
	
	public static int kthElement(int[] arr, int low, int high, int k) {
		
		int p = partition(arr, low, high);
		if(k-1 == p) {
			return arr[p];
		}
		
		else if(k-1 > p) {
			return kthElement(arr, p+1, high, k);
		}
		
		else {
			return kthElement(arr, low, p-1, k);
		}
		
	}
	
	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(arr[j]>pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] =temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}

}
