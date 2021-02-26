class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //We can assume prerequisites to be like a graph datastructure
        //We can use a dfs approach
        //Create two different arrays for courses that could be taken and that are on waiting and mark them when visiting it
        
        boolean[] taken = new boolean[numCourses];
        boolean[] waiting = new boolean[numCourses];

        
        for(int i=0; i<numCourses; i++)
        {
            if(!canFinishHelper(prerequisites,taken,waiting,i))
            {
                return false;
            }
        }
        return true;
    }
    
    private boolean canFinishHelper(int[][] prerequisites, boolean[] taken, boolean[] waiting, int course)
    {
        if(taken[course])
            return true;
        
        if(waiting[course]) 
            return false;
        
        waiting[course] = true;
        
        for(int[] arr : prerequisites)
        {
            if(arr[0]==course)
            if(!canFinishHelper(prerequisites,taken,waiting,arr[1]))
                return false;
        }
        
        waiting[course]=false;
        
        taken[course]=true;
        
        return true;
    }
}