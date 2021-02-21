/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 */
class Solution {
    public void solve(char[][] board) {
        
        int row = board.length;
        int col = board[0].length;
        
        boolean[][] checked = new boolean[row][col];
        
        //If there's a O in 1st column, we check for the 2nd column for any 'O' and mark them
        for(int i=0; i<row; i++)
        {
            if(board[i][0]=='O')
                isChecked(board,checked,i,1);
        }
        
        //If there's a O in last column, we check for the column-1 for any 'O' and mark them
        for(int i=0; i<row; i++)
        {
            if(board[i][col-1]=='O')
                isChecked(board,checked,i,col-2);
        }
        
        
        //If there's a O in 1st row, we check for the 2nd row for any 'O' and mark them
        for(int j=0; j<col; j++)
        {
            if(board[0][j]=='O')
                isChecked(board,checked,1,j);
        }
        
        
        //If there's a 0 in last row, we check for row - 1 for any 'O' and mark them
        for(int j=0; j<col; j++)
        {
            if(board[row-1][j]=='O')
                isChecked(board,checked,row-2,j);
        }
        
        //Change the values except for marked 'O' and 1st row,column and last row,column
        for(int i=1; i<row-1; i++){
            for(int j=1; j<col-1; j++)
            {
                //Checks if we find a 'O' and can flip 'O' to 'X'
                if(board[i][j]=='O' && !checked[i][j])
                    board[i][j] = 'X';
            }
        }
        
    }
    
    private void isChecked(char[][] board, boolean[][] checked, int row, int col)
    {
        if(row<0 || col<0 || row>=board.length || col>=board[0].length)
            return;
        
        if(board[row][col]=='O' && !checked[row][col])
        {
            checked[row][col] = true;
            isChecked(board,checked,row-1,col);
            isChecked(board,checked,row,col-1);
            isChecked(board,checked,row+1,col);
            isChecked(board,checked,row,col+1);
            
        }
    }
    
}