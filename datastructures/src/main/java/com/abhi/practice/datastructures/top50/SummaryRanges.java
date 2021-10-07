package com.abhi.practice.datastructures.top50;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	
	
	public static void main(String[] args) {
		//int[] arr = {3,2,1};
		int[] arr = {1};
		//int[] arr = {0,1,2,4,5,6};
		sol(arr).forEach(e -> System.out.println(e));
	}

	
	static List<String> sol(int[] arr){
		List<String> res = new ArrayList<String>();
        
        if(arr.length==0) return res;
        if(arr.length==1) {
			res.add(Integer.toString(arr[0]));
			return res;
		}
		
		boolean flag = false;
		int j=0;
		for(int i=0;i<arr.length-1;i++) {
			j=i;
			while(j<arr.length-1 && (arr[j]+1)==arr[j+1]) {
				flag = true;
				j++;
			}
			if(flag) {
				String s = Integer.toString(arr[i])+"->"+Integer.toString(arr[j]); 
				res.add(s);
				i=j;
			} else {
				res.add(Integer.toString(arr[i]));
			}
			flag = false;
		}
		if(j!=arr.length-1) {
			res.add(Integer.toString(arr[arr.length-1]));
		}
		return res;
		
	}
}
