/**
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * 
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * 
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        
        //A general graph question which can be done through both bfs and dfs
        
        Queue<int[]> queue = new LinkedList();
        
        int freshOrange=0;
        int row = grid.length;
        int col = grid[0].length;
        
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(grid[i][j]==2)
                    queue.offer(new int[]{i,j});
                else if(grid[i][j]==1)
                    freshOrange++;
            }
        }
        
        if(freshOrange==0)
            return 0;
    
        int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        int total=0;
        while(!queue.isEmpty())
        {
            if(freshOrange==0)
                return total;
            else
                total++;
            
          int size = queue.size();
          for(int i=0; i<size; i++)
          {
              int[] current = queue.poll();
              
              for(int d[] : directions)
              {
                  int x = current[0]+d[0];
                  int y = current[1]+d[1];
                  
                  if(x<0 || y<0 || x>=row || y>=col || grid[x][y]==0 || grid[x][y]==2)
                      continue;
                  
                  grid[x][y] = 2;
                  queue.offer(new int[]{x,y});
                  freshOrange--;
                  
              }
          }
        }
        
        if(freshOrange==0)
            return total;
        else
            return -1;
    }
}
        
    //Approach using DFS
    
//     public int orangesRotting(int[][] grid) {
//         if(grid==null || grid.length==0)
//             return -1;
        
//         int row=grid.length;
//         int col=grid[0].length;
        
    
//         for(int i=0; i<row; i++)
//         {
//             for(int j=0; j<col; j++)
//             {
//                 if(grid[i][j]==2)    
//                 {
//                     dfs(grid,i,j,2);
//                 }
//             }
//         }
        
//         int min =2;
        
//         for(int[] r : grid)
//         {
//             for(int c : r)
//             {
//                 if(c==1)
//                     return -1;
                
//                 min = Math.max(min,c);
//             }
//         }
        
//         return min-2;
      
        
//     }
    
//     private void dfs(int[][] grid, int i, int j, int minutes)
//     {
//         if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 || (1<grid[i][j] && grid[i][j]<minutes))
//             return;
       
//         grid[i][j] = minutes;
        
//         dfs(grid,i+1,j,minutes+1);
//         dfs(grid,i,j+1,minutes+1);
//         dfs(grid,i-1,j,minutes+1);
//         dfs(grid,i,j-1,minutes+1);
    
        
//     }
    
//}