package com.abhi.practice.datastructures.interviewsExp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Oracle {
	
	
	public void futures() throws InterruptedException, ExecutionException {
		
		
		List<Future> lis = new ArrayList<Future>();
		
		for(int i =0;i<5;i++) {
			
		}
		
		/*
		Runnable call1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//logic to make call to service 1;
				
			}
		};
		Future<String> f1 = new Future<String>() {
		};
		*/
		for(Future f : lis) {
			f.get();
		}
	}
	
	
	//1-20 @ threads
	static int i = 0;
	static int j =1;
	
	static Object key = new Object();
	
	
	public static void main(String[] args) throws InterruptedException {
		twoThread();
		
	}
	
	public static void twoThread() throws InterruptedException {
		
		
		
		Runnable evenTask = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(i<=20) {
					//System.out.println(i);
					try {
						printNum(i);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					i+=2;
					
					/*
					try {
						key.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					key.notify();*/
				}
				
				
			}
		};
		
		Runnable oddTask = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(j<20) {
					//System.out.println(j);
					try {
						printNum(j);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					j += 2;
					
					
					/*
					try {
						key.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					key.notify();*/
				}
				

			}
		};
		
		
		
		
		Thread t1 = new Thread(evenTask);
		Thread t2 = new Thread(oddTask);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		
		
		
		
		
	}
	
	public static void printNum(int a) throws InterruptedException {
		synchronized (key) {
			while(i<=20 && j<20) {
				System.out.println(a);
				Thread.yield();
				//key.wait();
				//key.notify();
			}
			
		}
	}
}
