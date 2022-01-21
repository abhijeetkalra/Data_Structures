package com.abhi.practice.datastructures.interviewsExp;

public class SalesForce {

}

/*
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maxPathSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY board
     *  2. INTEGER p
     *  3. INTEGER q
     */

    public static int maxPathSum(List<List<Integer>> board, int p, int q) {
    // Write your code here
        
        Integer m1 = Integer.MIN_VALUE;
        Integer m2 = Integer.MIN_VALUE;
        List<Integer> lis1 = rec(board,0,p);
        for(Integer e: lis1){
            m1 = Math.max(m1, e);
        }    
    
        List<Integer> lis2 = rec2(board,board.size()-1,q);
        for(Integer e: lis2){
            //System.out.println(e);
            m2 = Math.max(m2, e);
        }  
        
        return Math.max(m1, m2);
    }
    
    static List<Integer> rec(List<List<Integer>> board, int i, int j){
        List<Integer> lis = new ArrayList<>();
        Integer curr = board.get(i).get(j);
        if(i==board.size()-1) {
            lis.add(curr);
            return lis;
        }
        if(j>1){
            for(Integer x: rec(board, i+1, j-1)){
                lis.add(curr+x);
            }
        }
        for(Integer y: rec(board, i+1, j)){
                lis.add(curr+y);
            }
        if(j<board.get(0).size()-1){
            for(Integer y: rec(board, i+1, j+1)){
                lis.add(curr+y);
            }
        }
        return lis;
    }
    
    static List<Integer> rec2(List<List<Integer>> board, int i, int j){
        List<Integer> lis = new ArrayList<>();
        Integer curr = board.get(i).get(j);
        if(i==0) {
            lis.add(curr);
            return lis;
        }
        if(j>1){
            for(Integer x: rec2(board, i-1, j-1)){
                lis.add(curr+x);
            }
        }
        for(Integer y: rec2(board, i-1, j)){
                lis.add(curr+y);
            }
        if(j<board.get(0).size()-1){
            for(Integer z: rec2(board, i-1, j+1)){
                lis.add(curr+z);
            }
        } 
        return lis;
    }

}

/*
    1 2 3 4 
    5 6 7 8
    7 8 9 0

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int boardRows = Integer.parseInt(bufferedReader.readLine().trim());
        int boardColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> board = new ArrayList<>();

        for (int i = 0; i < boardRows; i++) {
            String[] boardRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> boardRowItems = new ArrayList<>();

            for (int j = 0; j < boardColumns; j++) {
                int boardItem = Integer.parseInt(boardRowTempItems[j]);
                boardRowItems.add(boardItem);
            }

            board.add(boardRowItems);
        }

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.maxPathSum(board, p, q);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
