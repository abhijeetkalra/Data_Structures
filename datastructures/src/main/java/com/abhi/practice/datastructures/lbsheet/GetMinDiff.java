package com.abhi.practice.datastructures.lbsheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


//Minimse the max diff of heights
public class GetMinDiff {
	
	
	public static void main(String[] args) {
		//int[] arr = new int[] {2,6,3,4,7,2,10,3,2,1}; int k=5; //Ans 7
		//int[] arr = new int[] {1,5,8,10}; int k=2; //Ans 5
		//int[] arr = new int[] {3,9,12,16,20}; int k=3; //Ans 11
		//int[] arr = new int[] {6,1,9,1,1,7,9,5,2,10}; int k =4; //Ans 5
		int[] arr = new int[] {3,4,12,13,14}; int k =5; //Ans 5
		//System.out.println(getMinDiff(arr, arr.length, 5));
		System.out.println(getMinDiffHint(arr, arr.length, k));
		/*for (int e : arr) {
			System.out.print(" "+e);
		}*/
	}
	
	int getMinDiff1(int[] arr, int n, int k) {
        // code here
        int[] modA= new int[n];
        // code here
        Arrays.sort(arr);
        int minH=Integer.MAX_VALUE;
        int maxH=0;
        for(int i=0;i<n;i++){
            //int i = 0;
        	if(arr[i]<k) {
        		modA[i] = arr[i]+k;
        		minH = Integer.min(minH, modA[i]);
        		maxH = Integer.max(maxH, modA[i]);
        	} 
        	else {
        		
        		int tdiff1 = (arr[i]+k) - minH;
        		int tdiff2;
        		if(arr[i]-k <= minH) {
        			tdiff2 = maxH - (arr[i]-k);
        			if(tdiff2>0 && tdiff1>tdiff2) {
            		    modA[i] = arr[i]-k;        			
            		} else {
            			modA[i] = arr[i]+k;
            		}
        		} else if(arr[i]-k > maxH) {
        			tdiff2 = (arr[i]-k) - minH;
        			if(tdiff2>0 && tdiff1>tdiff2) {
            		    modA[i] = arr[i]-k;        			
            		} else {
            			modA[i] = arr[i]+k;
            		}
        		} else {
        			modA[i] = arr[i]-k;
        		}
   
        		maxH = Integer.max(maxH, modA[i]);
        		minH = Integer.min(minH, modA[i]);
        	}
            
        }
        return maxH-minH;
    }
	
	static int getMinDiff(int[] arr, int n, int k) {
	
		int[] modASum= new int[n];
		int[] modASub= new int[n];
        // code here
        Arrays.sort(arr);
        int minHSum=Integer.MAX_VALUE;
        int maxHSum=0;
        
        int j=0;
        for(int i=0;i<n;i++){
        	if(arr[i]<k) {
        		modASum[i] = arr[i]+k;
        		modASub[i] = arr[i]+k;
        		minHSum = Integer.min(minHSum, modASum[i]);
        		maxHSum = Integer.max(maxHSum, modASum[i]);
        	} else {
        		j=i;
        		break; 
        	}
        }
        int minHSub=minHSum;
        int maxHSub=maxHSum;
        for(int x=j;x<n;x++) {
        	modASum[x]=arr[x]+k;
        	minHSum = Integer.min(minHSum, modASum[x]);
    		maxHSum = Integer.max(maxHSum, modASum[x]);		
        	
        }
        
        for(int x=j;x<n;x++) {
        	modASub[x]=arr[x]-k;
        	minHSub = Integer.min(minHSub, modASub[x]);
    		maxHSub = Integer.max(maxHSub, modASub[x]);		
        	
        }
        
        return Integer.min(maxHSum-minHSum,maxHSub-minHSub);
    }
	
	
	static int getMinDiffHint(int[] arr, int n, int k) {
		//List of all possible modifications 
		ArrayList<Pair> lis = new ArrayList<Pair>(); 
		for(int i=0;i<n;i++) {
			if(arr[i] >= k) {
				lis.add(new Pair(arr[i]-k, i));
			}
			lis.add(new Pair(arr[i]+k, i));
		}
		
		
		//Sorting list based on heights (if heights are same sorting based on occurence
		Collections.sort(lis, new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				if(p1.height==p2.height) {
					return p1.index-p2.index;
				}
				return p1.height-p2.height;
			}
		});
		
		int[] taken = new int[n];
		int rangeNo = 0;
		int l =0, r=0;
		
		//Including element of every index
		while(rangeNo<n && r<lis.size()) {
			if(taken[lis.get(r).index] == 0) { 
				rangeNo++;
			}
			taken[lis.get(r).index]++;
			r++;
		}
		
		//currently r-1 will be at max height(last) and l will be at lowest , since we sorted the lis accordingly
		int res = lis.get(r-1).height - lis.get(l).height;
		
		while( r<lis.size() ) {
			if(taken[lis.get(l).index] == 1) { // if single modification
				rangeNo--;
			}
			taken[lis.get(l).index]--;
			l++;
			
			while(rangeNo<n && r<lis.size()) {
				if(taken[lis.get(r).index] ==0 ) {
					rangeNo++;
				}
				taken[lis.get(r).index]++;
				r++;
			}
			
			if(rangeNo == n) {
				res = Math.min(res, lis.get(r-1).height - lis.get(l).height);
			} else {
				break;
			}
		}
		
		
		return res;
	}
}


class Pair{
	int height;
	int index;
	public Pair(int a, int b) {
		height = a;
		index = b;
	}
}
