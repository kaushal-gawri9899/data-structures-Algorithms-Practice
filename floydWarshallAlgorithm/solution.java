public class solution {
    
    final int INF = Integer.MAX_VALUE;
    
    public int[][] getShortestDistanceUsingFloydWarshall()
    {
        int[][] graph =  {{0  , 8 ,INF,12},
                          {INF, 0 , 4 , INF},
                          {INF,INF, 0 ,  1},
                          {INF,INF,INF,INF}
                         }; 
        
        int row = graph.length;
        int col = graph[0].length;
        
        int[][] shortesDist = new int[row][col];
        /**
         * First we will initialize our shortest distance matrix with the same values as our graph
         */
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                shortesDist[i][j] = graph[i][j];
            }
        }


        /**
         * Now, we will use a DP approach where shortestDist is our dp table
         * So, we first add all the vertices one by one to the set of intermediate vertices, here k is determined as the intermediate vertice to reach from i vertex to j vertex which we can use
         * ---- Before start of an iteration, we have the shortest distance between all pairs of vertices such that the shortest distance consider only the vertices from 1 to k-1
         * ---- After the iteration, if k is an intermediate vertex in shortest path from i to j, vertex k is now added such that the shortest distance now contains vertex k such that the shortes distance now consider the vertices from 1 to k
         */

         for(int k=0; k<row; k++)
         {
             for(int i=0; i<row; i++)
             {
                 for(int j=0; j<row; j++)
                 {
                     if(shortesDist[i][j]>shortesDist[i][k]+shortesDist[k][j])
                     {  
                         shortestDist[i][j] = shortestDist[i][k] + shortestDist[k][j];
                     }
                 }
             }
        }

        return shortesDist;
                      
    }
}
