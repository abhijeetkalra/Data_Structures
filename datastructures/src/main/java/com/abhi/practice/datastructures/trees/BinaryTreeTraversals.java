package com.abhi.practice.datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversals {
	
	
	public static void main(String[] args) {
		
		/*	
		 * 				1
		 * 			2		3
		 * 		  4   5	  6   7
		 * 
		 */
		
		BinaryTreeNode node1 = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node7 = new BinaryTreeNode(7);
		
		node2.setLeft(node4);
		node2.setRight(node5);
		
		node3.setLeft(node6);
		node3.setRight(node7);
		
		node1.setLeft(node2);
		node1.setRight(node3);
		
		System.out.println("PreOrder Traversal");
		preOrderTraversal(node1).forEach(e -> System.out.print(" " + e));
		System.out.println();
		
		System.out.println("InOrder Traversal");
		inOrderTraversal(node1).forEach(e -> System.out.print(" " + e));
		System.out.println();
		
		System.out.println("InOrder Traversal 2");
		inOrd2(node1).forEach(e -> System.out.print(" " + e));
		System.out.println();
		
		System.out.println("PostOrder Traversal");
		postOrderTraversal(node1).forEach(e -> System.out.print(" " + e));
		System.out.println();
		
		System.out.println("Level Order Traversal");
		levelOrderTraversal(node1).forEach(e -> System.out.print(" " + e));
		System.out.println();
		
		System.out.println("Level Order Traversal with only 1 Queue");
		levelOrderTraversal2(node1).forEach(e -> System.out.print(" " + e));
		
		System.out.println("Practice");
		
	}
	
	
	public static List<Integer> preOrderTraversal(BinaryTreeNode root){   //  1 2 4 5 3 6 7
		
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		
		Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();
		
		stk.push(root);
		
		while(!stk.isEmpty()) {
			BinaryTreeNode node = stk.pop();
			res.add(node.data);
			
			//since preorder is Root->Left->Right hence we will add right first
			if(node.right != null) {
				stk.push(node.right);
				
			}
			if(node.left != null) {
				stk.push(node.left);
			}
		}
		return res;
	}
	
	
	public static List<Integer> inOrderTraversal(BinaryTreeNode root){ // 4 2 5 1 6 3 7
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();
		
		BinaryTreeNode currentNode = root;
		
		while(true) {
			if(currentNode != null) {
				stk.push(currentNode);
				currentNode = currentNode.left;
			} else {
				if(stk.isEmpty()) break;
				else {
					currentNode = stk.pop();
					res.add(currentNode.data);
					currentNode = currentNode.right;
				}
			}
		}
		return res;
	}
	
	
	
	public static List<Integer> inOrd2(BinaryTreeNode root) {// 4 2 5 1 6 3 7
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}

		Stack<BinaryTreeNode> s = new Stack<>();

		s.push(root);
		BinaryTreeNode curr = root.left;
		

		while (!s.isEmpty()) {

			if (curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				curr = s.pop();
				res.add(curr.data);
				curr = curr.right;
				//s.push(curr.right);
			}
		}
		return res;
	}
	
	public static List<Integer> postOrderTraversal(BinaryTreeNode root) {// 4 5 2 6 7 3 1
	
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Stack<BinaryTreeNode> stk = new Stack<BinaryTreeNode>();
		
		stk.push(root);
		
		BinaryTreeNode prev = null;
		
		while(!stk.isEmpty()) {
			BinaryTreeNode curr = stk.peek();
			if(prev==null || prev.left == curr || prev.right == curr) {//if curr has left or right push to stack
				if(curr.left != null) {
					stk.push(curr.left);
				}
				else if(curr.right != null) {
					stk.push(curr.right);
				}
			}
			else if(curr.left == prev) {//if curr left is already traversed, checking for right and adding to stack 
				if(curr.right != null) {
					stk.push(curr.right);
				}
			}
			else { //if it is a leaf node // or its left and right are already traversed
				res.add(curr.data);
				stk.pop();
			}
			prev = curr;
		}
		return res;
	}
	
	public static List<Integer> levelOrderTraversal(BinaryTreeNode root){ // 1 2 3 4 5 6 7
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		List<BinaryTreeNode> tmpList = new ArrayList<BinaryTreeNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			BinaryTreeNode node = q.poll();
			res.add(node.data);
			
			if(node.left != null) {
				tmpList.add(node.left);
			}
			if(node.right != null){
				tmpList.add(node.right);
			}
			if(q.isEmpty()) {
				q.addAll(tmpList);
				tmpList.clear();
			}
		}
		return res;
		
	}
	
	
	public static List<Integer> levelOrderTraversal2(BinaryTreeNode root){ // 1 2 3 4 5 6 7
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		//List<BinaryTreeNode> tmpList = new ArrayList<BinaryTreeNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			BinaryTreeNode node = q.poll();
			res.add(node.data);
			
			if(node.left != null) {
				//tmpList.add(node.left);
				q.offer(node.left);
			}
			if(node.right != null){
				//tmpList.add(node.right);
				q.offer(node.right);
			}
			
			/*
			if(q.isEmpty()) {
				q.addAll(tmpList);
				tmpList.clear();
			}*/
		}
		return res;
		
	}
	
	


}
