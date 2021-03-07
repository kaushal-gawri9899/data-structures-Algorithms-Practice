/**
 * In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.
 * (Note that backslash characters are escaped, so a \ is represented as "\\".)
 * Return the number of regions.
 * 
 * Input:
 *  [
 *   " /",
 *   "/ "
 *  ]
 * Output: 2
 */
class Solution {
    public int regionsBySlashes(String[] grid) {
        
        //Approach : 
        
        
        //Input : " /" , "/ "
        //If we convert this 1-d array in the form of that square grid, we can count the divisions then using dfs or bfs
        // Like for our input, we can create a grid to be like
        //
        /*
                [ ][/][ ][/]
                [/][ ][/][ ]
                [ ][/][ ][ ]
                [/][ ][ ][ ]
        //This is how the 2d grid will look if we upscale our 1d string by 2 times
        //Now using dfs we can check on all four directions for empty values and increase the count for the regions
        
        //Updated list by changing it to 0 and 1
                0 1 0 1
                1 0 1 0
                0 1 0 0
                1 0 0 0
        //NOW THIS CAN BE TAKEN AS NUMBER OF ISLAND PROBLEM IN WHICH WE COUNT THE Zero AS Island
        //But if we follow the same approach as that it will count the three zeros at 0,2 and 1,1 and 2,0 as 3 separate island, making the total as 5 instead of three as either the 0 are on boundary and/or surrounder by 1 from all sides.
        //Thus scaling it by 2 won't work and we would need to make a grid of larger size
                
                [ ][/][ ][ ][ ][/]
                [/][ ][ ][ ][/][ ]
                [ ][ ][ ][/][ ][ ]
                [ ][ ][/][ ][ ][ ]
                [ ][/][ ][ ][ ][ ]
                [/][ ][ ][ ][ ][ ]
                
                //Updated list by changing it to 0 and 1
                
                0 0 1 0 0 1
                0 1 0 0 1 0
                1 0 0 1 0 0
                0 0 1 0 0 0
                0 1 0 0 0 0
                1 0 0 0 0 0
                
            Now, in this case the zeros that were first considered as separate will now be considered as a single island and won't be counted separately
            //So we need to have the size of grid to be atleast 3*N
            
        */
    
        int len = grid.length;
        int[][] graph = new int[3*len][3*len];
        
        for(int i=0; i<3*len; i++)
            Arrays.fill(graph[i], 0);
        
        
        //Now transforming our matrix will make the problem similar to number of islands
        for(int i=0; i<len; i++)
        {
            for(int j=0;j<len; j++)
            {
                if(grid[i].charAt(j)=='/')
                {
                    graph[3*i][3*j+2]=1;
                    graph[3*i+1][3*j+1]=1;
                    graph[3*i+2][3*j]=1;

                }
                else if(grid[i].charAt(j)=='\\')
                {
                    graph[3*i][3*j] = 1;  
                    graph[3*i+1][3*j+1] = 1;
                    graph[3*i+2][3*j+2] = 1;
                }
            }
        }
        
        int region=0;
        for(int i=0; i<3*len; i++)
        {
            for(int j=0; j<3*len; j++)
            {
                if(graph[i][j]==0)
                {
                    region++;
                    dfs(graph,i,j);
                }
            }
        }
        
        return region;
        
    }
    
    
    private void dfs(int[][] graph, int i, int j)
    {
        if(i<0 || j<0 || i>=graph.length || j>=graph[0].length || graph[i][j]!=0)
            return ;
        
        graph[i][j] = 1;
        
        dfs(graph,i+1,j);
        dfs(graph,i,j+1);
        dfs(graph,i-1,j);
        dfs(graph,i,j-1);
        
    }
}