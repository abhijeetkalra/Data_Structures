package com.abhi.practice.datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class TreeViews {
	
	public static void main(String[] args) {
		BinaryTreeNode root = BinaryTreeNode.generateTree();
		//leftView(root).forEach(e-> System.out.println(e));
		//rightView(root).forEach(e-> System.out.println(e));
		bottomView(root).forEach(e-> System.out.println(e));
		
		
	}
	
	
	
	
	public static List<Integer> leftView(BinaryTreeNode root){
		List<Integer> res = new ArrayList<>();
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		
		if(root == null) {
			return res;
		}
		
		q.offer(root);
		q.offer(null);
		res.add(root.data);
		
		while(!q.isEmpty()) {
			BinaryTreeNode curr = q.poll();
			
			if(curr == null) {
				if(!q.isEmpty()) {
					q.offer(null);
					if(q.peek()!=null) res.add(q.peek().data);
				}
			}
			else {
				if(curr.left!=null) q.offer(curr.left);
				if(curr.right!=null) q.offer(curr.right);
			}
		}
		return res;
	}
	
	
	static int maxLevel = 0;
	public static List<Integer> rightView(BinaryTreeNode root){
		List<Integer> res = new ArrayList<>();
		rightViewRecc(res, root, 1);
		return res;
	}
	
	private static void rightViewRecc(List<Integer> res, BinaryTreeNode node, int level) {
		if(node == null) return;
		if(maxLevel < level) {
			res.add(node.data);
			maxLevel = level;
		}
		rightViewRecc(res, node.right, level+1);
		rightViewRecc(res, node.left, level+1);
	}
	
	
	
	
	//bottom view
	
	public static List<Integer> bottomView(BinaryTreeNode root){
		List<Integer> res = new ArrayList<>();
		if(root == null) return res;
		
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		int hd = 0;
		root.hd = hd;
		q.offer(root);
		
		while(!q.isEmpty()) {
			BinaryTreeNode curr = q.poll();
			map.put(curr.hd, curr.data);
			if(curr.left!=null) {
				curr.left.hd = curr.hd-1;
				q.offer(curr.left);
			}
			if(curr.right!=null) {
				curr.right.hd = curr.hd+1;
				q.offer(curr.right);
			}
			
		}
		
		for(Entry<Integer, Integer> e: map.entrySet()) {
			res.add(e.getValue());
		}
		
		
		
		return res;
	}

}
