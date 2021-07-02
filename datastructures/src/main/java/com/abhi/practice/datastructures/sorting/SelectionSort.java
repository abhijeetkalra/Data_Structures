package com.abhi.practice.datastructures.sorting;



//The smallest element is exchanged with first element of unsorted list, 2nd smallest with 2nd element and so on, 
//hence one pass will have only one swap
public class SelectionSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 54, 23, 456, 87, 2, 9, 567 };

		for (int e : selectionSort(arr)) {
			System.out.println(e);
		}
	}
	
	public static int[] selectionSort(int[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			int min = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		return arr;
	}

}
