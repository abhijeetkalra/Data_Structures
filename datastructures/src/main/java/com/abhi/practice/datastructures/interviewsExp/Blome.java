package com.abhi.practice.datastructures.interviewsExp;

import java.util.Stack;

public class Blome {

	
	
	public static void main(String[] args) {
		sol2("aabaamynameisaabbaa");
	}
	
	
	//aabaamynameisaabbaa
	
	/*
	 *   Stack 1 : b a a
	 *   Stack 2 : 
	 */
	public static void sol(String str) {
		
		
		Stack<Character> s1 = new Stack<Character>();
		
		int res = 0;
		for(int i=0;i<str.length();i++) {
			s1.clear();
			int j=i;
			while(j<str.length()/2) {
				s1.push(str.charAt(j));
				j++;
				if(check(str, j, s1)) {
					res = Math.max(res, s1.size());
				}
				
			}
			
		}
		
		System.out.println(res);
		
		
		
		
	}
	
	public static boolean check(String str, int ind, Stack<Character> s) {
		String t1 = "";
		String t2 = str.substring(ind,ind+s.size());
		Stack<Character> s2 = new Stack<Character>();
		while(!s.isEmpty()) {
			Character c = s.pop();
			s2.push(c);
			t1+=c;
		}
		
		while(!s2.isEmpty()) {
			Character c = s2.pop();
			s.push(c);
			
		}
		
		
		return t1.equals(t2);
	}
	
	public static void sol2(String str) {
		
		int res = 1;
		String resP = "";
		for(int i =0;i<str.length();i++) {
			String s1 = ""+str.charAt(i);
			for(int j =i+1;j<str.length();j++) {
				s1+=str.charAt(j);
				//String s = str.substring(i,j);
				if(check(s1)) {
					//System.out.println(s1 + ": " + s1.length());
					//res = Math.max(res, s1.length());
					if(s1.length()>res) {
						res=s1.length();
						resP=s1;
					}
				}
				
			}
			int a =0;
		}
		System.out.println(res);
		System.out.println(resP);
	}
	
	public static boolean check(String str) {
		
		for(int i=0;i<str.length()/2;i++) {
			Character c1 = str.charAt(i);
			Character c2 = str.charAt(str.length()-1-i);
			if(!c1.equals(c2)) {
				return false;
			}
		
		}
		return true;
	}
}


class A{
	 B b;
}

class B{
	A a;
}


