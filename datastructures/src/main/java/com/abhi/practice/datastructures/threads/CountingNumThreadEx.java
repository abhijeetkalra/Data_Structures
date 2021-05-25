package com.abhi.practice.datastructures.threads;

public class CountingNumThreadEx extends Thread {
	public void run() {
		for(int x=1;x<=100;x++) {
			System.out.println("x: " +x);
			if(x%10==0) {
				System.out.println("HAHA");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new CountingNumThreadEx().start();
	}

}
