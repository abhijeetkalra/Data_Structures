package com.abhi.practice.datastructures.interviewsExp;

import java.util.ArrayList;
import java.util.List;

/*
 ABC
 A BC
 AB C
 
 */
public class AirtelX2 {
	
	
	public static void main(String[] args) {
		List<String> res = sol("ABC");
	}
	
	public static List<String> sol(String str) {
		
		List<String> lis = new ArrayList<String>();
		
		int n = str.length();
		
		
		int j=1; //No of spaces
		str.indexOf(j);
		while(j<n) {
			for(int i=1;i<n;i++) {
				
				int k = i;
				int q = j;
				String t=str.substring(0,i);
				while(q>0 && k<n) {
					t += str.substring(k,k+1)+" ";
					k++;
					q--;
				}
				t= t +str.substring(k);
				lis.add(t);
			}
			j++;
		}
		
		return lis;
	}
	
	
	/*
	 ABCD
	 1 - A BCD, AB CD, ABC D
	 2 - A B CD, AB C D,
	 3 - A B C D
	 
*/	
	public static List<String> sol2(String str) {
		List<String> lis = new ArrayList<String>();
		
		int i =0;
		int k =0;
		return null;
		
	}
	
	//dedicated
	
	

}
