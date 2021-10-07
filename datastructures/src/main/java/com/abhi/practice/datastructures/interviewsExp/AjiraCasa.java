package com.abhi.practice.datastructures.interviewsExp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class AjiraCasa {
	
	
	
	/* 
	 M -> S,L
	 S -> L,H
	 L -> F,C
	 H -> M,F,L
	 C -> S,H
	 F -> M,C
	 */
	
	
	public static void main(String[] args) {
		String s1 = "Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120";
		String s2 = "Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Give list of platoons that you have with their classes and number of units:");
		//String s1 = sc.next();
		System.out.println("Give the list of platoons of the opponent:");
		//String s2 = sc.next();
		System.out.println("Result: ");
		
		System.out.println(startExecution(s1, s2));
	}
	
	
	private static String startExecution(String own, String opp) {
		
		//this map contains key=soldierType, value=Map of soldier it can face (including adv graph)
		Map<String, Map<String,Integer>> inMap = getInput(own);
		
		//this map contains opponent line-up, key=soldierType and value=num of soldiers 
		Map<String, Integer> oppMap = getOppString(opp);
		
		//only values of own platoons from inMap
		Collection<Map<String, Integer>> valuesInMap =  inMap.values();
		
		//This map contains key=opponent soldier type, value= list of soldier from own platoons that can beat this platoon
		Map<String, List<String>> defMap = getDefMap(valuesInMap, oppMap);
		
		//sorting on the basis of list size in value
		defMap = sortDefMap(defMap);
		
		//final line-up,(with success win)  key=opponent platoon, value=own platoon
		Map<String, String> inOppMap = getInOppMap(defMap); //one to one line up
		
		String res = "";
		
		if(inOppMap.size()<3) res = "There is no chance of winning";
		
		else {
			String[] str = new String[5];
			int i = 0;
			for(String s : oppMap.keySet()) {
				if(inOppMap.containsKey(s)) {
					String soldierType = inOppMap.get(s);
					int num = ((Map<String, Integer>) inMap.get(soldierType)).get(soldierType);
					str[i] = soldierType+'#'+num;
					inMap.remove(soldierType);
				}
				i++;
			}
			
			//to fill up nulls in str arr
			for(int j=0; j<str.length;j++) {
				if(str[j] == null) {
					String soldierType = (String) inMap.keySet().toArray()[0];
					int num = ((Map<String, Integer>) inMap.get(soldierType)).get(soldierType);
					str[j] = soldierType+'#'+num;
					inMap.remove(soldierType);
				}
			}
			
			res = String.join(";", str);
		}
		
		return res;
		
	}
	
	
	
	private static Map<String, String> getInOppMap(Map<String, List<String>> map){
		Map<String, String> inOppMap = new HashMap<String, String>();
		
		for(Map.Entry<String, List<String>> e : map.entrySet()) {
			
			for(String s : e.getValue()) {
				if(!inOppMap.containsValue(s)) {
					inOppMap.put(e.getKey(), s);
					break;
				}
			}
		
		}
		return inOppMap;
	}
	
	private static Map<String, List<String>> sortDefMap(Map<String, List<String>> map){
		
		List< Map.Entry<String, List<String>> > list = new LinkedList<Map.Entry<String,List<String>>>(map.entrySet());
		
		Collections.sort(list, new Comparator< Map.Entry<String, List<String> >  >() {
			@Override
			public int compare(Entry<String, List<String>> o1, Entry<String, List<String>> o2) {
				return o1.getValue().size()-o2.getValue().size();
			}
		});
		Map<String, List<String>> defMap = new LinkedHashMap<>();
		for(Map.Entry<String, List<String>> e : list) {
			defMap.put(e.getKey(), e.getValue());
		}
		return defMap;
	}
	
	
	private static Map<String, List<String>> getDefMap(Collection<Map<String, Integer>> valuesInMap, Map<String, Integer> oppMap){
		Map<String, List<String>> defMap = new HashMap<>();
		for(String s : oppMap.keySet()) {
			List<String> lisDef = new ArrayList<String>();
			for(Map<String, Integer> m : valuesInMap) {
				if(m.containsKey(s) && m.get(s)>oppMap.get(s)) { // this entry can defeat opp entry
					String key = (String) m.keySet().toArray()[0];
					lisDef.add(key);
				}
			}
			defMap.put(s, lisDef);
		}
		return defMap;
	}
	
	
	private static Map<String, Integer> getOppString(String str) {
		Map<String, Integer> oppMap = new LinkedHashMap<String, Integer>();
		
		String[] a1 = str.split(";");
		
		for(int i =0; i<a1.length;i++) {
			String[] a2 = a1[i].split("#");
			oppMap.put(a2[0], Integer.parseInt(a2[1]));
		}
		return oppMap;
	}
	
	private static Map<String, Map<String, Integer>> getInput(String str) {
		
		Map<String, Map<String, Integer>> map = new LinkedHashMap<String, Map<String,Integer>>();
		
		String[] a1 = str.split(";");
		
		for(int i =0; i<a1.length;i++) {
			String[] a2 = a1[i].split("#");
			map.put(a2[0], getInternalMap(a2));
		}
		return map;
	}
	
	private static Map<String, Integer> getInternalMap(String [] arr){
		Map<String, Integer> intMap = new LinkedHashMap<String, Integer>();
		
		switch (arr[0]) {
		case "Militia":
			intMap.put("Militia", Integer.parseInt(arr[1]));
			intMap.put("Spearmen", 2*Integer.parseInt(arr[1]));
			intMap.put("LightCavalry", 2*Integer.parseInt(arr[1]));
			break;
			
		case "Spearmen":
			intMap.put("Spearmen", Integer.parseInt(arr[1]));
			intMap.put("LightCavalry", 2*Integer.parseInt(arr[1]));
			intMap.put("HeavyCavalry", 2*Integer.parseInt(arr[1]));
			break;
			
		case "LightCavalry":
			intMap.put("LightCavalry", Integer.parseInt(arr[1]));
			intMap.put("FootArcher", 2*Integer.parseInt(arr[1]));
			intMap.put("CavalryArcher", 2*Integer.parseInt(arr[1]));
			break;
			
		case "HeavyCavalry":
			intMap.put("HeavyCavalry", Integer.parseInt(arr[1]));
			intMap.put("Militia", 2*Integer.parseInt(arr[1]));
			intMap.put("FootArcher", 2*Integer.parseInt(arr[1]));
			intMap.put("LightCavalry", 2*Integer.parseInt(arr[1]));
			break;
			
		case "CavalryArcher":
			intMap.put("CavalryArcher", Integer.parseInt(arr[1]));
			intMap.put("Spearmen", 2*Integer.parseInt(arr[1]));
			intMap.put("HeavyCavalry", 2*Integer.parseInt(arr[1]));
			break;
			
		case "FootArcher":
			intMap.put("FootArcher", Integer.parseInt(arr[1]));
			intMap.put("Militia", 2*Integer.parseInt(arr[1]));
			intMap.put("CavalryArcher", 2*Integer.parseInt(arr[1]));
			break;
			
		default:
			break;
		}
		
		return intMap;
	}
	
	

}
