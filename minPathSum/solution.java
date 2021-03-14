/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 */
class Solution {
    /*
    1 3 1
    1 5 1
    4 2 1
    
    All paths from 0,0 to row-1, col-1 will include  :
    These will be the test cases which are most optimal with the least length
    1->3->1->1->1
    1->3->5->1->1
    1->3->5->2->1
    1->1->5->1->1
    1->1->5->2->1
    1->1->4->2->1
    */

public int minPathSum(int[][] grid)
{
    int row = grid.length;
    int col = grid[0].length;
    int[][] dp = new int[row][col];
  
    for(int i=0; i<row; i++)
    {
        for(int j=0; j<col; j++)
        {
            if(i==0 && j==0)
                dp[i][j] = grid[i][j];
            
            else if(i==0 && j!=0)
                dp[i][j] = grid[i][j]+dp[i][j-1];
            
            else if(j==0 && i!=0)
                dp[i][j] = grid[i][j] + dp[i-1][j];
            
            else
                dp[i][j] = grid[i][j]+Math.min(dp[i-1][j], dp[i][j-1]);
                
        }
        
        
    }
    return dp[row-1][col-1];
}
/*Recursive approach*/
//     public int minPathSum(int[][] grid) {

//         return helper(grid, grid.length-1, grid[0].length-1);
//     }

//     private int helper(int[][] grid, int row, int col)
//     {
//         if(row==0 && col==0)
//            return grid[row][col];
    
//         if(row==0)
//             return grid[row][col]+helper(grid, row, col-1);
    
//         if(col==0)
//             return grid[row][col]+helper(grid, row-1, col);
    
//         return grid[row][col] + Math.min(helper(grid,row-1,col), helper(grid,row,col-1));
//     }
}