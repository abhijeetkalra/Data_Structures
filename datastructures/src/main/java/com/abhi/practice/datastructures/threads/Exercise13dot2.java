package com.abhi.practice.datastructures.threads;

public class Exercise13dot2 {
	
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("A");
		new SomeClass(sb).start();
		new SomeClass(sb).start();
		new SomeClass(sb).start();
	}

}

class SomeClass extends Thread {
	StringBuffer letter;

	public SomeClass(StringBuffer letter) {
		this.letter = letter;
	}

	public void run() {
		synchronized (letter) {
			for (int i = 0; i < 4; i++) {
				System.out.println(letter);
			}
			System.out.println();
			char temp = letter.charAt(0);
			++temp;
			letter.setCharAt(0, temp);

		}
	}
}
