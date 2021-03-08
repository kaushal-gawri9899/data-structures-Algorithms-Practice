/**
 * On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
 * A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
 * Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
 * 
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Explanation: One way to remove 5 stones is as follows:
 * 1. Remove stone [2,2] because it shares the same row as [2,1].
 * 2. Remove stone [2,1] because it shares the same column as [0,1].
 * 3. Remove stone [1,2] because it shares the same row as [1,0].
 * 4. Remove stone [1,0] because it shares the same column as [0,0].
 * 5. Remove stone [0,1] because it shares the same row as [0,0].
 * Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
 */
class Solution {
    public int removeStones(int[][] stones) {
        
        /*
            1 1 0
            1 0 1
            0 1 1
            (Here 1 denotes the stones)
            
            The total number of unique stones in this case is 6
            Now, we can consider removing a stone one by one using dfs and the number of islands is taken as the stones left in the last
            This is explained by say we consider all the connected stones connected througgh row and columns as a graph and when we remove stone one by one, the number of island would be the stones left at last given through the description. (we consider a cell to a part of an island if it has same row or col instead of just adjacent cells.)
            Hence, for this example as all the 1 are connected to each other through row and column, it can be considered as one island. 
            
            So, the approach is to first build a graph using a HashMap and keep track of all the visited nodes using a HashSet as the search operation would be O(1) in hashSet 
            
            Now, operate dfs on our graph and keep on marking the values in our hashset and for all the stones in a particular row or column, keep on searching using dfs and increase the numberOfIslands
            
        */
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=0; i<stones.length-1; i++)
        {
            for(int j=i+1; j<stones.length; j++)
            {
                //If the stones share either the same row or same column
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                {
                    if(!graph.containsKey(i))
                        graph.put(i,new ArrayList());
                    
                    if(!graph.containsKey(j))
                        graph.put(j, new ArrayList());
                    
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        HashSet<Integer> marked = new HashSet<>();
        
        int numOfIslands = 0;
        for(int i=0; i<stones.length; i++)
        {
            if(!marked.contains(i))
            {
                dfs(graph, i, marked);
                numOfIslands++;
            }
        }
        
        return stones.length - numOfIslands;
    }
    
    
    private void dfs(HashMap<Integer, List<Integer>> graph, int position, Set<Integer> marked)
    {
        marked.add(position);
        
        //If the graph doesn't have a stone at given root (row or column)
        if(!graph.containsKey(position))
            return;
        
        for(int curr : graph.get(position))
        {
            if(!marked.contains(curr))
                dfs(graph,curr,marked);
        }
    }
}