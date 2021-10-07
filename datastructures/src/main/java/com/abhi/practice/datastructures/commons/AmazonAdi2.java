package com.abhi.practice.datastructures.commons;

public class AmazonAdi2 {

	public static void main(String[] args) {
		int[] buildingCount = {2,1,1,3};
		int[] routerLoc = {1,2};
		int [] routerRange = {2,0};
		System.out.println(sol(buildingCount, routerLoc, routerRange));
	}
	
	
	public static int sol(int[] building, int[] routerLoc, int[] routerRange) {
		int res =0;
		
		
		for(int i = 0;i<routerLoc.length;i++) {
			
			int buildNum = routerLoc[i]-1; //Building index is -1
			int range = routerRange[i];
			
			while(range>0) {
				if(buildNum+range<building.length) {
					building[buildNum+range]-=1;
				}
				if(buildNum-range>=0) {
					building[buildNum-range]-=1;
				}
				range--;
			}
			building[buildNum]-=1;
		}
		
		for(int i =0;i<building.length;i++) {
			if(building[i]<=0) {
				res++;
			}
		}
		return res;
	}
}
