package com.abhi.practice.datastructures.commons;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class AmazonNIks {
	
	public static void main(String[] args) {
		String[] logs = new String[] {"12 12 10", "123 456 12", "12 123 34", "12 345 56", "12345678 34567812 12", 
				"12345678 2345678 11", "123456789 12 1", "123456789 456 2"};
		System.out.println(sol(logs,2));
	}
	
	static String[] sol(String[] logs, int threshold) {
		Map<BigInteger, Integer> transMap = new HashMap<BigInteger, Integer>();
		Set<BigInteger> res = new TreeSet<BigInteger>();
		
		for(String str :logs) {
			String[] temp = str.split(" ");
			BigInteger id1 = new BigInteger(temp[0]);
			BigInteger id2 = new BigInteger(temp[1]);
			
			if(transMap.containsKey(id1)) {
				transMap.put(id1, transMap.get(id1)+1);
				if(transMap.get(id1)>=threshold) {
					res.add(id1);
				}
			} else {
				transMap.put(id1, 1);
			}
			if(!id1.equals(id2)) {	
				if(transMap.containsKey(id2)) {
					transMap.put(id2, transMap.get(id2)+1);
					if(transMap.get(id2)>=threshold) {
						res.add(id2);
					}
				} else {
					transMap.put(id2, 1);
				}
			}
			
		}
		Object[] obj =  res.toArray();
		String[] result=new String[obj.length];

		for (int i=0;i<obj.length;i++) {
			result[i]=obj[i].toString();
		}
		return result;
	}

}
