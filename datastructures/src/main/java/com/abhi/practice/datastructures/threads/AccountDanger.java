package com.abhi.practice.datastructures.threads;

public class AccountDanger implements Runnable{
	private Account acc = new Account();
	public void run() {
		for(int x=0; x<5; x++) {
			makeWithdrawal(10);
			if(acc.getBalance() < 0) {
				System.out.println("account is overdrwan");
			}
		}
	}
	
	private synchronized void makeWithdrawal(int amt) {
		if(acc.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName()+" is making transac");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			acc.withdraw(amt);
			System.out.println(Thread.currentThread().getName()+" completes the tansac"+ " current balance "+ acc.getBalance());
		} else {
			System.out.println("Not enough money in account for "+ Thread.currentThread().getName());
		}
		
	}
	
	private static synchronized void test() {
		System.out.println("In static syncronized method");
	}
	
	public static void main(String[] args) {
		AccountDanger r = new AccountDanger();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.setName("Fred");
		t2.setName("Lucy");
		t1.start();
		t2.start();
	}

}

class Account{
	private int balance =50;
	public int getBalance() {
		return balance;
	}
	public void withdraw(int amount) {
		balance = balance - amount;
	}
}
