class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[] solution = new int[n+1];
        
        Arrays.fill(solution,Integer.MAX_VALUE);
        
        solution[k] = 0;
        
        for(int i=1; i<n; i++)
        {
             for(int[] arr : times)
             {
                 int u = arr[0];
                 int v = arr[1];
                 int w = arr[2];
                 
                 if(solution[u]!=Integer.MAX_VALUE && solution[v]>solution[u]+w)
                 {
                     solution[v] = solution[u] + w;
                 }
             }
        }
        
        int maxTime = 0;
        
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