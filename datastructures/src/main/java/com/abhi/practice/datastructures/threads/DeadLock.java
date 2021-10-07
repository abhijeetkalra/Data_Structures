package com.abhi.practice.datastructures.threads;

public class DeadLock {
	
	public static void main(String[] args) throws InterruptedException {
		Model model = new Model();
		
		Runnable runnable1 = () -> model.methodA();
		Runnable runnable2 = () -> model.methodB();
		
		Thread t1 = new Thread(runnable1);
		t1.start();
		
		Thread t2 = new Thread(runnable2);
		t2.start();
		
		t1.join();
		t2.join();
	}
	
	
}



class Model {
	
	private Object key1 = new Object();
	private Object key2 = new Object();
	
	public void methodA() {
		synchronized (key1) {
			System.out.println(Thread.currentThread().getName() + " I am in methodA()");
			methodB();
		}
	}
	
	public void methodB() {
		synchronized (key2) {
			System.out.println(Thread.currentThread().getName() + " I am in methodB()");
			methodC();
		}
	}
	
	public void methodC() {
		synchronized (key1) {
			System.out.println(Thread.currentThread().getName() + " I am in methodC()");
		}
	}
}