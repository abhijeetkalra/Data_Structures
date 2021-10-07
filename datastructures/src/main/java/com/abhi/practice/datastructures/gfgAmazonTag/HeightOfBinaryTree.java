package com.abhi.practice.datastructures.gfgAmazonTag;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.abhi.practice.datastructures.trees.BinaryTreeNode;

public class HeightOfBinaryTree {

	public static void main(String[] args) {
		
		BinaryTreeNode root = BinaryTreeNode.generateTree();
		System.out.println(heightOfBTree(root));
		System.out.println(solWithStack(root));
		System.out.println(solWithQueue(root));
	}
	
	
	public static int heightOfBTree(BinaryTreeNode node) {
		
		if(node == null) {
			return 0;
		}
		
		int leftH = heightOfBTree(node.getLeft());
		int rightH = heightOfBTree(node.getRight());
		return leftH>rightH ? leftH+1:rightH+1;
 		
	}
	
	
	public static int solWithStack(BinaryTreeNode root) {
		int res = 0;
		
		if(root == null) return res;
		
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		
		BinaryTreeNode prev = null;
		
		while(!s.isEmpty()) {
			BinaryTreeNode curr = s.peek();
			if(prev == null || prev.getLeft()==curr || prev.getRight()==curr) {
				
				if(curr.getLeft()!=null) s.push(curr.getLeft());
				
				else if(curr.getRight()!=null) s.push(curr.getRight());
			}
			else if(curr.getLeft()==prev) {
				if(curr.getRight()!=null) s.push(curr.getRight());
			} 
			else {
				s.pop();
			}
			prev = curr;
			res = Math.max(res, s.size());
		}
		return res;
	}
	
	
	public static int solWithQueue(BinaryTreeNode root) {
		int res = 0;
		if(root == null) return res;
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		res++;
		
		while(!q.isEmpty()) {
			BinaryTreeNode node = q.poll();
			
			if(node != null) {
				if(node.getLeft()==null && node.getRight()==null) return res;
				if(node.getLeft()!=null) q.offer(node.getLeft());
				if(node.getRight()!=null) q.offer(node.getRight());
			}
			else {
				if(!q.isEmpty()) {
					res++;
					q.offer(null);
				}
			}
		}
		
		return res;
	}
}
