class Solution {
    public void solve(char[][] board) {
        
        int row = board.length;
        int col = board[0].length;
        
        boolean[][] visited = new boolean[row][col];
        
        //Check for all O in 1st column
        for(int i=0; i<row; i++)
        {
            if(board[i][0]=='O')
                isVisited(board,visited,i,0);
        }
        
        //Check for all O in last column
        for(int i=0; i<row; i++)
        {
            if(board[i][col-1]=='O')
                isVisited(board,visited,i,col-1);
        }
        
        //Check for all O in 1st row
        for(int j=0; j<col; j++)
        {
            if(board[0][j]=='O')
                isVisited(board,visited,0,j);
        }
        
        //Check for all O in last row
        for(int j=0; j<col; j++)
        {
            if(board[row-1][j]=='O')
                isVisited(board,visited,row-1,j);
        }
        
        //Now change the O to x for all unmarked O
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(board[i][j]=='O' && !visited[i][j])
                    board[i][j]='X';
            }
        }
    }
    
    private void isVisited(char[][] board, boolean[][] visited, int i, int j)
    {
        
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O' || visited[i][j])
            return;
            
      
            visited[i][j]=true;
            isVisited(board,visited,i+1,j);
            isVisited(board,visited,i,j+1);
            isVisited(board,visited,i-1,j);
            isVisited(board,visited,i,j-1);
        
    }
}