package com.abhi.practice.datastructures.commons;

public class GupShupSnippet {
	
	private static int x=10;
	private static int y=10;
	
	private GupShupSnippet() {
		this(5);
	}
	
	private GupShupSnippet(int x) {
		this(x, y);
	}
	
	private GupShupSnippet(int x, int y) {
		System.out.println(x*y);
	}
	
	public static void main(String[] args) {
		GupShupSnippet t = new GupShupSnippet();
	}


}
