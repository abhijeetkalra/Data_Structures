package com.abhi.practice.datastructures.commons;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class GupShup {
	
	public static void main(String[] args) {
		prob1();
		
	}
	
	static void prob2() {
		String str = "assf";
		for(int i=0;i<str.length();i++) {
			int a = str.charAt(i);
			System.out.println(a);
			System.out.println(str.charAt(i));
			
		}
	}
	
	static void prob3() {
		String str = "Engineering";
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}
			else {
				map.put(str.charAt(i), 1);
			}
			
			//int a = str.charAt(i);
			//System.out.println(a);
			//System.out.println(str.charAt(i));
			
		}
		for(Entry e : map.entrySet()) {
			System.out.println(e.getKey()+":"+e.getValue());
		}
	}
	
	static void prob1() {

        int[][] arr = new int[3][3];
        arr[0][0] = 3;
        arr[0][1] = 3;
        arr[0][2] = 3;
        arr[1][0] = 1;
        arr[1][1] = 5;
        arr[1][2] = 16;
        arr[2][0] = 3;
        arr[2][1] = 5;
        arr[2][2] = 15;
        String[] arr1 = new String[] {"aaaaa", "bbbbb", "ccccc", "ddddd","eeeee"};
         
        System.out.println("arr[0][0] = " + arr[0][0]);
        System.out.println(arr.length);
        char[] res = new char[arr.length];

        for(int i=0;  i<arr.length; i++){
            String concatStr="";
            for(int j=arr[i][0]-1;j<arr[i][1];j++){
                concatStr+=arr1[j];
            }
            res[i] = concatStr.charAt(arr[i][2]-1);

        }
        
        
        
	}
	
	

}
