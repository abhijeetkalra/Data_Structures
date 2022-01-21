package com.abhi.practice.datastructures.interviewsExp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreshWorks {
	
	
	public static void main(String[] args) {
		
		int[] arr = {3, 5, -2, 1, 2, 0}; 
		//[3, 5, -2, 1, 2, 0]
		//[ [ 3, 0 ], [ 1, 2 ], [ 5, -2 ] ]
		//sol(arr, 3);
		
		preDefine();
		//sol2(5,10);
		leetCode(3);
	}
	
	public static List<List<Integer>> sol(int[] arr,int target){
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		for(int i =0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(arr[i]);
				l.add(map.get(arr[i]));
				res.add(l);
			}
			map.put(target-arr[i], arr[i]);
			
		}

		return res;
		
	}

/*
3-> 0-3
5-> -2-5
-2-> -2-5*/

/*
Dialling Knight


1 2 3
4 5 6
7 8 9
  0



string[] generateUniqueNumbers(int start, int hops)

start -> 0-9
hops -> >0

generateUniqueNumbers(0, 1) => [ '04', '06' ]

generateUniqueNumbers(0, 2) => [ '040', '049', '043', '060', '067', '061' ]

generateUniqueNumbers(5, *) => []*/
	
	
	static int leetCode(int n) {
		int res = 0;
        for(int i=0;i<10;i++){
            res+=sol2(i,n-1);
            System.out.println(res);
        }
        return res;
	}
	
	static Map<Integer, List<Integer>> hopMap = new HashMap<Integer, List<Integer>>();
	public static void preDefine() {
		
		hopMap.put(0, new ArrayList<Integer>());
		hopMap.get(0).add(4);
		hopMap.get(0).add(6);
		
		hopMap.put(1, new ArrayList<Integer>());
		hopMap.get(1).add(6);
		hopMap.get(1).add(8);
		
		hopMap.put(2, new ArrayList<Integer>());
		hopMap.get(2).add(7);
		hopMap.get(2).add(9);
		
		hopMap.put(3, new ArrayList<Integer>());
		hopMap.get(3).add(4);
		hopMap.get(3).add(8);
		
		hopMap.put(4, new ArrayList<Integer>());
		hopMap.get(4).add(3);
		hopMap.get(4).add(9);
		hopMap.get(4).add(0);
		
		hopMap.put(5, new ArrayList<Integer>());
		
		hopMap.put(6, new ArrayList<Integer>());
		hopMap.get(6).add(1);
		hopMap.get(6).add(7);
		hopMap.get(6).add(0);
		
		hopMap.put(7, new ArrayList<Integer>());
		hopMap.get(7).add(2);
		hopMap.get(7).add(6);
		
		hopMap.put(8, new ArrayList<Integer>());
		hopMap.get(8).add(1);
		hopMap.get(8).add(3);
		
		hopMap.put(9, new ArrayList<Integer>());
		hopMap.get(9).add(2);
		hopMap.get(9).add(4);
	}
	
	static int sol2(int st, int h) {
		
		
		List<String> res = new ArrayList<String>();
		recSol2(Integer.toString(st), h, res);
		System.out.print(st+"->");
		res.forEach(e->System.out.print(e+", "));
		System.out.println();
		return res.size();
		
	}
	
	static List<String> recSol2(String st, int h, List<String> res) {
		//String i = Integer.toString(st);
			if(h==0) {
				res.add(st);
				return res;
			}
			List<String> temp = new ArrayList<String>();
			
			int ind = Integer.parseInt(st.substring(st.length()-1));
			int index = Integer.parseInt(st);
			for(int a : hopMap.get(index%10)) {
				String s = st+a;
				temp.add(s);
				//temp.add(Integer.parseInt(s));
			}
			for(String t : temp) {
				recSol2(t,h-1, res);
			}
			return res;
	}
			
				
}