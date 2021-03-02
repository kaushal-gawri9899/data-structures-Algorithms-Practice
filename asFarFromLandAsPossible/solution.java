/**
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *
 * Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
 */
class Solution {
    
    
    public int maxDistance(int[][] grid)
    {
        int[][] direction = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
        Queue<int[]> queue = new LinkedList();
        
        int row = grid.length;
        int col = grid[0].length;
        
        if(row==0 || col==0)
            return -1;
        
        boolean[][] visited = new boolean[row][col];
        
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(grid[i][j]==1)
                {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        
        if(queue.size() == row*col)
            return -1;
        
        int total=0;
        while(queue.size()>0)
        {
            total++;

            int size = queue.size();
            while(size-- >0)
            {
            int[] current = queue.poll();
                
                for(int[] dir : direction)
                {
                    int currRow = current[0]+dir[0];
                    int currCol = current[1]+dir[1];
                    
                    if(currRow>=0 && currCol>=0 && currRow<row && currCol<col && !visited[currRow][currCol])
                    {
                        visited[currRow][currCol] = true;
                        queue.offer(new int[]{currRow,currCol});
                    }
                }
            }   
        }
  
            return total-1;

    }

//     public int maxDistance(int[][] grid) {
//         for(int i=0; i<grid.length; i++)
//         {
//             for(int j=0; j<grid.length; j++)
//             {
//                 if(grid[i][j]==1)
//                 {
//                 grid[i][j]=0;
//                 dfs(grid, i, j,1);
//                 }
//             }
//         }
    
//         int max  = -1;
    
//          for(int i=0; i<grid.length; i++)
//         {
//             for(int j=0; j<grid.length; j++)
//             {
//                 if(grid[i][j]>1)
//                 {
//                     max = Math.max(max, grid[i][j]-1);
//                 }
//             }
//          }
    
//         return max;
//     }

//     private void dfs(int[][] graph, int i, int j, int distance)
//     {
//         if(i<0 || j<0 || i>=graph.length || j>=graph[0].length || (graph[i][j]!=0 && graph[i][j]<=distance))
//             return;
    
//         graph[i][j] = distance;
       
//         dfs(graph, i, j+1, distance+1);
//         dfs(graph, i+1, j, distance+1);
//         dfs(graph, i, j-1, distance+1);
//         dfs(graph, i-1, j, distance+1);
    
    
//     }
}