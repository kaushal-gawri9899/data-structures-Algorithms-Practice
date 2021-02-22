/**
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
 * Find the smallest set of vertices from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.
 * Notice that you can return the vertices in any order.
 * 
 * Input: n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
 * Output: [0,3]
 * Explanation: It's not possible to reach all the nodes from a single vertex. From 0 we can reach [0,1,2,5]. From 3 we can reach [3,4,2,5]. So we output [0,3].
 */

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        //A graph problem where we can keep a track of inDegree and outDegree
        //The vertices with zero inDegree should be selected as the set of vertices to reach all                nodes
        
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        
        List<Integer> smallestSet = new ArrayList();
        
        for(List<Integer> l : edges)
        {
            int p1 = l.get(0);
            int p2 = l.get(1);
            
            outDegree[p1]++;
            inDegree[p2]++;
        }
        
        
        for(int i=0; i<n; i++)
        {
            if(inDegree[i]==0)
            {
                smallestSet.add(i);
            }
        }
        
        return smallestSet;
    }
}
