/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 */

class Solution {
    public int numIslands(char[][] grid) {
        
        //We can use dfs and recursively check for four positions, i+1.i-1,j+1 and j-1 , we mark them on each recursive search so that no position can be counted twice. 
        
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                //Use depth first search for the element that has value '1' in the grid
                //It checks for north, south, east and west of current position for '1'
                if(grid[i][j]=='1')
                {
                   
                    numIslandsHelper(grid,i,j, row, col);
                    //We increase the count of the island 
                    count++;
                }
            }
        }
        return count;
    }
    
    private void numIslandsHelper(char[][] grid, int i, int j, int row, int col)
    {
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j]!='1')
            return;
        
        
        grid[i][j] = '2';
        
        numIslandsHelper(grid,i+1,j,row,col);
        numIslandsHelper(grid,i,j+1,row,col);
        numIslandsHelper(grid,i-1,j,row,col);
        numIslandsHelper(grid,i,j-1,row,col);
    }
}