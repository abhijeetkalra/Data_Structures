package com.abhi.practice.datastructures.top50;

public class GameOfLife {
	    //Matrix Update function.
	    public void updateMatrixToOriginal(int[][] board)
	    {
	        for(int i=0;i<board.length;i++)
	        {
	            for(int j=0;j<board[0].length;j++)
	            {
	                if(board[i][j] == -100)
	                    board[i][j] = 0;
	                else if(board[i][j] == 100)
	                    board[i][j] = 1;
	            }
	        }
	    }
	    public int checkLife(int[][] board,int[][] directions, int row, int col)
	    {
	        int count = 0;
	        for(int k=0;k<directions.length;k++)
	        {
	            int i = directions[k][0]+row;
	            int j = directions[k][1]+col;
	            if(i>=0 && j>=0 && i<board.length && j<board[0].length && (board[i][j] == -100 || board[i][j] == 1))
	               count++;
	        }
	        return count;        
	    }
	    public void gameOfLife(int[][] board) {
	        //Doing it inplace.
	        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1},{1,-1},{-1,1},{-1,-1},{1,1}};
	        for(int i=0;i<board.length;i++)
	        {
	            for(int j=0;j<board[0].length;j++)
	            {
	                if(board[i][j] == 1)
	                {
	                    int count = checkLife(board,directions,i,j);
	                    if(count<2)
	                        board[i][j] = -100; // It was alive but now died.
	                    else if(count>3)
	                        board[i][j] = -100;
	                }
	                else
	                {
	                    int count = checkLife(board,directions,i,j);
	                    if(count == 3)
	                        board[i][j] = 100; // It was dead now alive post reproduction.
	                }
	            }
	        }
	        updateMatrixToOriginal(board);
	    }
	

}
