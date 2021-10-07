package com.abhi.practice.datastructures.top50;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	public static void main(String[] args) {
        //int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		List<Integer> res = new ArrayList<Integer>();
		boolean[][] used = new boolean[arr.length][arr[0].length];
		loop(arr, 0, res, used);
		res.forEach(e -> System.out.print(e+" "));
	}

	
	
	
	static List<Integer> sol(int[][] arr){
		List<Integer> res = new ArrayList<Integer>();
		
		int j=0;
		int k =0;
		for(int i=0;i<arr.length;i++) {
			
			if(j==0) {
				k = j;
				while(k<arr[i].length) {
					res.add(arr[i][k]);
					k++;
				}
			} else if(j==arr[i].length) {
				k = j;
				while(k>=0) {
					res.add(arr[i][k]);
					k--;
				}
			}	
		}
		return res;
	}
	
	
	
	static List<Integer> loop(int[][] arr, int k, List<Integer> res, boolean[][] used){
		if(2*k>arr.length || 2*k>arr[0].length) {
			return res;
		}
		int i =0; int j =0;
		while(j+k<arr[0].length-k) {
			if(!used[i+k][j+k]) {
				res.add(arr[i+k][j+k]);
				used[i+k][j+k] = true;
			}
			j++;
		}
		j--;
		i++;
		while(i+k<arr.length-k) {
			if(!used[i+k][j+k]) {
				res.add(arr[i+k][j+k]);
				used[i+k][j+k] = true;
			}
			i++;
		}
		i--;
		j--;
		while(j+k>=k) {
			if(!used[i+k][j+k]) {
				res.add(arr[i+k][j+k]);
				used[i+k][j+k] = true;
			}
			j--;
		}
		j++;
		i--;
		while(i+k>=k+1) {
			if(!used[i+k][j+k]) {
				res.add(arr[i+k][j+k]);
				used[i+k][j+k] = true;
			}
			i--;
		}
		i++;
		return loop(arr, k+1, res, used);
	}
	
	
}
