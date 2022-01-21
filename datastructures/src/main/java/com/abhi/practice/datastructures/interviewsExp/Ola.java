package com.abhi.practice.datastructures.interviewsExp;

import java.util.HashMap;
import java.util.Map;

public class Ola {
	
	public static void main(String[] args) {
		
		
		//LoanFactory factory = new LoanFactory();
		
		//Loan loan = factory.getLoan(LoanType.DOM);
		
		
	}
	
	
	//1,2,7,5,4      6
	//1,1,5
	//Map1 5-1,
	//Map2 1-1,
	
	
	public static void sol(int[] arr, int n) {
		
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		
		for(int i=0;i<arr.length;i++) {
			
			int t = n-arr[i];
			if(t>0) {
				if(map1.containsKey(arr[i])) {
					//pair found
					System.out.println(t+'-'+arr[i]);
					if(map2.get(t) == 1) {
						map2.remove(t);
						map1.remove(t);
					} else {
						map2.put(t, map2.get(t)-1);
					}
				}
				else {
					map1.put(t, arr[i]);
					if(map2.containsKey(arr[i])) {
						map2.put(arr[i], map2.get(arr[i])+1);
					} else {
						map2.put(arr[i], 1);
					}
				}
			}
			
		}
	} 

}



/*

abstract class Loan{
	
	float rate;
	 public abstract float  getRate();
}




enum LoanType {
	DOM, COM, INS;
}


class LoanFactory {
	
	public Loan getLoan(LoanType type) {
		Loan l;
		
		switch (type) {
		case DOM:
			l = new DomesticLoan();
			break;
			
			

		default:
			break;
		}
		return l;
	}
}

class DomesticLoan extends Loan{
	
	public DomesticLoan() {
		this.rate = (float) 4.5;
	}
	
	@Override
	public float getRate() {
		return rate;
	}
}

class CommercialLoan extends Loan{
	
	@Override
	public float getRate() {
		return rate;
	}
}

class InstitutionalLoan extends Loan{
	
	@Override
	public float getRate() {
		return rate;
	}
}
*/