/**
 * There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.
 * Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.
 * Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path
 * Input: n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * Output: 3
 * Explanation: The figure above describes the graph. 
 * The neighboring cities at a distanceThreshold = 4 for each city are:
 * City 0 -> [City 1, City 2] 
 * City 1 -> [City 0, City 2, City 3] 
 * City 2 -> [City 0, City 1, City 3] 
 * City 3 -> [City 1, City 2] 
 * Cities 0 and 3 have 2 neighboring cities at a distanceThreshold = 4, but we have to return city 3 since it has the greatest number.
 */
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        /*
        An implementation using Floyd Warshall
        O(n^3) time complexity and O(n^2) space
        
        */
        int[][] bidirect = new int[n][n];
        
        for(int[] i : bidirect)
            Arrays.fill(i,100000);
        
        //Add the distance to our adj maxtrix, for both 0,1 and 1,0 as bidirectional
        /*
        10000 3     10000 10000
        10000 10000 1       4
        10000 10000 10000   1
        10000 10000 10000 10000
        
        
        */
        for(int[] elem : edges)
        {
            bidirect[elem[0]][elem[1]] = elem[2];
            bidirect[elem[1]][elem[0]] = elem[2];
        }
        
        //As the distance for a node to itself is 0 (1<--->1)
        /*
        0     3     10000 10000
        10000 0     1       4
        10000 10000 0       1
        10000 10000 10000   0
        */
        for(int i=0; i<n; i++)
            bidirect[i][i] = 0;
        
        
        for(int i=0; i<n; i++)
        {
          for(int j=0; j<n; j++)
           {
            for(int index=0; index<n; index++)
              {
            bidirect[j][index] = Math.min(bidirect[j][index], bidirect[j][i]+bidirect[i][index]);
              }
           }
        }

        
        int lowCount = n;
        int city = 0;
        
        //Iterate in our adjmatrix
        //we don't consider the values when i==j as distance is always zero for them
        //if the value at i,j is less then distance we increase the count for that vertex(row)
        //we update the lowCount and store the vertex as the city to be returned
        for(int i=0; i<n; i++)
        {
            int count =0;
            for(int j=0; j<n; j++)
            {
                // if(i==j)
                //     continue;
                
                if(bidirect[i][j]<=distanceThreshold)
                    ++count;
                    
            }
            
            if(count<=lowCount)
            {
                lowCount = count;
                city = i;
            }
            
        }
        return city;
    }
}
