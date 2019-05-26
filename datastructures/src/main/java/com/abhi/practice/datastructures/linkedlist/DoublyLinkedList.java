package com.abhi.practice.datastructures.linkedlist;

public class DoublyLinkedList {
	
	private DLLNode head;
	private DLLNode tail;
	private int length;
	
	public DoublyLinkedList() {
		length = 0;
	}
	
	//Return current length
	public int length() {
		return length;
	}
	
	//Add new value to front of list
	public void insertInBegin(int data) {
		if(head == null) {
			head = new DLLNode(data);
			tail = head;
		}
		else {
			DLLNode node = new DLLNode(data);
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
		length++;
	}
	
	//Insert at last
	public void insertAtLast(int data) {
		if(tail == null) {
			head = new DLLNode(data);
			tail = head;
		}
		else {
			DLLNode node = new DLLNode(data);
			tail.setNext(node);
			node.setPrev(tail);
			tail = node;
		}
		length++;
	}
	
	//Add value at given position
	public void insert(int data, int position) {
		if(position<0) 
			position =0;
		if(position>length)
			position = length;
		
		if(head == null) {
			head = new DLLNode(data);
			tail = head;
		}
		else if(position == 0) {
			insertInBegin(data);
			return;
		}
		else if(position == length) {
			insertAtLast(data);
			return;
		}
		else {
			DLLNode temp = head;
			for(int i=0;i<position-1;i++) {
				temp = temp.getNext();
			}
			DLLNode node = new DLLNode(data);
			node.setNext(temp.getNext());
			node.setPrev(temp);
			node.getNext().setPrev(node);
			temp.setNext(node);
		}
		length++;
	}
	
	//Remove value at given position
	public int remove(int position) {
		if(position<0)
			position = 0;
		if(position>length)
			position=length-1;
		
		if(head == null) {
			return Integer.MIN_VALUE;
		}
		
		int result = Integer.MIN_VALUE;
		if(position == 0) {
			return removeFromBegin();
		}
		else if(position == length-1) {
			return removeFromLast();
		}
		else {
			DLLNode temp = head;
			for(int i=0;i<position-1;i++) {
				temp = temp.getNext();
			}
			result = temp.getData();
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
		}
		length--;
		return result;	
	}
	
	
	//Remove node matched
	public void removeMatched(DLLNode node) {
		if(head == null) return;
		if(node.equals(head)) {
			removeFromBegin();
			return;
		}
		if(node.equals(tail)) {
			removeFromLast();
			return;
		}
		DLLNode temp = head;
		while(temp != tail) {
			temp = temp.getNext();
			if(temp.equals(node)) {
				temp.getNext().setPrev(temp.getPrev());
				temp.getPrev().setNext(temp.getNext());
				length--;
				return;
			}
		}
		
	}
	
	
	//Clear list
	public void clearList() {
		head=tail=null;
		length = 0;
	}
	
	
	//Remove last element
	public int removeFromLast() {
		if(tail == null)
			return Integer.MIN_VALUE;
		int result = tail.getData();
		length--;
		if(tail == head) {
			head = tail = null;
		}
		else {
			tail = tail.getPrev();
			tail.setNext(null);
		}
		return result;
	}
	
	//Remove from Begin
	public int removeFromBegin() {
		if(head == null)
			return Integer.MIN_VALUE;
		
		int result = head.getData();
		length--;
		if(head == tail) {
			head = tail = null;
		}
		else {
			head = head.getNext();
			head.setPrev(null);
		}
		return result;
	}
	
	//String representation 
	public String toString() {
		String result = "[";
		if(length == 0)
			return result+"]";
		
		result = result + head.getData();
		DLLNode temp = head;
		while(temp != tail) {
			temp = temp.getNext();
			result += ", "+temp.getData();
		}
		return result+"]";	
	}
}
