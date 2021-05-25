package com.abhi.practice.datastructures.arrays;

import java.util.Arrays;

public class Paypal {
	
	public static void main(String[] args) {
		
		int desired_diff = 5;
		int[] arr = {1,2,4,2,3,2,2,6};
		//int[] arr = {1,2,3,4,5};
		System.out.println(solve(desired_diff, arr, arr.length));
		
	}
	
	static int solve(int desired_diff, int arr[], int n) {
		
		Arrays.sort(arr);
		int min = desired_diff;
		int a= arr[0];
		int b = arr[n-1];
		int res = a+b;
		
		for(int i =0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				int ar = arr[j]- arr[i];
				int diff = Math.abs(ar-desired_diff);
				if(diff<min) {
					min = diff;
					a=arr[i];
					b=arr[j];
					res=a+b;
				}
				else if(diff==min && (arr[i]+arr[j])<res) {
					a=arr[i];
					b=arr[j];
					res=a+b;
				}
			}
		}
		return res;
	}
	
}



/*
public static void main(String[] args) {
	int a[]= {1,2,3,4,5};
	int sum=3;
	Arrays.sort(a);

	int low=0,high=a.length-1;
	int diff=Integer.MAX_VALUE;
	int x = 0,y=0;
	while(low<high)
	{
	System.out.println(" --"+a[high]+" "+a[low]);
	int diff1=Math.abs(sum-(a[high]-a[low]));

	if(diff1<diff)
	{
	diff=diff1;
	x=a[low];
	y=a[high];
	}
	if(sum-(a[high]-a[low])<0)
	high--;
	else
	low++;
	}
	System.out.println(" x "+x+" y "+y+" xum"+(x+y));
	}
*/