/**
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 */


/*
This solution uses extra memory for a 2d String Array, it can be further optimized by making changes in the list directly
*/
class Solution {
    List<List<String>> board = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        
        //place queen on a position 0,j for row 1
        //place a queen on a position 1,j for row 2 such that newj!=j || newj!=j-1 || newj!=j+1
        //When adding again make sure to check for all positions, that is the row above, check for upper diagonal, lower diagonal and row above
        
        //use a boolean array to mark position of already added queens on above rows
        
        String[][] newBoard = new String[n][n];
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                newBoard[i][j] = ".";
            }
        }
        
        
        if(makeNQueenBoard(newBoard,0,n)==false)
        {
            return new ArrayList();
        }

        return board;
    }
    
    private void makeBoard(String[][] board, int n)
    {
        List<String> list = new ArrayList();
        for(int i=0; i<n; i++)
        {
            
            String dummy = "";
            for(int j=n-1; j>=0; j--)
            {
                //list.add(newBoard[i][j]);
                dummy+=board[i][j];
            }
           list.add(dummy);
        }
         
         this.board.add(list);
        
         
    }


private boolean makeNQueenBoard(String[][] board, int column, int n) 
{ 
    /* base case: If all queens are placed 
    then return true */
    if (column>=n) 
    { 
        makeBoard(board,n);
        return true; 
    } 
 
    boolean res = false; 
    for (int i = 0; i < n; i++) 
    { 
        /* Check if queen can be placed on 
        board[i][col] */
        if ( isColumnAllowed(board, i, column, n) ) 
        { 
            // Place the queen in this position
            board[i][column] = "Q"; 
 
            //Update boolean value to true if queen can be placed
            res = makeNQueenBoard(board, column + 1, n) || res; 
 
            //If placing queen at this problem doesn't give a solution, bactrack to the earlier row and remove the queen from its position and add to new position
            // BACKTRACK
            board[i][column] = ".";  
        } 
    } 
 
    //If queen cannot be placed in any column of this row, return false
    return res; 
} 
    
    
    private boolean isColumnAllowed(String[][] board, int row, int col, int n)
    {
        
        //Check row on left side
        for(int i=0; i<col; i++)
        {
            if(board[row][i]=="Q")
                return false;
        }
        
        //Check upper diagonal on left (takes care of values on the left columns of above rows)
        for(int i=row, j=col; i>=0 && j>=0; i--,j--)
        {
            if(board[i][j]=="Q")
                return false;
        }
        
        //Check lower diagonal on left (takes care of values on the left columns of below rows)
        for(int i=row, j=col; j>=0 && i<n; i++,j--)
        {
            if(board[i][j]=="Q")
                return false;
        }
        
        return true;
    }
}