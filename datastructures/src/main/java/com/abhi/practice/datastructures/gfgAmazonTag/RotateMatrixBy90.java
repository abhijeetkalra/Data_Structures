package com.abhi.practice.datastructures.gfgAmazonTag;

public class RotateMatrixBy90 {
	
	
	
	
	static void rotate90AntiClockWise(int[][] mat) {
		
		int n = mat.length;
		
		for(int i=0;i<n/2;i++) {
			
			for(int j=i;j<n-i-1;j++) {
				
				//swap in anticlockwise
				int temp = mat[i][j];
				mat[i][j] = mat[j][n-i-1];   			//right to top
				mat[j][n-i-1] = mat[n-i-1][n-j-1];  	//bottom to right
				mat[n-i-1][n-j-1] = mat[n-j-1][i];     	//left to bottom
				mat[n-j-1][i] = temp;					//top to left
				
				
			}
		}
		
	}

}
