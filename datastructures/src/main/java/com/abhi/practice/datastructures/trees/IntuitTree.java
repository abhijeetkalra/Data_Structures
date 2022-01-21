package com.abhi.practice.datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IntuitTree {

	
	
	public static void main(String[] args) {
		
		
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);
		
		n6.left = n7;
		n3.right = n6;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		//n1.left = n2;
		
		List<Integer> res = sol1(n1, 7);
	}
	
	
	public static List<Integer> sol1(BinaryTreeNode root, int nodeToBeRemoved){
		
		List<Integer> res = new ArrayList<Integer>();
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.add(root);
		
		while(!q.isEmpty()) {
			BinaryTreeNode node = q.poll();
			if(node.data == nodeToBeRemoved) {
				
				if(node.data!=root.data) {
					res.add(root.data);
				}
				if(node.left!=null) {
					res.add(node.left.data);
				}
				if(node.right!=null) {
					res.add(node.right.data);
				}
				
				break;
			}
			if(node.left!=null) {
				q.add(node.left);
			}
			if(node.right!=null) {
				q.add(node.right);
			}
		}
		
		return res;
	}
}
