/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical). You may assume all four edges of the grid are surrounded by water.
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island has the same shape as another island (and not rotated or reflected).
Example 1:

Input: 
  [
    [1,1,0,0,1],
    [1,0,0,0,0],
    [1,1,0,0,1],
    [0,1,0,1,1]
  ]
Output: 3
Explanation:
  11   1    1
  1        11   
  11
   1

Example 2:

Input:
  [
    [1,1,0,0,0],
    [1,1,0,0,0],
    [0,0,0,1,1],
    [0,0,0,1,1]
  ]
Output: 1


 */

 
public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        
        int row = grid.length;
        int col = grid[0].length;
        
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        
        // int[][] directions = {{0,-1}, {-1,0}, {1,0}, {0,1}};
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                List<Integer> islands = new ArrayList();
                if(grid[i][j]==1)
                {
                    numberofDistinctIslandsHelper(grid,i,j,i,j,islands,row,col);
                    result.add(islands);
                }
            }
        }
        
        return result.size();
    }
    
    private void numberofDistinctIslandsHelper(int[][] grid, int i, int j, int x, int y, List<Integer> islands, int row, int col)
    {
        
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j]!=1)
        return;
        
        grid[i][j]=2;
        
        islands.add(x-i);
        islands.add(y-j);
      
        
        numberofDistinctIslandsHelper(grid,i+1,j,x,y,islands,row,col);
        numberofDistinctIslandsHelper(grid,i,j+1,x,y,islands,row,col);
        numberofDistinctIslandsHelper(grid,i-1,j,x,y,islands,row,col);
        numberofDistinctIslandsHelper(grid,i,j-1,x,y,islands,row,col);
        
    }
}