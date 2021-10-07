package com.abhi.practice.datastructures.top50;

public class IslandPerimeter {
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		sol(grid);
	}
	
	
	public static int sol(int[][] grid) {
		int res = 0;
		
		for(int i=0;i<grid.length;i++) {
			
			for(int j=0;j<grid[i].length;j++) {
				
				if(grid[i][j] == 1) {
					res+=sides(i, j, grid);	
				}
			}
		}
		return res;
	}
	
	
	static int sides(int i, int j, int[][] grid) {
		int sides = 4;
		//left
		i--;
		if(i>=0 && grid[i][j] == 1) sides--;
		i++;
		//up
		j--;
		if(j>=0 && grid[i][j] == 1) sides--;
		j++;
		//right
		i++;
		if(i<grid.length && grid[i][j] == 1) sides--;
		i--;
		//down
		j++;
		if(j<grid[i].length && grid[i][j] == 1) sides--; 
		j--;
		return sides;
	}
	

}
