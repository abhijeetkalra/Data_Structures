package com.abhi.practice.datastructures.arrays;

import java.util.Arrays;

public class CountTheTriplets {

    public static void main(String[] args) {
        CountTheTriplets ctt = new CountTheTriplets();
        //int[] arr = {12,8,2,11,5,14,10};
        int[] arr = { 1,5,3,2,4};
        int re = ctt.countTripletMySol(arr, arr.length);
        int re1 = ctt.countTripleHint(arr, arr.length);
        System.out.println(re);
        System.out.println(re1);
    }

    public int countTripletMySol(int[] arr, int n){
        Arrays.sort(arr);
        int res = 0;
        for(int i = 0; i<n-2; i++){
            for (int j=i+1; j<n-1; j++){
            	for(int k=j+1;k<n;k++) {
            		if(arr[i]+arr[j] == arr[k]) {
                        res++;
                        break;
                    }
            	}
            }
        }
        return res;
    }
    
    public int countTripleHint(int[] arr, int n) {
    	Arrays.sort(arr);
    	int res = 0;
    	for(int i=n-1;i>1;i--) {
    		int low = 0;
        	int high = n-2;
    		while(low < high) {
        		if(arr[low]+arr[high] == arr[i]) {
        			res++;
        			low++;
        			high--;
        			//break;
        		} else if(arr[low]+arr[high] < arr[i]) {
        			low++;
        		} else if(arr[low]+arr[high] > arr[i]) {
        			high--;
        		}
    	}
    	
    	}
    	return res;
    	
    }
}

