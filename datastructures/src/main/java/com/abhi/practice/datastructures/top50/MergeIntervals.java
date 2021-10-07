package com.abhi.practice.datastructures.top50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	
	public static void main(String[] args) {
		//int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
		int[][] arr = {{1,4},{4,5}};
		sol(arr);
	}
	
	

	static int[][] sol(int[][] arr) {
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}		
		});
		
		List<int[]> list = new ArrayList<int[]>();

		int i =0;
		while(i<arr.length) {
			int j=i+1;
			while(j<arr.length) {
				if(arr[i][1] >= arr[j][0]) {
					arr[i][1] = arr[j][1];
				} else {
					list.add(arr[i]);
					break;
				}
				if(j==arr.length-1) {
					list.add(arr[i]);
				}
				j++;
				
			}
			if(i==arr.length-1) {
				list.add(arr[i]);
			}
			i=j;
		}
		
		int[][] res = new int[list.size()][];
		for(int k =0;k<list.size();k++) {
			res[k] = list.get(k);
		}
		return res;
		
	}
	
	static int[][] sol1(int[][] arr){
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}		
		});
		
		List<int[]> list = new ArrayList<int[]>();
		
		for(int i=0;i<arr.length;i++) {
			if(list.isEmpty() || list.get(list.size()-1)[1] < arr[i][0]) {
				list.add(arr[i]);
			} else {
				list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], arr[i][1]);
			}
			
		}
		
		return list.toArray(new int[list.size()][]);
	}
}


