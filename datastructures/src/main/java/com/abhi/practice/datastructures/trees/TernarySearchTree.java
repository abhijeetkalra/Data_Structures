package com.abhi.practice.datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public class TernarySearchTree {
	
	
	public static void main(String[] args) {
		TernarySearchTree tree = new TernarySearchTree();
		tree.insert("hello");
		tree.search("hello");
		tree.insert("heya");
		tree.insert("booya");
		tree.search("no");
		tree.delete("qwe");
		tree.delete("no");
		tree.toString();
		tree.arr.forEach(e->System.out.println(e));
	}
	
	TSTNode root;
	List<String> arr;
	
	public TernarySearchTree() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public void insert(String word) {
		char[] wArr = word.toCharArray();
		root = insert(root, wArr, 0);
	}
	
	private TSTNode insert(TSTNode node, char[] word, int ptr) {
		
		if(node == null) {
			node = new TSTNode(word[ptr]);
		}
		
		if(word[ptr]<node.data) {   	
			node.left = insert(node.left, word, ptr);
		}
		else if(word[ptr]>node.data) {
			node.right = insert(node.right, word, ptr);
		}
		else {   //word[ptr] == node.data
			if(ptr+1<word.length) {
				node.mid = insert(node.mid, word, ptr+1);
			}
			else {
				node.isEnd = true;
			}
		}
		return node;
	}
	
	
	
	public void delete(String word) {
		delete(root,word.toCharArray(),0);
	}
	
	private void delete(TSTNode node, char[] word, int ptr) {
		if(node == null) return;
		
		if(word[ptr]<node.data) {
			delete(node.left, word, ptr);
		}
		else if(word[ptr]>node.data) {
			delete(node.right, word, ptr);
		}
		else {
			if(ptr+1<word.length) {
				delete(node.mid, word, ptr+1);
			}
			else if(node.isEnd){
				node.isEnd = false;
			}
		}
	}
	
	
	public boolean search(String word) {
		return search(root, word.toCharArray(), 0); 
	}
	
	private boolean search(TSTNode node, char[] word, int ptr) {
		
		if(node == null) {
			return false;
		}
		
		if(word[ptr]<node.data) {
			return search(node.left, word, ptr);
		}
		else if(word[ptr]>node.data) {
			return search(node.right, word, ptr);
		}
		else {
			if(ptr+1==word.length && node.isEnd) {
				return true;
			}
			else if(ptr+1==word.length) {
				return false;
			}
			else {
				return search(node.mid, word, ptr+1);
			}
		}
	}
	
	
	public String toString() {
		arr = new ArrayList<String>();
		traverse(root, "");
		return "Ternary : "+arr;
	}
	
	private void traverse(TSTNode node, String str) {
		
		if(node!=null) {
			traverse(node.left, str);
			//traverse(node.right, str);
			String strT = str;
			
			str = str + node.data;
			if(node.isEnd) {
				arr.add(str);
			}
			traverse(node.mid, str);
			
			str =strT;
			//str = str.substring(0, str.length()-1);
			traverse(node.right, str);
			
		}
		
	}
	
	

}

class TSTNode {
	char data;
	TSTNode left, right, mid;
	boolean isEnd;
	
	public TSTNode(char data) {
		this.data = data;
	}
}


