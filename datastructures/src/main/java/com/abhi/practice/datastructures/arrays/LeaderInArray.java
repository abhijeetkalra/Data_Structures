package com.abhi.practice.datastructures.arrays;

import java.util.ArrayList;

public class LeaderInArray {

	 static ArrayList<Integer> leaders(int arr[], int n){
	        // Your code here
	        int max = 0;
	        ArrayList<Integer> res = new ArrayList<>();
	        for(int i = n-1;i>=0;i--){
	            if(arr[i]>=max){
	                res.add(0,arr[i]);
	                max=arr[i];
	            }
	        }
	        
	        return res;
	    }
}
