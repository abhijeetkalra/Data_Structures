package com.abhi.practice.datastructures.sorting;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 54, 23, 456, 87, 2, 9, 567 };
		quickSort(arr, 0, arr.length-1);

		for (int e : arr) {
			System.out.println(e);
		}
	}

	
	public static void quickSort(int[] arr, int low, int high) {
		
		
		if(low<high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi-1);
			quickSort(arr, pi+1, high);
		}
		
		
	}
	
	
	public static int partition(int[] arr, int low, int high) {
		int i = low-1;
		
		int pivot = arr[high]; //Last element as pivot
		
		for(int j=low;j<=high-1;j++) {
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}
}
