package com.abhi.practice.datastructures.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFromArray {

	public static void main(String[] args) {
		String arr[] = { "3", "30", "34", "5", "9" };
		sol(arr);
	}

	public static void sol(String arr[]) {

		Comparator<String> comp = new Comparator<String>() {

			public int compare(String x, String y) {
				String yx = y + x;
				String xy = x + y;
				return yx.compareTo(xy);
			}

		};

		Arrays.sort(arr, comp);

		String s = String.join("", arr);
	}

}
