/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation: 
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 */
class Solution {

    //Create a HashMap that maps the strings provided in queries with their values as say two strings at position i of equations are "a" and "b" and their respective value is values[i] say 1.5. Thus here, "a"/"b" = 1.5, so we can add  a value say "a" in the graph whose value is a pair containing String as "b" and respective value as values[i]. Similarly we can have "b" in our graph as key with value containing a Pair of "a" and respective value as 1/values[i]
    
    // Now we can use dfs to travel through our graph and travel through all the numerators such that the result of the query can be given as the product of their respective value in values[] array and the value determined after each recursion. Like, ["a","b"] = 2.0 and ["b","c"] = 3.0 so, ["a","c"] = 2.0 * 3.0 = 6.0
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        HashMap<String, ArrayList<Pair>> graph = new HashMap<>();
        
        for(int i=0; i<equations.size(); i++)
        {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            
            if(!graph.containsKey(s1))
            {
             graph.put(s1, new ArrayList<Pair>());
            }
            
            if(!graph.containsKey(s2))
            {
                graph.put(s2, new ArrayList<Pair>());
            }
            
            graph.get(s1).add(new Pair(s2,values[i]));
            graph.get(s2).add(new Pair(s1,1/values[i]));
        }
        
        double[] result = new double[queries.size()];
        
        for(int i=0; i<queries.size(); i++)
        {
            result[i] = dfs(graph,queries.get(i).get(0),queries.get(i).get(1),new HashSet<String>());
        }
        
        return result;
    }
    
    private double dfs(Map<String, ArrayList<Pair>> graph, String numerator, String denominator, Set<String> visited)
    {
        if(!graph.containsKey(numerator) || !graph.containsKey(denominator))
            return -1.0;
        
        if(numerator.equals(denominator))
            return 1.0;
        
        visited.add(numerator);
        ArrayList<Pair> current = graph.get(numerator);
        
        for(int i=0; i<current.size(); i++)
        {
            if(!visited.contains(current.get(i).node))
            {
                double val = dfs(graph,current.get(i).node,denominator,visited);
                
                if(val!=-1.0)
                    return current.get(i).value*val;
            }
        }
        
        return -1.0;
    }
    
    
    class Pair{
        String node;
        double value;
        
        Pair(String node, double value)
        {
            this.node = node;
            this.value = value;
        }
    }
}