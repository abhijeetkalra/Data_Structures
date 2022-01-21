package com.abhi.practice.datastructures.interviewsExp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArvInt {

	public static void main(String[] args) {
		// int array[] = {1, 10, 3, 11, 6, 15};
		int array[] = { 1, 2, 3, 4, 5, 6 };
		System.out.println(sol2(array));
	}

	public static int prob1(int[] arr) {

		int res = 1;

		Arrays.sort(arr);

		int j = 0;
		int sum = 0;
		while (j < arr.length) {
			if (arr[j] == res) {

				sum += arr[j];
				j++;
				res++;
			} else if (sum == res) {
				res++;
			} else {
				break;
			}
		}

		return res;
	}

	public static int sol2(int[] arr) {

		Set<Integer> set = new HashSet<Integer>();

		int temp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			temp += arr[i];
			set.add(arr[i]);
			for (int j = i + 1; j < arr.length; j++) {
				set.add(temp + arr[j]);
			}
		}
		set.add(arr[arr.length - 1]);

		int res = 1;
		while (true) {
			if (set.contains(res)) {
				res++;
			} else {
				break;
			}
		}

		return res;
	}

	public static int sol3(int[] arr) {
		int res = 1;

		Arrays.sort(arr);

		int j = 0;
		int sum = 0;
		
		while(j < arr.length-1) {
			if(arr[j]+1==arr[j+1]) {
				j++;
			}
			else {
				break;
			}
		}
		
		res = j*(j+1)/2;
		
		
		return 0;
	}
	
	
	
	//5->7->17->13->11
	//12->10->2->4->6
	public static void sol4(Node h1, Node h2) {
		Node t1 = h1;
		Node t2 = h2;
		while(t1!= null && t1.next!=null && t2!= null && t2.next !=null) {
			Node t = t1.next;
			t1.next = t2;
			t1.next.next = t;
			t1=t;
			t2=t2.next;
		}
		h2=t2;
	}
}


class Node{
	Node next;
	int val;
}
