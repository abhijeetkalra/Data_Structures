package com.abhi.practice.datastructures.gfgAmazonTag;

public class TrieInsertAndSearch {
	
	

	
	
	static void insert(TrieNode root, String key) 
	{
	    // Your code here
	    TrieNode curr = root;
	    
	    for(int i =0; i<key.length();i++){
	    	
	    	
	    	//if not present, we insert key into trie. If the key is prefix of trie node, we just mark the leaf node.
	        int index = key.charAt(i)-'a';
	        if(curr.children[index] == null) {
	            curr.children[index] = new TrieNode();
	        }
	        curr = curr.children[index];
	        
	    }
	    
	    //Marking last node as endofWord node
	    curr.isEndOfWord = true;
	}

	//Function to use TRIE data structure and search the given string.
	static boolean search(TrieNode root, String key)
	{
	    // Your code here
	    TrieNode curr = root;
	    
	    for(int i =0; i<key.length();i++){
	        
	    	//Inserting new Trie Obj at alphabet index
	        int index = key.charAt(i)-'a';
	        if(curr.children[index] == null) {
	            return false;
	        }
	        curr = curr.children[index];
	        
	    }
	    if(curr != null && curr.isEndOfWord) {
	        return true;
	    }
	    return false;
	    
	}
	
	
	
}


class TrieNode {
	static final int ALPHABET_SIZE = 26;
	TrieNode[] children = new TrieNode[ALPHABET_SIZE];
	
	boolean isEndOfWord;
	
	TrieNode() {
		isEndOfWord = false;
		for(int i =0;i<ALPHABET_SIZE;i++) {
			children[i] = null;
	}
	}
}
