/**
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 */
class Solution {
    int result = 0;
    public int islandPerimeter(int[][] grid) {
        
        /*
        0 1 0 0
        1 1 1 0
        0 1 0 0
        1 1 0 0
    
        
        We can increase the permiter value by 4 once we find any value to be 1, but if it has a neighbour at right or down, we need to reduce the permiter value by two each time (we only care about down and right because the other two values will already be taken care of by other grids above current grid)
        */
        
        int row = grid.length;
        int col = grid[0].length;
        
        int permiter=0;
        
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
            if(grid[i][j]==1)
            {
                permiter+=4;
              
            if(j+1<col && grid[i][j+1]==1)
                permiter-=2;
            
            if(i+1<row && grid[i+1][j]==1)
                permiter-=2;
                
            }
            }
        }
        
        return permiter;
    }
    

    
}