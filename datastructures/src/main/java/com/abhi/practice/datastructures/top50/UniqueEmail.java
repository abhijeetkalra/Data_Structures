package com.abhi.practice.datastructures.top50;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {
	
	public static void main(String[] args) {
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		System.out.println(sol(emails));
	}
	
	
	static int sol(String[] emails) {
		
		Set<String> set = new HashSet<>();
		
		for(String str: emails) {
			String[] a1 = str.split("@");
			
			if(a1.length!=2) {
				continue;//skipping with more than 1 @
			}
			
			String domain = "@"+a1[1];
			
			String[] a2 = a1[0].split("\\+");
			String localName = a2[0].replace(".","");
			set.add(localName+domain);
		}
		
		return set.size();
	}

}
