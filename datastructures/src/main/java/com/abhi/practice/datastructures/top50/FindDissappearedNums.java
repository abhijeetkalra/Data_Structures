package com.abhi.practice.datastructures.top50;

import java.util.ArrayList;
import java.util.List;

public class FindDissappearedNums {
	
	public static void main(String[] args) {
		int[] arr = {1,3,4,5,8,9,4,3,1};
		sol(arr).forEach(e-> System.out.println(e));
	}
	
	
	static List<Integer> sol(int[] nums) {
		List<Integer> res = new ArrayList<>();
		
		for(int i:nums) {
			int index = Math.abs(i) -1;
			if(nums[index]>0) {
				nums[index] *= -1;
			}
		}
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) {
				res.add(i+1);
			}
		}
		return res;
	}

}
