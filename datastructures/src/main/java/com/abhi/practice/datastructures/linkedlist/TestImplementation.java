package com.abhi.practice.datastructures.linkedlist;

public class TestImplementation {
	
	public static void main(String[] args) {
		
		//testLinkedList();
		testDoublyLinkedList();
	}
	
	public static void testLinkedList() {
		LinkedList linkedList = new LinkedList();
		linkedList.insertAtBegin(new ListNode(4));
		linkedList.insertAtEnd(new ListNode(5));
		linkedList.insert(3, -4);
		linkedList.insert(2, 6);
		linkedList.insert(1, 1);
		
		System.out.println(linkedList.lenght());
		System.out.println(linkedList);
	}
	
	public static void testDoublyLinkedList() {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.insert(2, -4);
		doublyLinkedList.insert(1, 4);
		doublyLinkedList.insert(5, 1);
		//System.out.println(doublyLinkedList.removeFromLast());
		doublyLinkedList.insert(3, 6);
		System.out.println(doublyLinkedList.remove(-2));
		
		
		System.out.println(doublyLinkedList.length());
		System.out.println(doublyLinkedList.toString());
	}
}
