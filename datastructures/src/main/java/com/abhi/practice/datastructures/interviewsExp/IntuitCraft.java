package com.abhi.practice.datastructures.interviewsExp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntuitCraft {
	
	
	public static void main(String[] args) {
			
		System.out.println(convertToArray("aaabbbccc"));
		System.out.println(convertToArray("bbcebab"));//2
		System.out.println(convertToArray("abcabc"));//3   
		System.out.println(convertToArray("aaabbbcc"));//2  
		
		/*
		int[] arr = {1,2,4,5,5,5,5,8,8};
		List<Integer> lis = new ArrayList<Integer>();
		for(int i:arr) {
			lis.add(Integer.valueOf(i));
		}
		
		System.out.println(sol1(lis));
		*/
	}
	
	public static int convertToArray(String str) {
		Map<Character,Integer> map = new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		//	a-3, b-3, c-3	{3,3,3}
		// b-4, c-1, e-1, a-1	{1,1,1,4}
		
		List<Integer> list = new ArrayList<>(map.values());
		Collections.sort(list);
		return sol1(list);
		
	}
	
	/*  
	 * {1,1,2,3,4,5} -> 1
	 * {1,2,3,4,5,5} -> 5
	 * {1,2,4,5,5,5} -> {1,2,3,4,5,5,5} -> 7
	 * {1,2,4,5,5,5,5,8,8} -> 13
	 * 
	 * 1-9999
	 * Stack 6 3
	 * XX TreeSet: {1,2,4,5,8}
	 * PQ {1,2,3,4,5,6,8}
	 * Queue 
	*/
	
	public static int sol1(List<Integer> list) {
		int k = list.size()-1;
		
		int res = 0;
		while(k>0) {
			if(list.get(k).equals(list.get(k-1))) {
				int q = k-1;
				while(q>0) {
					if(list.get(q).equals(list.get(q-1)) || (list.get(q)).equals( list.get(q-1)+1 ) ) {
						q--;
					}else {
						break;
					}
				}
				if(q>0) {
					int t = list.get(q);
					res += list.get(k)-t+1;
					list.add(q,list.get(q)-1);
					k++; //since element added to list
				} else if(list.get(0)>1) {
					res += list.get(k)-list.get(0)+1;
					list.add(q,list.get(q)-1);
					k++; //since element added to list
					
				} else {
					res += list.get(k);
				}
			}
			
			k--;
		}
		
		//System.out.println(res);
		return res;
	}
	
	public static int sol2(List<Integer> list) {
		int k = list.size()-1;
		
		int res = 0;
		int tempInd = k;
		while(k>0) {
			if(list.get(k).equals(list.get(k-1))) {
				//int q = k-1;
				int q = Math.min(k-1, tempInd);
				while(q>0) {
					if(list.get(q).equals(list.get(q-1)) || (list.get(q)).equals( list.get(q-1)+1 ) ) {
						q--;
					}else {
						tempInd = q;
						break;
					}
				}
				if(q>0) {
					int t = list.get(q);
					res += list.get(k)-t+1;
					list.add(q,list.get(q)-1);
					k++; //since element added to list
				} else if(list.get(0)>1) {
					res += list.get(k)-list.get(0)+1;
					list.add(q,list.get(q)-1);
					k++; //since element added to list
					
				} else {
					res += list.get(k);
				}
			}
			
			k--;
		}
		
		//System.out.println(res);
		return res;
	}

}
