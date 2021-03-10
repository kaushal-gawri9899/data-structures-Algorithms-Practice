/**
 * Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid square at that location.
 * Two squares belong to the same connected component if and only if they have the same color and are next to each other in any of the 4 directions.
 * The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
 * Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of that square with the given color, and return the final grid.
 *
 * Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * Output: [[1, 3, 3], [2, 3, 3]] 
 */
class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        
        /*
        1 1 = 3 3            1 2 2   = 1 3 3
        1 2   3 2            2 3 2     2 3 3
        
        Here, we change the color of a square on grid only if the value is same on any of the 4 directions, that is two similar element adjacent to each other either in a row or a column and have the same value
        
        We can use a dfs or bfs approach 
        Using dfs we can first mark the nodes in our visited array for all the positions having grid[i][j] == grid[r0][c0]
        Now, the next step would be to update the boundaries for which we need to make another pass
        So, for the all positions marked in visited array, we check for all the four adjacent values, such that if the adjacent positions aren't updated to 1 in visited, we change them to color in our grid
        
        */
        int[][] visited = new int[grid.length][grid[0].length];
        
        dfs(grid,color,r0,c0,visited,grid[r0][c0]);
        
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(visited[i][j]!=1)
                    continue;
                
                for(int[] d : dir)
                {
                    int row = i+d[0];
                    int col = j+d[1];
                    
                    //Switching the border values
                    if(row<0 || col<0 || row==grid.length || col==grid[0].length || visited[row][col]!=1)
                        grid[i][j] = color;
                }
            }
        }
        
        return grid;
    }
    
    public void dfs(int[][] grid, int color, int i, int j, int[][] visited, int oldColor)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=oldColor ||                 visited[i][j]==1)
            return;
        
        visited[i][j]=1;
        
        dfs(grid,color,i+1,j,visited,oldColor);
        dfs(grid,color,i,j+1,visited,oldColor);
        dfs(grid,color,i-1,j,visited,oldColor);
        dfs(grid,color,i,j-1,visited,oldColor);
        
        
    }
}