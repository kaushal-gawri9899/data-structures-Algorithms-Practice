/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 */
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       
        int maxTime = -1;
        int[] solution = new int[n+1];
        
        Arrays.fill(solution, Integer.MAX_VALUE);
        solution[k] = 0;
        
        // [2,1,1]  [2,3,1]  [3,4,1], n=4, k=2
        
        // max max 0 max max
        // max 1 0 max max 
        // max 1 0 1 max
        // max 1 0 1 2
        //now max would be solution[4] = 2
        for(int i=1; i<n; i++)
        {
            for(int[] array : times)
            {
                int source = array[0];
                int destination = array[1];
                int time = array[2];
                
                if(solution[source]!=Integer.MAX_VALUE && solution[source]+time < solution[destination]) 
                {
                    solution[destination] = solution[source] + time;
                }
            }
        }
        
        for(int i=1; i<=n; i++)
        {
            maxTime = Math.max(maxTime,solution[i]);
        }
        
        if(maxTime!=Integer.MAX_VALUE)
            return maxTime;
        else
            return -1;
    }
}
