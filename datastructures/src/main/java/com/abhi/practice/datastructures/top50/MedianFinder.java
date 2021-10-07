package com.abhi.practice.datastructures.top50;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap; 
    int size;

    /** initialize your data structure here. */
    public MedianFinder() {
    	size = 0;
    	minHeap = new PriorityQueue<Integer>();
    	maxHeap = new PriorityQueue<Integer>((a,b)->b-a);
    	
    }
    
    public void addNum(int num) {
    	size++;
    	if(maxHeap.isEmpty() || maxHeap.peek()>num) {
    		maxHeap.add(num);
    	} else {
    		minHeap.add(num);
    	}
    	
    	if(maxHeap.size()>minHeap.size()+1) {
    		minHeap.add(maxHeap.poll());
    	}
    	if(minHeap.size()>maxHeap.size()) {
    		maxHeap.add(minHeap.poll());
    	}
    }
    
    public double findMedian() {
    	
    	if(size%2==0) {
    		return (maxHeap.peek()+minHeap.peek())/2.0;
    	}
    	return maxHeap.peek();
    	
    }
    
    
    public static void main(String[] args) {
		MedianFinder m = new MedianFinder();
		m.addNum(1);
		m.addNum(2);
		System.out.println(m.findMedian());
		m.addNum(3);
		System.out.println(m.findMedian());
	}
}

