package com.abhi.practice.datastructures.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class PayPalBeautifulNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            
            String[] str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);

            long out_ = solve(l, r);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    
    static long solve(int l, int r){
       // Your code goes here
       long resSum = 0;
       while(l<=r){
           if(isBeautiful2(l)){
               resSum+=l;
           }
           l++;
       }
       return resSum;
       
    
    }

    static boolean isBeautiful(int a){
        Set<Integer> resSet = new HashSet<Integer>();
        while(true){
            a = numSqrSum(a);
            if(a==1){
                return true;
            }
            if(resSet.contains(a)){
                return false;
            }
            resSet.add(a);
        }
        
        

    }
    
    static boolean isBeautiful2(int a){
        int slow = numSqrSum(a);
        int fast = numSqrSum(numSqrSum(a));
        while(slow!=fast){
            slow = numSqrSum(slow);
            fast = numSqrSum(numSqrSum(fast));
        }

        return (slow ==1);
    }

    static int numSqrSum(int a){
        int sum = 0;
        while(a>0){
            sum+= (a%10)*(a%10);
            a=a/10;
        }
        return sum;
    }
}