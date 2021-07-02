package com.abhi.practice.datastructures.threads;

public class WaitNotifyEx {

	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start();
		synchronized (b) {
			try {
				System.out.println("Waiting for b to complete...");
				b.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Interrupt exception");
				// e.printStackTrace();

			}
			System.out.println("Total : " + b.total);

		}
	}

}

class ThreadB extends Thread {
	int total;

	public void run() {
		while (true) {
			synchronized (this) {
				for (int i = 0; i < 100; i++) {
					total += i;
				}
				notify();
			}
			synchronized (this) {
				System.out.println("Again took the lock");
				
			}
			break;
		}
	}
}
