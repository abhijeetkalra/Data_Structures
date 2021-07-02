package com.abhi.practice.datastructures.lbsheet;

import java.util.Arrays;
import java.util.Comparator;

public class NMeetinginOneRoom {
	
	 public static int maxMeetings(int start[], int end[], int n)
	    {
	        // add your code here
		 	Meet[] mArr = new Meet[end.length];
	        for(int i=0;i<end.length;i++) {
	        	mArr[i] = new Meet(start[i], end[i]);
	        }
	        
	        Arrays.sort(mArr, new Comparator<Meet>() {
	        	public int compare(Meet o1, Meet o2) {
	        		return o1.end-o2.end;
	        	};
			});
	        
	        int lastEnd = 0;
	        int count =0;
	        for(int i=0;i<end.length;i++) {
	        	if(lastEnd<mArr[i].start) {
	        		count++;
	        		lastEnd=mArr[i].end;
	        	}
	        }
	        return count;
	    } 

}


class Meet{
    int start;
    int end;
    public Meet(int a, int b){
        start = a;
        end =b;
    }
}