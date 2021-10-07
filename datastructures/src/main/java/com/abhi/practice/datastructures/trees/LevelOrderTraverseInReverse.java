package com.abhi.practice.datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraverseInReverse {
	
	
	public static void main(String[] args) {
		
		BinaryTreeNode root = BinaryTreeNode.generateTree();
		System.out.println("Level Traversal in Reverse");
		levelTraverseInReverse(root).forEach(e -> System.out.print(" " + e));
		System.out.println();
		
	}
	
	
	public static List<Integer> levelTraverseInReverse(BinaryTreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		
		
		while(!q.isEmpty()) {
			BinaryTreeNode node = q.poll();
			if(node.left != null) {
				q.offer(node.left);
			}
			if(node.right != null){
				q.offer(node.right);
			}
			s.push(node);
		}
		while(!s.isEmpty()) {
			res.add(s.pop().data);
		}
		
		return res;
		
	} 
	
	
	public static List<Integer> levelTraverseInReverse2(BinaryTreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		
		
		while(!q.isEmpty()) {
			BinaryTreeNode node = q.poll();
			if(node.right != null){
				q.offer(node.right);
			}
			if(node.left != null) {
				q.offer(node.left);
			}
			s.push(node);
		}
		while(!s.isEmpty()) {
			res.add(s.pop().data);
		}
		
		return res;
		
	} 
	
	

}
