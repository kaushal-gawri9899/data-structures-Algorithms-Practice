/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 */

class Solution {

    //Better is to use a DP approach for larger inputs as recursive will increase the stack memory and time limit
    
    public int uniquePaths(int m, int n) {
        
        int[][] maze = new int[m][n];
        
        //Mark first column with 1
        for(int i=0; i<m; i++)
            maze[i][0] = 1;
        
        //Mark first row with 1
        for(int j=0; j<n; j++)
            maze[0][j] = 1;
        
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                //Update the values based on left and right criteria
                maze[i][j] = maze[i-1][j] + maze[i][j-1];
            }
        }
        
        //We return the last value caculated which is the sum of all possible paths
        return maze[m-1][n-1];
    }
    

//DP table for a input of m = 3 and n =7
    //  1 1 1
    //  1 2 3
    //  1 3 6
    //  1 4 10
    //  1 5 15
    //  1 6 21
    //  1 7 28
    
// Answer is 28



    //     public int uniquePaths(int m, int n) {
        
        
        
//         //Directions,  but as we start from bottom, m-1 and n-1
//         //top left corner : i=0, j=0 and bottom right corner : i=m-1;j=n-1
//         //A recursive approach to travel to all the paths starting from the finish
        
//         int toReturn = findPath(m,n, new int[m+1][n+1]);
//         return toReturn;
        
        
//     }
    
//     private int findPath(int m, int n, int[][] maze)
//     {
//         if(m<=0 || n<=0)
//             return 0;
        
//         if(m==1 && n==1)
//             return  1;
        
//         if(maze[m][n]!=0)
//         {
//            return maze[m][n];
//         }
        
//         return findPath(m-1,n,maze)+findPath(m,n-1,maze);
        
//     }
}