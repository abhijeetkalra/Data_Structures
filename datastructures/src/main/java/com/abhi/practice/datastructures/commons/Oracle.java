package com.abhi.practice.datastructures.commons;

public class Oracle {
	
	
	
	public void method1(int a) {
		System.out.println("");
	}
	
	public static void main(String[] args) {
		
		Oracle o = new Child();
		o.method1(0);
		String str1="Hello";
		str1.concat("java2blog");
		System.out.println(str1);
	}
	
	public static void sol1(int[] arr) {
		
		int max = 0;
		int secMax = 0;
		
		for(int i =0;i<arr.length;i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
			if(arr[i] > secMax && arr[i] < max) {
				secMax = arr[i];
			}
		}
		
	}
}



class Child extends Oracle {
	
	public void method1(int a) {
		
	}
	
	public void method1(String sr) {}
	
	
	int arr[] = { 100,14, 46, 47,102 , 94, 94, 52, 86, 36, 94, 89 };
}


class Node {
	
	int data;
	Node next;
	boolean isVisited;
	
	public Node(int data) {
		this.data = data;
		next = null;
		isVisited = false;
	}
	
	
	public boolean ifCircular(Node head) {
		
		while(head.next!=null) {
			if(head.isVisited) return true;
			head.isVisited = true;
			head = head.next;
		}
		return false;
	}
	
	public boolean ifCircular2(Node head) {
		
		Node node1 = head;
		Node node2 = head.next;
		
		while(node1.next != null && node2.next != null && node2.next.next != null) {
			
			if(node1==node2) {
				return true;
			}
			
			if(node1.next != null) {
				node1=node1.next;
			} else {
				break;
			}
			if(node2.next != null && node2.next.next != null) {
				node2 = node1.next.next;
			} else {
				break;
			}
		}
		return false;
	}
	
	
}



class Multithreading {
	
	
	Object key1 = new Object();
	Object key2 = new Object();
	
	
	
	
	public void methodA() {
		synchronized (key1) {
			System.out.println("in method A");
			methodB();
		}
	}
	
	public void methodB() {
		synchronized (key2) {
			System.out.println("in method A");
			methodC();
		}
	}
	
	public void methodC() {
		synchronized (key1) {
			System.out.println("in method A");
			methodA();
		}
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		Multithreading cObj = new Multithreading();
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				cObj.methodA();
			}
		};
		
		Runnable task2 = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				cObj.methodB();
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		t1.join();
		t2.join();
	}
	
}


class FactoryClass{
	
	public static Object getInstance() {
		return new Object();
	}
}

interface VehicleFactory {
	
	public static VehicleFactory getInstance() {
		return null;};
}

class CarFactory implements VehicleFactory {
	
}
