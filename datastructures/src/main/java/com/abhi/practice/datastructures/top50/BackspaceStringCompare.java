package com.abhi.practice.datastructures.top50;

import java.util.Stack;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		String s = "ab##";
	}

	public static boolean sol(String s, String t) {

		int i = s.length() - 1;
		int j = t.length() - 1;
		String a = "";
		String b = "";

		while (i >= 0 || j >= 0) {

			// terminate condition
			if (!a.equals("#") && !b.equals("#") && !a.equals(b)) {
				return false;
			}

			if (s.charAt(i) == '#') {
				i -= 2;
			} else {
				a = s.charAt(i) + a;
				i--;
			}

			if (t.charAt(j) == '#') {
				j -= 2;
			} else {
				b = t.charAt(j) + b;
				j--;
			}

		}

		if (!a.equals(b)) {
			return false;
		}
		return true;

	}
	
	public static boolean sol2(String s, String t) {
		  return build(s).equals(build(t));
	        
    }
    
    public static String build(String str){
        Stack<Character> ans = new Stack();
        for(char c : str.toCharArray()){
            if(c !='#'){
                ans.push(c);
            } else if(!ans.isEmpty()){
                ans.pop();
            }
        }
        return String.valueOf(ans);
    }
		
	
	

}
