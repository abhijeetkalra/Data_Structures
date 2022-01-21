package com.abhi.practice.datastructures.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MorganStanley {

	public static void main(String[] args) {
		Car<String> cas = new Car<>();
		Car c = cas;

		Stream.of(1, 2, 3, 4, 5, 6, 7).skip(5).forEach(n -> System.out.println(n));
		
		int[] arr = {3,2,2,2,5,5,5,5,5,3,3,3,2,2,8};
		List<Integer> lis = new ArrayList<Integer>();
		for(int i: arr) {
			lis.add(i);
		}
		difference_calculator(lis);
		
	}

	public static int difference_calculator(List<Integer> arr) {
		// Write your code here
		int ind1 = calInd1(arr);
		int ind2 = calInd2(arr);
		return Math.abs(ind1 - ind2);

	}

	public static int calInd2(List<Integer> arr) {
		int res = 0;
		int i = 0;
		Map<Integer, Pair> map = new HashMap<>();
		int c = 1;
		int ind = 1;
		while (i < arr.size() - 1) {
			if (arr.get(i) == arr.get(i + 1)) {
				c++;
			} else {
				map.put(ind, new Pair(arr.get(i), c));
				ind = i+2;
				c = 1;
			}
			i++;
		}
		map.put(ind, new Pair(arr.get(i), c));

		for (Integer k : map.keySet()) {
			if (k == (map.get(k).num) && k == (map.get(k).count)) {
				res++;
			}
		}
		return res;
	}

	public static int calInd1(List<Integer> arr) {

		List<Pair> lis = new ArrayList<>();
		int c = 1;
		int i = 0;
		while (i < arr.size() - 1) {
			if (arr.get(i) == arr.get(i + 1)) {
				c++;
			} else {
				lis.add(new Pair(arr.get(i), c));
				c = 1;
			}
			i++;
		}
		lis.add(new Pair(arr.get(i), c));
		int res = 0;
		for (Pair p : lis) {
			if (p.num == p.count) {
				res++;
			}
		}
		return res;
	}

}

class Pair {
	int num;
	int count;

	public Pair(int a, int b) {
		num = a;
		count = b;
	}
}

class Car<T> {
	void set(T t) {

	}
}

class A extends Thread{
	
	private static int x;
	
	public static synchronized void abcd() {
		x++;
	}
	
	public void run() {
		abcd();
	}
}