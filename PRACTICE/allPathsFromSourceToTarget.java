class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        /*
          A basic DFS approach to go through each vertex and keep on marking the visited vertex. Once we reach our destination, we add the current vertext in our arraylist
          The source vertex starts from zero and later on is given by the values in our graph (2d array), thus we have to iterate over it as well to get all the vertices.
        */
        
        boolean[] visited = new boolean[graph.length];
        
        List<Integer> paths = new ArrayList();
        paths.add(0);
        
        List<List<Integer>> allPaths = new ArrayList();
        
        dfs(0,graph.length-1, paths,allPaths,visited,graph);
        
        return allPaths;
    }
    
    private void dfs(int source, int destination, List<Integer> paths, List<List<Integer>> allPaths, boolean[] visited, int[][] graph)
    {
        if(source==destination)
        {
            allPaths.add(new ArrayList<>(paths));
            return;
        }
        
        visited[source] = true;
        
        for(int val : graph[source])
        {
            if(!visited[val])
            {
                paths.add(val);
                
                dfs(val,destination,paths,allPaths,visited,graph);
                
                paths.remove(paths.size()-1);
            }
        }
        
        visited[source] = false;
        
    }
}