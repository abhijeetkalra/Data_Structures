package com.abhi.practice.datastructures.threads;

public class ProducerConsumerPattern {
	
	private static int[] buffer;
	private static int count;
	
	private static Object lock = new Object();
	
	static boolean isEmpty(int[] buffer) {
		return count == 0;
	}
	
	static boolean isFull(int[] buffer) {
		return buffer.length == count;
	}
	
	static class Producer {
		void produce() {
			synchronized (lock) {
				while(isFull(buffer)) {
					try {
						System.out.println("Buffer Full, can't Produce");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[count++] = 1;
				System.out.println("Produced");
				lock.notify();
			}
			
		}
	}
	
	static class Consumer {
		void consume() {
			synchronized (lock) {
				while(isEmpty(buffer)) {
					try {
						System.out.println("Buffer Emply, can't consume");
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				buffer[--count] = 0;
				System.out.println("Consumed");
				lock.notify();
			}
			
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		buffer = new int[10];
		count = 0;
		
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Runnable produceTask = () -> {
			for(int i =0;i<50;i++) {
				producer.produce();
			}
			System.out.println("Done Producing");
		};
		
		Runnable consumeTask = () -> {
			for(int i =0;i<50;i++) {
				consumer.consume();
			}
			System.out.println("Done Consuming");
		};
		
		Thread cThread = new Thread(consumeTask);
		Thread pThread = new Thread(produceTask);
		
		cThread.start();
		pThread.start();
		
		cThread.join();
		pThread.join();
		
		System.out.println("Data in buffer: "+count);
	}
	

	
}



