package com.abhi.practice.datastructures.linkedlist;

public class IntersectionPointLinkedList {
	
	
	/*
	 * 
There are many methods to solve this problem.
Method Using difference of node counts:

Get count of the nodes in the first list, let be c1.
Get count of the nodes in the second list, let be c2.
Get the difference of counts d = abs(c1 – c2).
Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
Then we can traverse both the lists simultaneously till we come across a common node.
	 */
	
	int intersectPoint(Node head1, Node head2)
	{
         // code here
         int l1 = 0;
         int l2 = 0;
         Node t1 = head1;
         Node t2 = head2;
         while(t1!=null){
             t1=t1.next;
             l1++;
         }
         while(t2!=null){
             t2= t2.next;
             l2++;
         }
         int d = Math.abs(l1-l2);
          t1 = head1;
          t2 = head2;
          if(l1>l2){
              while(d>0){
                  t1=t1.next;
                  d--;
              }
          }else if(l2>l1){
              while(d>0){
                  t2=t2.next;
                  d--;
              }
          }
          while(t1!=null && t2!=null){
              if(t1.equals(t2)){
                  return t1.data;
              }
              t1=t1.next;
              t2=t2.next;
          }
          return -1;
	}
	
	

}
