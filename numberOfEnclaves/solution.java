/**
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
 * A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
 * Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
 *
 * Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
 */
class Solution {
    public int numEnclaves(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        
        if(grid==null || row==0)
            return 0;
        
        // checking for left and right boundaries
        for(int i=0; i<row; i++)
        {
            //right
            dfs(grid,i,col-1);
            //left
            dfs(grid,i,0);
        }
        
        // checking for top and bottom boundaries
        for(int j=0; j<col; j++)
        {
            //top
            dfs(grid,0,j);
            
            //bottom
            dfs(grid,row-1,j);
        }
        

        
        int total=0;
        
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(grid[i][j]==1)
                    total++;
            }
        }
        
        return total;
    }
    
    private void dfs(int[][] grid, int i, int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
            return;
        
        grid[i][j]=0;
        
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
}