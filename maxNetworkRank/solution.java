/**
 * There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.
 * The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.
 * The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
 * Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
 * 
 * Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * Output: 4
 * Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are connected to either 0 or 1. The road between 0 and 1 is only counted once.
 */
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
    int[] bidirect = new int[n];
    int[][] adjmatrix = new int[n][n];
        
        for(int i[] : roads)
        {
            int r1 = i[0];
            int r2 = i[1];
            
            //Increase the count for number of paths for both the values
            bidirect[r1]++;
            bidirect[r2]++;
            //In the adjmatrix, mark the presence of path for both r1-->r2 and r2--->r1 (bidriectional)
            adjmatrix[r1][r2]=1;
            adjmatrix[r2][r1]=1;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                //Max would be the sum of total number of paths for two vertices - (the common path they have given by adjmatrix)
                max = Math.max(max,bidirect[i]+bidirect[j]-adjmatrix[i][j]);
            }
        }
        return max;
    }
    
}