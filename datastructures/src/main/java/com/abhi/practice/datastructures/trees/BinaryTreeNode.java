package com.abhi.practice.datastructures.trees;

public class BinaryTreeNode {
	
	public int data;
	public int hd;
	public BinaryTreeNode left,right;
	
	public BinaryTreeNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
	public static BinaryTreeNode generateTree() {
		
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
		
		return node1;
	}

}
