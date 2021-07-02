package com.abhi.practice.datastructures;

import java.util.List;

public class Airtel extends  Thread{
	
	public static int classNum =0;
	
	public float avg(List<Integer> list) {
		
		int sum =0;
		for(Integer e: list) {
			sum+=e;
		}
		
		return sum/list.size();
	}
	
	public void run() {
		increase();
		
	}
	
	public synchronized void increase() {
		for(int i=0; i<100;i++) {
			classNum++;
			System.out.println(classNum+Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		Airtel ar = new Airtel();
		//Thread t1 = new Thread(ar);
		//Thread t2 = new Thread(ar);
		Thread t1 = new Airtel();
		Thread t2 = new Airtel();
		t1.setName("Thread1");
		t2.setName("Thread2");
		t1.start();
		t2.start();
	}

}
