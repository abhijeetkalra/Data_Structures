package com.abhi.practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArraysWithGivenSum {
	
	public static void main(String[] args) {
		SubArraysWithGivenSum obj = new SubArraysWithGivenSum();
		//int[] arr = {1,2,3,7,5};
		int[] arr = {1,2,3,4,5,6,7,8,9,10,134};
		obj.gfgSol(arr, arr.length, 134);
		
	}
	
	
	//Time Limit Exceeded
	public ArrayList<Integer> mySol(int[] arr, int n, int s) {
		
		ArrayList<Integer> alRes = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			int sum = 0;
			int j = i;
			while(sum<s && j<n) {
				sum += arr[j];
				j++;
			}
			if(sum==s) {
				alRes.add(i+1);//for Position
				alRes.add(j);
				break;
			}
		}
		
		if(alRes.size() == 0)
			alRes.add(-1);
		
		return alRes;
	}
	
	//Test Case failing
	public ArrayList<Integer> mySolWithHint(int[] arr, int n, int s) {
		ArrayList<Integer> alRes = new ArrayList<Integer>();
		int start=0,end=0,sum= 0;
		
		while(sum != s && end<n && start<=end) {
			sum = 0;
			for(int i=start;i<=end;i++)
				sum +=arr [i];
			
			if(sum < s) {
				end++;
			} else if( sum > s) {
				start++;
			} else if(sum == s ){
				alRes.add(new Integer(start+1));//for Position
				alRes.add(new Integer(end+1));
			}
			
		}
		
		if(alRes.size() == 0)
			alRes.add(-1);
		
		return alRes;
	}
	
	public ArrayList<Integer> gfgSol(int[] arr, int n, int s) {
		int first = 0;
        int last = 0;

        long result = arr[first];
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (result != s) {
            if (result > s) {
                if (first == last) {
                    last++;
                    first++;
                    if (last >= n) break;
                    result = arr[first];
                } else {
                    result -= arr[first];
                    first++;
                }
            } else {
                last++;
                if (last < n) {
                    result += arr[last];
                } else {
                    break;
                }
            }
        }

        if (result != s) {
            res.add(-1);
        } else {
            res.add(first + 1);
            res.add(last + 1);
            
        }
        return res;
	}

}
