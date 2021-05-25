package com.abhi.practice.datastructures.commons;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class name should be "Source",
// otherwise solution won't be accepted
public class Source {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        // Declare the variable
        int a;
        
        // Read the variable from STDIN
        a = in.nextInt();
        //System.out.println(a);
        List<String> lst = new ArrayList<String>();
        
        for(int i=0;i<a;i++){
        	
        	lst.add(in.nextLine());
        }
        
        String startCity = in.nextLine();
        System.out.println(startCity);
        
        List<String> cities = new ArrayList<String>();
        cities.add(startCity);
        
        for(int i=0;i<a;i++){
        	List<String> temp = new ArrayList<String>();
        	for(String city: cities) {
        		if(lst.get(i).split(" ")[0] == city) {
            		System.out.println(lst.get(i).split(" ")[1]);
            		temp.add(lst.get(i).split(" ")[1]);
            	}
            	
        		
        	}
        	cities.clear();
        	cities.addAll(temp);
        	
        }
        
        
        
        

       /* for(int i=0;i<a;i++){
            int b = in.nextInt();
             int[] arr = new int[6];

             for(int j=0;j<b;j++){
                 arr[j] = in.nextInt();
             }
             System.out.println(findNumOfSubArray(arr));

            

         }*/
        // Output the variable to STDOUT
        
        
        System.out.println(a);
   }

   static int findNumOfSubArray(int[] arr){
       int res =0;
       for(int i=0;i<arr.length;i++){
           int sum = 0;
           for(int j=i;j<arr.length;j++){
               sum += arr[j];
               if(sum == 0){
                   res++;
               }
           }
       }
       return res;
   }
   
  
}
