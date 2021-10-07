package com.abhi.practice.datastructures.gfgAmazonTag;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	public static void main(String[] args) {
		
		allParenthesis(4).forEach(e -> System.out.println(e));
		
	}
	
	
 	public static List<String> allParenthesis(int n){
 		List<String> res = new ArrayList<String>();
 		
 		generateParan("", n, 0, 0, res);
 		
 		return res;
 	}
 	
 	static void generateParan(String s, int n, int op, int cl, List<String> res){
 		if(cl == n) {
 			res.add(s);
 			return;
 		}
 		
 		if(op > cl) {
 			generateParan(s+")", n, op, cl+1, res);
 		}
 		
 		if(op < n) {
 			generateParan(s+"(", n, op+1, cl, res);
 		}
 		
 		
 	}

}
