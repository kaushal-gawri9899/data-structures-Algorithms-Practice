/**
 *  In this problem, a tree is an undirected graph that is connected and has no cycles.
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v. 
 *
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this: 
 * 
 *    5--1--2
 *       |  |
 *       4--3 
 */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        /** 
        We can add all the edges in different disjoint sets
        We then check the reference of each set and once we find any rebundancy, we return those elements which is the extra edge
        This could be easily done through union find
        first initialize the parent array 
        For each edge e in our edges array, find the reference for e[0] and e[1]
        If the reference is same, this edge results in cycle, return this edge
        Add the reference of element 1 as element 2 (make a subset)
        */
        
        int[] parent = new int[edges.length+1];
        
        for(int i=0; i<parent.length; i++)
            parent[i] = i;
        
        for(int[] e : edges)
        {
            int x = find(parent, e[0]);
            int y = find(parent, e[1]);
           
            if(x==y)
                return e;
            
            parent[x] = y;
        }
        
        return new int[0];
        }
    
    
        public int find(int[] parent,int key)
        {
            if(parent[key]==key)
                return key;
            
            return find(parent,parent[key]);
        }
        
       
}