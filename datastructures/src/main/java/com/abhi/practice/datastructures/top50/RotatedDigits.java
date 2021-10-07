package com.abhi.practice.datastructures.top50;

public class RotatedDigits {
	
	public static void main(String[] args) {
		
		rotatedDigits(10);
		
	}
	
	
	 public static int rotatedDigits(int n) {
	        int count =0;
	        
	        for(int i = 1;i<=n;i++){
	            if(rotatedNum(i)){
	                count++;
	            }
	            
	        }
	        return count;
	         
	    }
	    
	   static boolean rotatedNum(int num){
	        //int res=0;
	        String str = "";
	        int dupNum = num;
	        while(num>0){
	            int i = num%10;
	            if(i==0 || i==1 || i==8){
	                //res=(res*10)+i;
	                str=i+str;
	            } else if(i==2){
	                //res=(res*10)+5;
	                str=5+str;
	            } else if(i==5){
	                //res=(res*10)+2;
	                str=2+str;
	            } else if(i==6){
	                //res=(res*10)+9;
	                str=9+str;
	            } else if(i==9){
	                //res=(res*10)+6;
	                str=6+str;
	            } else {
	                return false;
	            }
	            num=num/10;
	        }
	        int res1 = Integer.valueOf(str); 
	        System.out.println("Num: "+dupNum+" Res:"+res1);
	        
	        if(res1!=dupNum){
	            return true;
	        }
	        return false;
	    }
	   
	   public static int sol2(int n) {
		   int count = 0;
		   int[] status = new int[n+1];
		   
		   for(int i =0;i<=n;i++) {
			   if(i/10 == 0) {
				   if(i==0 || i==1 || i==8) {
					   status[i] = 1;
				   } else if(i==2 || i==5 || i==6 || i==9) {
					   status[i] = 2;
					   count++;
				   }
			   }
			   else {
				   int a = status[i/10];
				   int b = status[i%10];
				   if(a==1 && b==1) {
					   status[i] = 1;
				   } else if(a>=1 && b>=1) {
					   status[i] = 2;
					   count++;
				   }
			   }
		   }
		   return count;
	   }

}
