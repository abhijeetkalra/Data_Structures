package com.abhi.practice.datastructures.sorting;



//picks element one by one and places it to the right position where it belongs
//iterate from arr[1] to arr[n]
//compare the current element(key) to its predecessors 
//if it is smaller further compare it to the before elements,
//move greater elements one position ahead, and insert key where its greater
public class InsertionSort {
	
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 54, 23, 456, 87, 2, 9, 567 };

		for (int e : insertionSort(arr)) {
			System.out.println(e);
		}
	}
	
	public static int[] insertionSort(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			int key = arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		return arr;
	}

}
