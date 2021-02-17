/**
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */

class Solution {
    
    int solutions;
    public int totalNQueens(int n) {
        
        String[][] newBoard = new String[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                newBoard[i][j] = ".";
            }
        }
        
        solutions = 0;
        
        if(numberOfNQueenSolutions(newBoard, 0,n)==false)
        {
            return 0;
        }
        
        return solutions;
        
    }
    
    private boolean isColumnValid(String[][] board, int row, int col, int n)
    {
        for(int i=0; i<col; i++)
        {
            if(board[row][i]=="Q")
                return false;
        }
        
        for(int i=row, j=col; i>=0 && j>=0; i--, j--)
        {
            if(board[i][j]=="Q")
                return false;
        }
        
        for(int i=row, j=col; j>=0 && i<n; i++, j--)
        {
            if(board[i][j]=="Q")
                return false;
        }
        
        return true;
    }
    
    private boolean numberOfNQueenSolutions(String[][] board, int column, int n)
    {
        if(column>=n)
        {
            solutions++;
            return true;
        }
        
        boolean result = false;
        
        for(int i=0; i<n; i++)
        {
               
                if(isColumnValid(board,i,column,n))
                {
                    board[i][column] = "Q";
                    
                    result = numberOfNQueenSolutions(board,column+1,n) || result;
                    
                    board[i][column] = ".";
                }
        }
        
        return result;
        
    }
}