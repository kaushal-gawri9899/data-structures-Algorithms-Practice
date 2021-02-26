class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        //the approach is to use indegree for a vertex, add all the vertices in the List whose indegree is zero
        
        int[] indegree = new int[n];
        List<Integer> list = new ArrayList();
        
        for(List<Integer> arr : edges)
        {
            indegree[arr.get(1)]++;
        }
        
        for(int i=0; i<n; i++){
            if(indegree[i]==0)
            {
                list.add(i);
            }
        }
        
        return list;
    }
}