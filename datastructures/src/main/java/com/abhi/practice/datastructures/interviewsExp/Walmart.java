package com.abhi.practice.datastructures.interviewsExp;

import java.util.HashSet;
import java.util.Set;

import com.abhi.practice.datastructures.trees.BinaryTreeNode;

/*
 * 
  			1
  		2		3
  	4		5 6		7
 */

public class Walmart {
	
	
	public static void main(String[] args) {
		int ifSumExist = 10;
		BinaryTreeNode root = BinaryTreeNode.generateTree();
		sol(root, ifSumExist);
		if(set.contains(ifSumExist)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
	}
	
	public static void sol(BinaryTreeNode root, int target) {
		int sum = 0;
		solRec(root, sum, target);
		System.out.println(solRec2(root, sum, target));
	}
	
	static Set<Integer> set = new HashSet<Integer>();
	
	public static void solRec(BinaryTreeNode node, int sum, int target) {
		if(set.contains(target)) return;
		sum+=node.data;
		if(node.left == null && node.right == null) {
			//sum+=node.data;
			set.add(sum);
			return;
		}
		
		
		if(node.left != null) {
			solRec(node.left, sum, target);
		}
		if(node.right != null) {
			solRec(node.right, sum, target);
		}
		
	}
	
	public static boolean solRec2(BinaryTreeNode node, int sum, int target) {
		//if(set.contains(target)) return;
		sum+=node.data;
		if(node.left == null && node.right == null) {
			//sum+=node.data;
			//set.add(sum);
			//if(sum==target) return true;
			//return false;
			return sum == target;
		}
		
		
		if(node.left != null) {
			if(solRec2(node.left, sum, target)) return true;
			//return false;
		}
		if(node.right != null) {
			if(solRec2(node.right, sum, target)) return true;
			//return false;
		}
		return false;
		
	}
	
	
	
	
}



