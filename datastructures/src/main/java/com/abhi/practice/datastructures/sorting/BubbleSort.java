package com.abhi.practice.datastructures.sorting;



//Compares each pair of adjacent items and swaps them if they are in wrong order
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 54, 23, 456, 87, 2, 9, 567 };

		for (int e : bubbleSortImproved2(arr)) {
			System.out.println(e);
		}
	}

	public static int[] bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	
	public static int[] bubbleSortImproved2(int[] arr) {

		boolean swapped = true;
		for (int i = arr.length-1; i >=0 && swapped; i--) {
			swapped = false;
			for (int j = 0; j < i-1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
		}
		return arr;
	}

}

//Also known as sinking sort
//Time complexity O(n^2)