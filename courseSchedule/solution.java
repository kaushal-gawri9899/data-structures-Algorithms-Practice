/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //The approach is to use dfs on our graph
        // have two arrays describing the courses that can be taken and those that can not be for now
        
        boolean[] canTake = new boolean[numCourses];
        boolean[] waiting = new boolean[numCourses];
        
        
        for(int i=0; i<numCourses; i++)
        {
            if(!canFinishHelper(i,prerequisites,canTake,waiting))
                return false;
        }
        
        return true;
    }
    
    public boolean canFinishHelper(int course, int[][] prerequisites, boolean[] canTake, boolean[] waiting)
    {   
        //Base case if the course can be taken, return true
        if(canTake[course])
            return true;
        
        //If the course cannot be taken and is in waiting
        if(waiting[course])
            return false;
        
        //Mark course to be in waiting until otherwise
        waiting[course]=true;
        
        //Iterate in prerequisites array for all the pairs of prerequisites
        for(int[] req : prerequisites)
        {
            //Check if the course to be taken in each index of prerequisites array is the given course
            if(req[0]==course)
            {
                //check for the prerequisite of the course in recursive manner
                //If anytime any of the course returns false, we move out 
                if(!canFinishHelper(req[1],prerequisites,canTake,waiting)){
                    return false;
                }
            }
        }
    
        //Backtrack
        waiting[course]=false;
                   
        canTake[course]=true;
        
        //If we reach here, it specifies all courses can be taken
        return true;
    
    }
}