package com.abhi.practice.datastructures.threads;

public class MultipleThreads implements Runnable{
	
	public void run() {
		for(int i =0; i<3;i++) {
			System.out.println(Thread.currentThread().getName()+" : num is " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MultipleThreads r = new MultipleThreads();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		t1.setName("First");
		t2.setName("Second");
		t3.setName("Third");
		t1.start();
		//t1.join();
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.start();
		t2.join();
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.start();
		t3.setPriority(Thread.MAX_PRIORITY);
		for(int i =0; i<3;i++) {System.out.println(Thread.currentThread().getName()+" : num is " + i);}
	}

}

class Test{
	
	public static void main(String[] args) {
		MultipleThreads r = new MultipleThreads();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		t1.setName("First");
		t2.setName("Second");
		t3.setName("Third");
		t1.start();
		t2.start();
		t3.start();
	}
}
