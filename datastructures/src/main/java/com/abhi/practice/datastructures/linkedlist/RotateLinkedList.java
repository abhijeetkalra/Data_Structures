package com.abhi.practice.datastructures.linkedlist;

public class RotateLinkedList {

	public static Node mySol(Node head, int k) {
		// add code here
		Node temp = head;
		Node res = null;
		Node prev = null;
		while (temp != null) {
			if (k == 0) {
				res = temp;
				prev.next = null;
			}
			k--;
			prev = temp;
			temp = temp.next;
		}
		prev.next = head;
		if (res == null)
			return head;
		return res;
	}

	public Node rotate(Node head, int k) {
		if (k == 0)
			return head;

		Node walk = head;
		Node prev = null;

		// this loop runs k times and walk pointer moves k nodes ahead
		// and reaches new head node.
		while (k-- > 0 && walk != null) {
			prev = walk;
			walk = walk.next;
		}
		// considering cases where k>=n so nothing needs to be done.
		if (walk == null)
			return head;

		// we store the walk pointer which gives the first node in newHead.
		Node newHead = walk;

		// since prev points to the node placed before new head it is new tail
		// or the last node of new list so we store null in it's link part.
		prev.next = null;

		// we keep moving the walk pointer till we reach the last node of list.
		while (walk.next != null)
			walk = walk.next;

		// connecting last node of old list to old head.
		walk.next = head;

		// returning the new list.
		return newHead;
	}

}
