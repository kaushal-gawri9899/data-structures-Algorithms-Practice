/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 * 
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 */
class Solution {
    
    public int findCircleNum(int[][] isConnected) {
        
        /*
           1  1  0
           1  1  0
           0  0  1
        */
        
        int row = isConnected.length;
        int province = 0;
        boolean[] visited = new boolean[row];
        
        //The rows define one of the city. So we iterate through all the cities and using dfs we check if current city i is connected to another city j where j are a set of all the cities 
        for(int i=0; i<row; i++)
        {
            if(!visited[i])
            {
                dfs(isConnected,i,i,visited);
                province++;
            }
        }
        
        return province;
        
    }
    
    private void dfs(int[][] isConnected,int start, int i, boolean[] visited)
    {
        for(int j=start; j<isConnected.length; j++)
        {
            if(isConnected[i][j]==1 && !visited[j])
            {
                visited[j]=true;
                dfs(isConnected,start,j,visited);
            }
        }
    }
}