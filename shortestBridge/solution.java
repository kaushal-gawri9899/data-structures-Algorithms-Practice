/**
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 * 
 * Input: A = [[0,1],[1,0]]
 * Output: 1
 */
class Solution {
    public int shortestBridge(int[][] A) {
        
        /*
            0 1
            1 0
            
            Flip any one of the zero and all 1 would be connected
            
            0 1 0
            0 0 0
            0 0 1
            
            Flip any two zeros on 1,1 or 1,2 or 2,1 and all 1 would be connected
        */
        /*
        
        DFS + BFS
        
        The approach is to use basic dfs and bfs techniques, we need to first traverse through are graph using dfs to find the first island, we do not care about the second island, hence, as we find our first island we break out of our dfs 
        
        Once we find the first island, we need to start expanding it by flipping the zeros present in all the four directions. We increase the counter while going through it. Once we reach a point where A[i][j] is 1, we found the first 1 that connects are two island. At this point we can return the counter. 
        
        We can use a visited array to mark our position so that we don't need to change the graph
        */
        
        boolean flag = false;
        int row = A.length;
        int col = A[0].length;
        
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList();
        
        for(int i=0; i<row; i++)
        {    
                if(flag)
                    break;
        for(int j=0; j<col; j++)
            {
                if(A[i][j]==1)
                {
                    dfs(A,i,j,visited,queue);
                    flag = true;
                    break;
                }
            }
        }
        
        int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int distance = 0;
        
        while(!queue.isEmpty())
        {
            
            int size = queue.size();
            while(size-->0)
            {
                int[] current = queue.poll();
                
                for(int[] d : direction)
                {
                    int r = current[0] + d[0];
                    int c = current[1] + d[1];
                    
                    if(r<0 || c<0 || r>=row || c>=col || visited[r][c])
                        continue;
                    
                    if(A[r][c]==1)
                        return distance;
                    
                    queue.offer(new int[]{r,c});
                    visited[r][c]=true;
                }
            }
            distance++;
        }
        
        return -1;
        
    }
    
    private void dfs(int[][] A, int i, int j, boolean[][] visited, Queue<int[]> queue)
    {
        if(i<0 || j<0 || i>=A.length || j>=A[0].length || A[i][j]==0 || visited[i][j])
            return ;
        
        visited[i][j] = true;
        queue.offer(new int[]{i,j});
        
        dfs(A,i+1,j,visited,queue);
        dfs(A,i,j+1,visited,queue);
        dfs(A,i-1,j,visited,queue);
        dfs(A,i,j-1,visited,queue);
        
        
    }
}