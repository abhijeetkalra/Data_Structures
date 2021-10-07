package com.abhi.practice.datastructures.arrays;

import java.util.Arrays;

public class NumberofPairs {
	
	
	public static int sol(int[] x, int m, int[] y, int n ) {
		int res = 0;
		
		int[] freq = new int[5];
		
		for(int i =0;i<n;i++) {//Maintaining freq of 0,1,2,3,4 in y array
			if(y[i]<5) {
				freq[y[i]]++;
			}
		}
		
		Arrays.sort(y);
		
		for(int i =0;i<m;i++) {
			
			if(x[i] == 0) continue;  // there can't be any value in y
			
			if(x[i] == 1) { //no of pairs would be equal to no of zeros in y
				res += freq[0];
				continue;
			} 
			
			//We work with logic that if x<y then x^y is greater than y^x.
            //Finding number of elements in y[] with value greater than x.
            //binary() gets address of first element greater than x[i] in y[].
            int ind = binary(x[i],y);
            
            //Updating number of pairs.
            //If we have reached here, then x must be greater than 1. 
            //Increasing number of pairs for y=0 and y=1 .
            res = res + (n - ind) + freq[0] + freq[1];
            
            //Decreasing number of pairs for exception where x=2 
            //and (y=4 or y=3).
            if(x[i] == 2)
                res = res - freq[3] - freq[4];
            
            //Increasing number of pairs for exception where x=3 and y=2.
            if(x[i] == 3)
                res = res + freq[2];
		}
		
		return res;
		
	}
	
	public static int binary(int x, int[] y) {
		int i = 0;
		while(i<y.length) {
			if(x<y[i]) {
				break;
			}
			i++;
		}
		return i;
	}

}
