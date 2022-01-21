package com.abhi.practice.datastructures.linkedlist;

public class ReverseLinkedList {

	public Node sol(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	
	
}

/*
Initialize three pointers prev as NULL, current as head and next as NULL.
Iterate through the linked list. In loop, do following. 
   i. Before changing next of current, store next node. 
            next = curr->next
   ii. Now change next of current. This is where actual reversing happens.
            curr->next = prev 
   iii. Move prev and current one step forward 
            prev = curr 
            curr = next


*/