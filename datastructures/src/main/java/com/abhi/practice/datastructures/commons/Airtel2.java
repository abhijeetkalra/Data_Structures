package com.abhi.practice.datastructures.commons;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Airtel2 {
	
	public static void main(String[] args) {
		String a = new String("a");
		String b = new String("a");
		String c = b;
		String d = "a";
		System.out.println(a==b);
		System.out.println(a.equals(b));
		
		Set<Object> strSet = new HashSet<Object>();
		
		strSet.add(b);
		strSet.add(a);
		strSet.add(d);
		System.out.println(strSet.size());
		
		String s = "dedicated";
		firstNonRepeating(s);
		Sol(s);
	}
	
	public static void firstNonRepeating(String str) {
		for(int i =0;i<str.length()-1;i++) {
			boolean flag = false;
			int j =i+1;
			while(j<str.length() && flag==false) {
				if(str.charAt(i)==str.charAt(j)) {
					flag = true;
				}
				j++;
			}
			if(!flag) {
				System.out.println(str.charAt(i));
				break;
			}
		}
	}
	
	public static void Sol(String str) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i))) {
				int c = map.get(str.charAt(i));
				map.remove(str.charAt(i));
				map.put(str.charAt(i), c+1);
			} else {
				map.put(str.charAt(i),1);
			}
		}
		
		for(Entry<Character, Integer> e : map.entrySet()) {
			System.out.println(e.getKey());
			break;
		}
	}

}
