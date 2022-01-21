package com.abhi.practice.datastructures.linkedlist;

public class ReverseLinkedListInGroups {

	
	public static Node sol(Node head, int k) {
		return recc(head,k);
	}
	
	
	public static Node recc(Node node, int k) {
		
		Node prev = null;
		Node curr = node;
		Node next = null;
		
		int count = 0;
		while(curr!=null && count<k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if(next != null) {
			node.next = recc(next, k);
		}
		
		return prev;
		
		
	}
}
