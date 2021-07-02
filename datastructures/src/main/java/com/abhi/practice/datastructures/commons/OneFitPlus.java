package com.abhi.practice.datastructures.commons;

import java.util.Arrays;

public class OneFitPlus {
	
	public static void main(String[] args) {
		//int[] a = {1,2,3,4};
		//int[] b = {5,6,7,8};
		int[] a = {0,3,7,11};
		int[] b = {-1,9,10,21,25,29};
		sol2(a,b);
		
		
		System.out.println("");
		//int[] res = sol(a,b);
		//for(int i=0;i<res.length;i++) {
		//	System.out.println(res[i]);
		//}
	}
	
	
	static int[] sol(int[] a, int[] b) {
		int[] res = new int[a.length+b.length];
		int i = 0, j=0, k=0;
		while(k<res.length) {
			if(i<a.length && j<b.length && a[i]<b[j] ) {
				res[k] = a[i];
				i++;
			} else if(i<a.length && j<b.length && a[i]>b[j] ) {
				res[k] = b[j];
				j++;
			} else if(i<a.length && j<b.length && a[i]==b[j]){
				res[k] = a[i];
				i++;
				k++;
				res[k] = b[j];
				j++;
			} else if(i>=a.length && j<b.length) {
				res[k]=b[j];
				j++;
			} else if(i<a.length && j>=b.length) {
				res[k]=a[i];
				i++;
			}
			k++;			
		}
		
		
		return res;
	}
	
	static void sol2(int[] a, int[] b) {
		int i=0, j=0, k=a.length-1;
		while(j<b.length && i<=k) {
			if(a[i]>=b[j]) {
				int temp = a[k];
				a[k] = b[j];
				b[j] = temp;
				j++;
				k--;
			} else {
				i++;
			}
			
		}
		Arrays.sort(a);
		Arrays.sort(b);
		for(int x=0;x<a.length;x++) {
			System.out.println(a[x]);
		}
		for(int x=0;x<b.length;x++) {
			System.out.println(b[x]);
		}
	}

}
