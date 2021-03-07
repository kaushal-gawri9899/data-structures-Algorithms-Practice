/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * 
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 *
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //We can either use BFS or DFS to traverse through our matrix and increase the counter for each 1 such with the distance to the nearest zero
        //As the solution asks for nearest cells, bfs is a better approach as if we consider it as a graph, BFS first traverse for all the adjacent neighbours, that is it will search for shortest distance for all nodes at it levels whereas dfs will do it level wise and hence would be slow
        
        Queue<int[]> queue = new LinkedList();
        
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j]==0)
                    queue.offer(new int[]{i,j});
                else
                    matrix[i][j] = -1;
            }
        }
        
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        int distance=0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            distance++;
            
            while(size>0)
            {
            int[] current = queue.poll();
            for(int[] d : directions)
            {
                int row = current[0] + d[0];
                int col = current[1] + d[1];
                
                if(row<0 || col<0 || row>=matrix.length || col>=matrix[0].length || matrix[row][col]!=-1)
                    continue;
                
                matrix[row][col] = distance;
                
                queue.add(new int[]{row,col});
            }
               size--;
            }
        }
        
        return matrix;
    }
}