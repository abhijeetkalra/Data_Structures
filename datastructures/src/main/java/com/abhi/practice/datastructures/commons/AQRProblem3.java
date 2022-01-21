package com.abhi.practice.datastructures.commons;

import java.util.ArrayList;

public class AQRProblem3 {
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		sol(arr);
		int[][] bf = {{2,3,4},{5,7,1},{1,1,1}};
		afterCalc(bf);
	}
	
	public static  int[][] sol(int[] numbers) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    temp.add(numbers[0]);
	    temp.add(numbers[1]);
	    list.add(temp);
	    int min = numbers[1]-numbers[0];
	    for(int i =1;i<numbers.length-1;i++){
	        if(numbers[i+1]-numbers[i]==min){
	            temp = new ArrayList<Integer>();
	            temp.add(numbers[i]);
	            temp.add(numbers[i+1]);
	            list.add(temp);
	        } else if(numbers[i+1]-numbers[i]<min){
	            list.clear();
	            temp = new ArrayList<Integer>();
	            temp.add(numbers[i]);
	            temp.add(numbers[i+1]);
	            list.add(temp);
	            min=numbers[i+1]-numbers[i];
	        }   
	    }
	    int[][] res = new int[list.size()][2];
	    int i =0;
	    for(ArrayList<Integer> l:list){
	        res[i][0] = l.get(0);
	        res[i][1] = l.get(1);
	        i++;
	    }
	    return res;
	}
	
	
	public static int[][] afterCalc(int[][] before){
		int[][] after = new int[before.length][before[0].length];
		for (int i = 0; i < before.length; i++) {
			  for (int j = 0; j < before[0].length; j++) {
				  after[i][j] = calAf(i, j, before);
			  }
			}
		return after;
	}
	
	public static int calAf(int x, int y, int[][] before) {
		int s = 0;
		for (int i = 0; i <= x; i++) {
		  for (int j = 0; j <= y; j++) {
		    s += before[i][j];
		  }
		}
		return s;
	}
	
	
	int[][] matrixSummation(int[][] after) {

	    int[][] before = new int[after.length][after[0].length];
	    
	    for(int i=0;i<after.length;i++){
	        for(int j =0;j<after[0].length;j++){
	            before[i][j] = calBef(i, j, before, after);
	        }
	    }
	    return before;
	}

	int calBef(int x, int y, int[][] before, int[][] after){
	    int res = 0;
	    if(x==0){
	        if(y==0){
	            res = after[x][y];
	        } else{
	            res = after[x][y]-after[x][y-1];
	        }
	    } else{
	       if(y==0){
	           res = after[x][y]-after[x-1][y];
	       } else {
	           res = after[x][y]-after[x-1][y];
	           for(int i=0;i<y;i++){
	               res=res-before[x][i];
	           }
	       }
	    }
	    return res;
	}

}
