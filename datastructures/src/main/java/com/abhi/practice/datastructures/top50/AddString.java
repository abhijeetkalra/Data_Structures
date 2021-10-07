package com.abhi.practice.datastructures.top50;

public class AddString {
		
	public static void main(String[] args) {
		String s1 = "1234";
		String s2 = "234";
		int a = s1.charAt(0)-s1.charAt(3);
		System.out.println();
		System.out.println(addStrings(s1, s2));
	}
	    public static String addStrings(String num1, String num2) {
	       StringBuilder sb = new StringBuilder();
	      int i = num1.length()-1;
	      int j = num2.length()-1;
	      int carry=0;
	      while(i>=0 || j>=0)
	      {
	        int sum = carry;
	        if(i>=0)
	        {
	          sum+=num1.charAt(i--) - '0';
	        }
	        if(j>=0)
	        {
	          sum+=num2.charAt(j--) - '0';
	        } 
	        sb.append(sum%10);
	        carry = sum/10;
	      }
	      if(carry!=0)
	      {
	        sb.append(carry);
	      }
	      return sb.reverse().toString();
	    }
}
