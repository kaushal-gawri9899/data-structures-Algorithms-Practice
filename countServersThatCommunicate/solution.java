/**
 * You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.
 * Return the number of servers that communicate with any other server.
 * 
 * Input: grid = [[1,0],[0,1]]
 * Output: 0
 * Explanation: No servers can communicate with others.
 */

class Solution {
    public int countServers(int[][] grid) {
      
        int R = grid.length;
        int C = grid[0].length;
        int[] inRow = new int[R];
        int[] inCol = new int[C];
        
        int servers = 0;
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++) {
                if(grid[i][j]==1)
                {
                    inRow[i]++;
                    inCol[j]++;
                    //servers++;
                }
            }
        }
        
        System.out.println(servers);
        /*
        1 0
        1 1
        
        inRow : 1 3
        inCol : 2 2
        */
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(grid[i][j]==1 && (inRow[i]>1 || inCol[j]>1))
                    servers++;
                    //if(inRow[i]==1 && inCol[j]==1)
                    //servers--;
            }
        }
        
        return servers;
    }
}