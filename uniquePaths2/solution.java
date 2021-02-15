/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.
 */

class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
      //We can use DP for this question or can make use of recursion(a bottom up or top down approach might yield time limit exceeded though)
        
        //Basic DP solution
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0]==1)
            return 0;
        
        //Make sure to mark the first element as the number of path for reaching starting cell is 1
        obstacleGrid[0][0] = 1;
        //Adding the value for first column
        for(int i=1; i<row; i++)
        {
           
            //Checking if there's a way one position down of obstacle
           if(obstacleGrid[i][0]==0 && obstacleGrid[i-1][0]==1)
               obstacleGrid[i][0] = 1;
            else
                obstacleGrid[i][0] = 0;
        }
        
        //Adding the value for first row
        for(int j=1; j<column; j++)
        {
            //Checking if there's a way one position right of obstacle
            if(obstacleGrid[0][j]==0 && obstacleGrid[0][j-1]==1)
                obstacleGrid[0][j] = 1;
            else
                obstacleGrid[0][j] = 0;
        }
        
        //Now iterate and start filling up the values for our dp table
        
        for(int i=1; i<row; i++)
        {
            for(int j=1; j<column; j++)
            {
                if(obstacleGrid[i][j]==0)
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                else
                    obstacleGrid[i][j] = 0;
            }
        }
        
        return obstacleGrid[row-1][column-1];
        
    }

    /**
    DP TABLE
    Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]

    Dry Run for new obstacleGrid (similar to say adding a breadcrumb to the available path)
    //Final will look like this
       1 1 1
       1 0 1
       1 1 2

     */
    
    //RECURSIVE SOLUTION - Not optimal for large inputs
    
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int row = obstacleGrid.length;
//         int column = obstacleGrid[0].length;
        
//         int[][] maze = new int[row][column];
        
//         maze[0][0] = 1;
        
        
//         return getAllPaths(obstacleGrid, row-1, column-1, maze);
        
//     }
    
    
//     private int getAllPaths(int[][] obstacleGrid, int row, int column, int[][] maze)
//     {
//         //Stating the obstacle
//         if(obstacleGrid[row][column]==1)
//             return 0;
        
//         //base condition
//         if(maze[row][column]!=0)
//             return maze[row][column];
        
        
//         int side =0;
//         int up = 0;
        
//         if(row-1>=0)
//            up=getAllPaths(obstacleGrid,row-1,column,maze);
        
//         if(column-1>=0)
//             side=getAllPaths(obstacleGrid,row,column-1,maze);
        
//         return side+up; 
        
//     }
    
    
    
    
}