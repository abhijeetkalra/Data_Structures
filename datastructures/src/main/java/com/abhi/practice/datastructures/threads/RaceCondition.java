package com.abhi.practice.datastructures.threads;

public class RaceCondition {
	
	public static void main(String[] args) throws InterruptedException {
		
		LongWrapper lw = new LongWrapper(0L);
		
		Runnable runnable = () -> {
			for(int i=0; i<1000; i++) {
				lw.incrementValue();
			}
		};
		
		Thread[] t = new Thread[1000];
		for(int i=0;i<t.length;i++) {
			t[i] = new Thread(runnable);
			t[i].start();
		}
		
		for(int i=0;i<t.length;i++) {
			t[i].join();
		}
		
		System.out.println("Value = " + lw.getValue());
		
		//Synchronized
		LongWrapper lw2 = new LongWrapper(0L);
		
		Runnable runnable2 = () -> {
			for(int i=0; i<1000; i++) {
				lw2.incrementValueSync();
			}
		};
		
		Thread[] t2 = new Thread[1000];
		for(int i=0;i<t2.length;i++) {
			t2[i] = new Thread(runnable2);
			t2[i].start();
		}
		
		for(int i=0;i<t2.length;i++) {
			t2[i].join();
		}
		
		System.out.println("Value from Sync = " + lw2.getValue());
		
	}

}



class LongWrapper {
	
	private long l;
	
	private Object key = new Object();
	
	public LongWrapper( long value) {
		l = value;
	}
	
	public long getValue() {
		return l;
	}
	
	public void incrementValue() {
		l = l+1;
	}
	
	public void incrementValueSync() {
		synchronized (key) {
			l = l+1;
		}
		
	}
}