/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group. 
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3] 
 */
class Solution {
    
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        
        /*
        It can be solved using a disjoint union find technique
        Basically we divide people in subsets and check for any similiarity in dislikes array
        Whenever we find it equal, return false
        Else return true
        */
        
        int[] parent = new int[N+1];
        
        for(int i=1; i<=N; i++)
        {
            parent[i]=i;
        }
        
        for(int j=0; j<dislikes.length; j++)
        {
            int a = dislikes[j][0];
            int b = dislikes[j][1];
            
            //Add the two nodes in two different sets
            if(parent[b]==b)
                parent[b] = a;
            
            else{
                int[] obj1 = find(a,parent);
                int[] obj2 = find(b,parent);
                
                //If the conflicting nodes are in the same set, that is reference of two conflicting nodes is the same, we return false
                if(obj1[0]==obj2[0] && obj1[1]==obj2[1])
                    return false;
            }
        }
        
        return true;
        
    }
    
    private int[] find(int a, int[] parent)
    {
        int val=0;
        while(parent[a]!=a)
        {
            a = parent[a];
            if(val==0)
                val=1;
            else
                val=0;
        }    
        
        return new int[]{a,val};
    }
}

// class Solution
// {
//      public boolean possibleBipartition(int N, int[][] dislikes) 
//      {
//          List<List<Integer>> graph = new ArrayList();
//          int[] set = new int[N+1];
//          for(int i=0; i<=N; i++)
//          {
//              graph.add(new ArrayList());
//          }
         
//          for(int[] d : dislikes)
//          {
//              graph.get(d[0]).add(d[1]);
//              graph.get(d[1]).add(d[0]);
//          }
         
//          for(int i=0; i<=N; i++)
//          {
//              if(set[i]==0 && dfs(graph,1,i,set))
//                  return false;
//          }
//          return true;
//      }
    
//     private boolean dfs(List<List<Integer>> graph, int val, int i, int[] set)
//     {
//         //If value at i position in set is equal to val, it means same set for the conflicting values, hence we return false
//         if(set[i]==val)
//             return false;
//         //This specifies that they are added in two different sets and hence possible bipartition
//         if(set[i]==-val)
//             return true;
        
//         //Mark the set value for the current integer
//         set[i] = val;
        
//         //Traverse through all neighbours of graph and use dfs, return true if added in different sets
//         for(int g : graph.get(i))
//         {
//             if(dfs(graph,-val,g,set))
//                 return true;
//         }
        
//         return false;
//     }  
//}