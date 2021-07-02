package com.abhi.practice.datastructures.lbsheet;

public class MinNoOfJump {

	public static void main(String[] args) {
		 //int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}; //Ans 3
		// int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1}; //Ans 4
		int[] arr = { 10, 8, 12, 17, 1, 21, 5, 17, 20, 11, 5, 27, 23, 8, 12, 18, 16, 12, 9, 8, 17, 12, 23, 26, 0, 5, 9, 24, 10 }; // Ans 2
		System.out.println(minJump3(arr));
		/*
		 * for (int e : arr) { System.out.print(" "+e); }
		 */
	}

	static int minJump(int[] arr) {

		int jump = 0;
		int j;
		for (int i = 0; i < arr.length - 1; i++) {
			int k = i + 1;
			int nxtJS = arr[k];
			j = k;
			k++;
			while (k < arr[i]) {
				if (arr[k] > nxtJS) {
					nxtJS = arr[k];
					j = k;
				}
				k++;
			}
			jump++;
			if (i + j >= arr.length) {
				break;
			}

		}

		return jump;
	}

	static int minJump2(int[] arr) {

		int jmpStps = arr[0];
		int jNos = 0;
		int i = 0;
		while (i < arr.length) {
			int temp = jmpStps;
			if (i + jmpStps < arr.length) {
				jmpStps = arr[i + jmpStps];
			} else {
				jNos++;
				break;
			}
			i += temp;
			jNos++;
		}

		return jNos;
	}

	static int minJump3(int[] arr) {

		int jmpStps = arr[0];
		int jNos = 0;
		int i = 0;
		int jmpStpsNxt = arr[0];
		int ni = 0;
		while (i < arr.length) {
			if (jmpStpsNxt-ni == 0) {
				return -1;
			}
			jmpStps = jmpStpsNxt-ni;
			if (i + jmpStps < arr.length - 1) {
				ni = i + 1;
				jmpStpsNxt = arr[i + 1]+ni;
				for (int j = i + 1; j <= i + jmpStps && j < arr.length; j++) {
					if (jmpStpsNxt < arr[j]+j) {
						jmpStpsNxt = arr[j]+j;
						ni = j;
					}
				}
			} else {
				jNos++;
				break;
			}
			i = ni;
			jNos++;
		}

		return jNos;
	}
	
	static int minJumpHint(int[] arr) {
		if(arr.length<= 1 || arr[0]==0) {
			return -1;
		}
		
		int maxRange = arr[0];
		int steps = arr[0];
		int jumps = 1;
		int i = 1;
		while(i<arr.length-1) {
			maxRange = Integer.max(maxRange, i+arr[i]);
			steps--;
			if(steps == 0) {
				jumps++;
				if(i>=maxRange) {
					return -1;
				}
				steps = maxRange - i;// this is same from the maxRange selected index to make further steps
			}
			i++;
		}
		return jumps;
	}

}
