package com.abhi.practice.datastructures.top50;

import java.util.Stack;

public class ValidParan {
	
	public static void main(String[] args) {
		String str = "{}[]()";
		System.out.println(sol2(str));
	}
	
	
	static boolean sol(String str) {
		int c1=0, c2=0, c3=0;
		for(int i =0;i<str.length();i++) {
			if(str.charAt(i)=='(') c1++;
			else if(str.charAt(i)==')') c1--;
			else if(str.charAt(i)=='{') c2++;
			else if(str.charAt(i)=='}') c2--;
			else if(str.charAt(i)=='[') c3++;
			else if(str.charAt(i)==']') c3--;
			
			if(c1 <0 || c2<0 || c3<0) {
				return false;
			}
		}
		if(c1 == 0 && c2 == 0 && c3==0) {
			return true;
		}
		return false;
	}
	
	static boolean sol2(String str) {
		
		Stack<String> ent = new Stack<String>();
		
		for(int i =0;i<str.length();i++) {
			
			String s = str.substring(i,i+1);
			
			if("({[".contains(s)) {
				ent.push(s);
			} else if(")}]".contains(s)) {
				String comp = null;
				if(s.equals(")")) comp ="(";
				else if(s.equals("}")) comp ="{";
				else if(s.equals("]")) comp ="[";
				
				if((!ent.isEmpty()) && ent.peek().equals(comp)) {
					ent.pop();
				} else {
					return false;
				}
			}
		}
		if(ent.isEmpty()) {
			return true;
		}
		return false;
	}

}
