/**
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
 * Return true if and only if it is bipartite.
 * 
 * Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * Output: false
 * Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
 */
class Solution {
    public boolean isBipartite(int[][] graph) {

        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {

            // If and only if the current vertex has neighbors and isn't being marked in a
            // set yet
            if (graph[i].length != 0 && visited[i] == 0) {
                Queue<Integer> queue = new LinkedList();
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int current = queue.poll();

                    for (int curr : graph[current]) {
                        if (visited[curr] == 0) {
                            // If current vertex is marked, add its neighbour in 2nd set
                            if (visited[current] == 1) {
                                visited[curr] = 2;

                            }
                            // Else add its neighbour in 1st set
                            else {
                                visited[curr] = 1;
                            }
                            queue.offer(curr);
                        }
                        // If both the current vertex and its neighbour vertex is either in similar set,
                        // return false;
                        else {
                            if (visited[curr] == visited[current])
                                return false;
                        }
                    }

                }
            }
        }

        return true;

    }
    // Let there be two sets, 1 be first set and -1 be another set
    // We first check if the set[i] is zero which states its not being marked
    // If true we recursively traverse through all its neighbours using dfs
    // If set is now marked, check if the current set value is equal to what is is
    // to be now (given it wasn't marked ye)
    // If it is not marked, mark it with current value and then mark all its
    // neighbour with negative of current value
    // public boolean isBipartite(int[][] graph) {

    // int[] sets = new int[graph.length];

    // for(int i=0; i<graph.length; i++)
    // {
    // if(sets[i]==0 && !dfs(graph,sets,1,i))
    // return false;
    // }
    // return true;
    // }

    // private boolean dfs(int[][] graph, int set[], int value, int node){

    // if(set[node]!=0)
    // {
    // if(set[node]==value)
    // return true;
    // else
    // return false;
    // }

    // set[node] = value;
    // for(int curr : graph[node])
    // {
    // if(!dfs(graph,set,-value,curr)){
    // return false;
    // }
    // }

    // return true;
    // }
}