package com.abhi.practice.datastructures.interviewsExp;

public class Sense1 {

	
	
	static final char[][] arr1 = {{'1','2','3','4','5','6','7','8','9','0'},
					{'q','w','e','r','t','y','u','i','o','p'},
					{'a','s','d','f','g','h','j','k','l',';'},
					{'z','x','c','v','b','n','m',',','.','/'}};
	
	
	
	
	public static void main(String[] args) {
		solution();
		//shiftFlip(arr,-12);
	}
	
	public static void solution() {
		
		String input1 = "-45";
		
		String input2 = "all human beings are born free and equal in dignity and rights. "
				+ "they are endowed with reason and conscience and should act towards one another in a spirit of brotherhood.&%$";
		
		String[] sArr = input1.split(",");
		
		char[][] res = new char[4][10];
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[0].length;j++) {
				res[i][j] = arr1[i][j]; 
			}
		}
		
		for(String s:sArr) {
			switch (s) {
			case "H":
				res = horizontalFlip(res);
				break;
			case "V":
				res = verticlaFlip(res);
				break;	
			default:
				int i = Integer.parseInt(s);
				i = i%40;
				res = shiftFlip(res,i);
				break;
			}
		}
		
		String result = "";
		for(int i=0;i<input2.length();i++) {
			if(input2.charAt(i)== ' ') {
				result+=' ';
			}else {
				result+=getEncodedChar(arr1, res, input2.charAt(i));
			}
		}
		System.out.println(result);
		
		
	}
	
	public static char getEncodedChar(char[][] arr, char[][] res, char a) {
		
		char b= a;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==a) {
					b = res[i][j];
					break;
				}
			}
		}
		return b;
	}
	
	
	public static char[][] horizontalFlip(char[][] arr){
		
		for(int i=0;i<5;i++) {
			char t1 = arr[0][i];
			arr[0][i] = arr[0][9-i];
			arr[0][9-i] = t1;
			
			char t2 = arr[1][i];
			arr[1][i] = arr[1][9-i];
			arr[1][9-i] = t2;
			
			char t3 = arr[2][i];
			arr[2][i] = arr[2][9-i];
			arr[2][9-i] = t3;
			
			char t4 = arr[3][i];
			arr[3][i] = arr[3][9-i];
			arr[3][9-i] = t4;
			
		}
		return arr;
	}
	
	public static char[][] verticlaFlip(char[][] arr){
		
		for(int i=0;i<10;i++) {
			char t1 = arr[0][i];
			arr[0][i] = arr[3][i];
			arr[3][i] = t1;
			
			char t2 = arr[1][i];
			arr[1][i] = arr[2][i];
			arr[2][i] = t2;
			
		}
		return arr;
	}
	
	public static char[][] shiftFlip(char[][] arr, int n){
		
		char[] temp = new char[40];
		char[] temp1 = new char[40];
		int k = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				temp[k] = arr[i][j];
				k++;
			}
		}
		
		if(n==0) {
			return arr;
		} else if(n>0) {
			char[] temp2 = new char[n];
			for(int i=0;i<n;i++) {
				temp2[i] = temp[40-n+i];
			}
			for(int i=0;i<40-n;i++) {
				temp1[i+n] = temp[i];
			}
			for(int i=0;i<n;i++) {
				temp1[i] = temp2[i];
			}
			
			
			
		} else {
			n=Math.abs(n);
			char[] temp2 = new char[n];
			for(int i=0;i<n;i++) {
				temp2[i] = temp[i];
			}
			for(int i=0;i<40-n;i++) {
				temp1[i] = temp[i+n];
			}
			for(int i=0;i<n;i++) {
				temp1[40-n+i] = temp2[i];
			}
			
		}
		k=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				arr[i][j] = temp1[k]; 
				k++;
			}
		}
		
		return arr;
	}
}
