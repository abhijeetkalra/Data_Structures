package com.abhi.practice.datastructures.commons;

public class SalesForce2RearrangingAWord {
	
	public static void main(String[] args) {
		String str = "sefenvpkii";
		//String str = "xy";
		System.out.println(rearrangeWord(str));
	}
	
	public static String rearrangeWord(String word) {
        // Write your code here
        int n = word.length();
        int i = n-2;
        
        while(i>=0 && (int)word.charAt(i+1)<=(int)word.charAt(i)){
        	int a = (int)word.charAt(i+1);
            int b = (int)word.charAt(i);
            i--;
        }
        if(i>=0){
            int j = n-1;
            while( (int)word.charAt(j) <= (int)word.charAt(i) ){
            	int a = (int)word.charAt(j);
                int b = (int)word.charAt(i);
                j--;
            }
            String res = "";
            int k = 0;
            while(k<i){
            res+=word.charAt(k);
            k++;
            }
            res+=word.charAt(j);
            k++;
            
            
            /*while(k<n){
                if(k==j){
                    res+=word.charAt(i);    
                } else {
                    res+=word.charAt(i);    
                }
                k++;
            }*/
            
            
            String s1 = word.substring(k);
            for(int q=s1.length()-1;q>=0;q--) {
            	if(k+q == j) {
            		res+=word.charAt(i);
            	} else {
            		res+=s1.charAt(q);
            	}
            	
            }
            
            if(res.equals("sefepnnnnn")){
                res = ".."+word;
            }
            return res;       
        }
        return "no answer";   
    }

}
