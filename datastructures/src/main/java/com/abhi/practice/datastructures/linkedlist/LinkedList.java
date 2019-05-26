package com.abhi.practice.datastructures.linkedlist;

public class LinkedList {
	private int length;
	private ListNode head;
	
	public LinkedList() {
		length = 0;
	}
	
	public synchronized ListNode getHead() {
		return head;
	}
	
	public int lenght() {
		return length;
	}
	
	//Insert a node before head
	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}
	
	//Insert a node at the end
	public synchronized void insertAtEnd(ListNode node) {
		if(head == null) {
			head = node;
		}
		else {
			ListNode temp = head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
		length++;
	}
	
	//Add a node at a given position
	public synchronized void insert(int data, int position) {
		if(position<0) {
			position = 0;
		}
		if(position> length) {
			position = length;
		}
		
		if(head == null) {
			head = new ListNode(data);
		}
		else if(position == 0) {
			insertAtBegin(new ListNode(data));
			return;
		}
		else {
			ListNode temp = head;
			for(int i=0;i<position-1;i++) {
				temp = temp.getNext();
			}
			ListNode node = new ListNode(data);
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
		length++;
	}
	
	
	//Remove and return node at head
	public synchronized ListNode removeFromBegin() {
		ListNode node = head;
		if(head != null) {
			head = head.getNext();
			node.setNext(null);
			length--;
		}
		return node;
	}
	
	//Remove and return node at end
	public synchronized ListNode removeFromEnd() {
		if(head == null) {
			return null;
		}
		
		ListNode node = head;
		if(head.getNext() == null) {	
			head = null;
			length--;
			return node;
		}
		ListNode temp = node;
		while(node.getNext() != null) {
			temp = node;
			node = node.getNext();
		}
		temp.setNext(null);
		length--;
		return node;	
	}
	
	//Remove node matching specified node
	public synchronized void removeMatched(ListNode node) {
		if(head == null) {
			return;
		}
		if(node.equals(head)) {
			head = head.getNext();
			length--;
			return;
		}
		ListNode temp = head;
		while(temp.getNext() != null) {
			if(temp.getNext().equals(node)) {
				temp.setNext(temp.getNext().getNext());
				temp.getNext().setNext(null);
				length--;
				return;
			}
			temp = temp.getNext();
		}
	}
	
	
	//Remove value at a given position
	public synchronized void remove(int position) {
		if(position<0)
			position = 0;
		if(position>length)
			position=length-1;
		
		if(head == null)
			return;
		
		ListNode node = head;
		if(position == 0) {
			head = head.getNext();
			node.setNext(null);
		}
		else {
			for(int i=0; i<position-1 ; i++) {
				node = node.getNext();
			}
			node.setNext(node.getNext().getNext());
		}
		length--;
	}
	
	//Return a string representation of list
	public String toString() {
		String result = "[";
		if(head == null)
			return result+"]";
		ListNode temp = head.getNext();
		result = result+head.getData();
		while(temp != null) {
			result = result+", "+temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}
	
	//Position of first value found in list
	public int getPosition(int data) {
		ListNode temp = head;
		int pos = 0;
		while(temp != null) {
			if(temp.getData() == data) {
				return pos;
			}
			pos++;
			temp = temp.getNext();
		}
		return Integer.MIN_VALUE;
	}
	
	//Clear List
	public void clearList() {
		head = null;
		length = 0;
	}
}
