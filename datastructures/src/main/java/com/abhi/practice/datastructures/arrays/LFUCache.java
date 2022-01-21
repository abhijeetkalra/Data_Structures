package com.abhi.practice.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LFUCache {
	
	static Map<Integer, Integer> data = new HashMap<>();
	static Map<Integer, Integer> freqCount = new HashMap<Integer, Integer>();
 	
	static Map<Integer, LinkedHashSet<Integer>> freqMap = new TreeMap<Integer, LinkedHashSet<Integer>>();
	
	static int cap =0;
	
	
	public static void main(String[] args) {
		put(0,0);
		get(0);
		put(2, 2);
		put(1, 1);
		get(2);
		get(1);
		get(2);
		put(3, 3);
		put(4, 4);
		get(3);
		get(2);
		get(1);
		get(4);
	}
	
	public static int get(int key) {
		
		if(!data.containsKey(key)) {
			return -1;
		}
		
		int freq = freqCount.get(key);
		
		freqMap.get(freq).remove(key);
		if(freqMap.get(freq).isEmpty()) {
			freqMap.remove(freq);
		}
		
		freq++;
		if(freqMap.containsKey(freq)) {
			freqMap.get(freq).add(key);
		} else {
			freqMap.put(freq, new LinkedHashSet<Integer>());
			freqMap.get(freq).add(key);
		}
		
		freqCount.put(key, freq);
		
		
		return data.get(key);
		
	}
	
	public static void put(int key, int value) {
		
		if(data.containsKey(key)) {
			get(key);
			data.put(key, value);
			return;
		}
		if(cap==0) return;
		
		if(data.size()==cap) {
			int keyR=0;
			for(int k: freqMap.keySet()) {
				LinkedHashSet<Integer> set = freqMap.get(k);
				for(int i: set) {
					keyR = i;
					set.remove(i);
					break;
				}
				
				if(freqMap.get(k).isEmpty()) {
					freqMap.remove(k);
				}
				break;
			}
			data.remove(keyR);
			freqCount.remove(keyR);
		}
		data.put(key, value);
		freqCount.put(key, 1);
		if(freqMap.containsKey(1)) {
			freqMap.get(1).add(key);
		}else {
			freqMap.put(1, new LinkedHashSet<Integer>());
			freqMap.get(1).add(key);
		}
	}

}
