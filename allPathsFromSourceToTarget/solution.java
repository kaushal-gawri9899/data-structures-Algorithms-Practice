/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        
        List<Integer> pathList = new ArrayList();
        pathList.add(0);
        
        List<List<Integer>> allpathslist = new ArrayList();
        
        allPathSourceTargetUtil(0,graph.length-1,graph,visited,pathList,allpathslist);
        
        return allpathslist;
    }
    
    private void allPathSourceTargetUtil(int source, int destination, int[][] graph,boolean[] visited,List<Integer> pathList, List<List<Integer>> allPaths)
    {
        //We add in the list only when we reach the destination that is the last n-1
        if(source==destination)
        {
            allPaths.add(new ArrayList<>(pathList));
            return;
        }

        //Mark the vertex currently visited
        visited[source] = true;
        
        for(int i : graph[source])
        {
            if(!visited[i])
            {
                pathList.add(i);
                //Recursively call the function for next vertex i
                allPathSourceTargetUtil(i,destination,graph,visited,pathList,allPaths);
                //remove current vertex
                pathList.remove(pathList.size()-1);
           }
        }
        
      visited[source] = false;
    }
}