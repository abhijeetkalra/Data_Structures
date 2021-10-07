package com.abhi.practice.datastructures.top50;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {
	
	
	public static void main(String[] args) {
		int cap = 2;
		LRUCache lru = new LRUCache(cap);
		/*
		 * lru.put(1,1); lru.put(2, 2); lru.get(1); lru.put(3, 3); lru.get(2);
		 * lru.put(4, 4); lru.get(1); lru.get(3); lru.get(4);
		 */
		
		lru.get(2);
		lru.put(2, 6);
		lru.get(1);
		lru.put(1, 5);
		lru.put(1, 2);
		lru.get(1);
		lru.get(2);
		
	}

	Map<Integer, Integer> map;
	int cap;
	
    public LRUCache(int capacity) {   
         map = new LinkedHashMap<>(capacity);
         cap = capacity;
    }
    
    public int get(int key) {
    	if(map.containsKey(key)) {
    		int val = map.get(key);
    		map.remove(key);
    		map.put(key, val);
    		return val;
    	}
    	return -1;
    }
    
    public void put(int key, int value) {
    	
		
		if (map.containsKey(key)) {
			map.remove(key);
			map.put(key, value);
		} else if (map.size() == cap) {// removing first entry from map if it is full 
			for(Integer e : map.keySet()){
				map.remove(e);
				break;
			}
			map.put(key, value);
		} else {
			map.put(key, value);
		}
		 
    	
		/*
		 * if(map.size()==cap) { for(Integer e : map.keySet()) { map.remove(e); break; }
		 * } map.put(key, value);
		 */
        
    }
}


class Node{
	int key;
	int value;
	Node pre;
	Node nxt;
	
	public Node(int key, int val) {
		this.key = key;
		this.value = val;
		pre = nxt = null;
	}
}

class LRUCacheDoublyNode{
	
	static Map<Integer, Node> map;
	static int capacity, count;
	static Node head, tail;
	
	public LRUCacheDoublyNode(int cap){
		map = new HashMap<>();
		this.capacity = cap;
		head = new Node(0, 0);
		tail = new Node(0,0);
		head.nxt = tail;
		head.pre = null;
		tail.pre = head;
		tail.nxt = null;
		count = 0;
	}
	
	public static void addToHead(Node node) {
		node.nxt = head.nxt;
		node.nxt.pre = node;
		node.pre = head;
		head.nxt = node;
		
	}
	
	public static void deleteNode(Node node) {
		node.pre.nxt = node.nxt;
		node.nxt.pre = node.pre;
	}
	
	public static int get(int key) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			int res = node.value;
			deleteNode(node);
			addToHead(node);
			return res;
		}
		return -1;
	}
	
	public static void set(int key, int value) {
		Node node = new Node(key, value);
		if(map.containsKey(key)) {
			node = map.get(key);
			node.value = value;
			deleteNode(node);
		} else {
			if(map.size() == capacity) {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
			}
			map.put(key, node);
		}
		addToHead(node);
		
	}
	
	
	public static void set2(int key, int value) 
    {
        if (map.get(key) != null) 
        {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } 
        else 
        {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity)
            {
                count++;
                addToHead(node);
            } 
            else 
            {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
	
}






