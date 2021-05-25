package com.abhi.practice.datastructures.arrays;

public class MergeWithoutExtraSpace {
	
	public static void main(String[] args) {
		//int[] arr1 = {1,3,4,5};
		//int[] arr2 = {2,6,7,8};
		//int[] arr1 = {1,3,5,7};
		//int[] arr2 = {0,2,6,8,9};
		int[] arr1 = {21,24};
		int[] arr2 = {5,18,20};
		MergeWithoutExtraSpace obj = new MergeWithoutExtraSpace();
		obj.merge(arr1, arr2, arr1.length, arr2.length);
	}

	
	public void merge(int arr1[], int arr2[], int n, int m)  {
		int i=0;
		while(i<n) {
			if(arr1[i] > arr2[0]) {
				int temp = arr2[0];
				arr2[0] = arr1[i];
				arr1[i] = temp;
				//Arrays.sort(arr2);
				//reArrangeArr(arr2, arr2.length);
				int j = 0;
				while(j<m-1) {
					if(arr2[j]>arr2[j+1]) {
						int temp2 = arr2[j];
						arr2[j] = arr2[j+1];
						arr2[j+1] = temp2;
						j++;
					} else {
						break;
					}
				}
			}
			i++;
		}
		
	}
	
	public void reArrangeArr(int arr[], int n) {
		int i = 0;
		while(i<n-1) {
			if(arr[i]>arr[i+1]) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				i++;
			} else {
				break;
			}
		}
	}
}
