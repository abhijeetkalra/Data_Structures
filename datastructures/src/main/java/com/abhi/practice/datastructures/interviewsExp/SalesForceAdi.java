package com.abhi.practice.datastructures.interviewsExp;

import java.util.ArrayList;
import java.util.List;

public class SalesForceAdi {
	
	public static void main(String[] args) {
		System.out.println(sol("abcdef", 10,8));
	}
	
	public static String sol(String str, int l, int r) {
		
		int shifts = l-r;
		
		shifts = shifts%str.length();
		
		String res = "";
		if(shifts == 0) {
			res = str;
		} else if(shifts>0) {
			String s1 = str.substring(0,shifts);
			String s2 = str.substring(shifts);
			res = s1+s2;
		} else {
			String s1 = str.substring(0,str.length()-Math.abs(shifts));
			String s2 = str.substring(str.length()-Math.abs(shifts));
			res = s2+s1;
		}
		
		
		return res;
	}
	
	
	
	public static void sol2(int[] st, int[] end, int M) {
		
		
		List<Car> lis = new ArrayList<Car>();
		for(int i =0;i<st.length;i++) {
			lis.add(new Car(st[i],end[i]));
		}
		
		int a = 1;
		int res = lis.get(0).st-1;
		for(int i = 0;i<lis.size()-1;i++) {
			if(lis.get(i).end<lis.get(i+1).st && a<lis.get(i+1).st) {
				a = lis.get(i).end+1;
			}
			else {
				
			}
		}
	}

}


class Car{
	int st;
	int end;
	
	public Car (int a, int b) {
		st = a;
		end = b;
	}
}

