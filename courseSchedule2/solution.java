/**
 * There are a total of n courses you have to take labelled from 0 to n - 1.
 * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
 * Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]. 
 */
class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        //We can use dfs or bfs to traverse through our graph
        
        List<List<Integer>> preReq = new ArrayList();
        
        for(int i=0; i<numCourses; i++)
        {
            preReq.add(i,new ArrayList<Integer>());
        }
        
        for(int i=0; i<prerequisites.length; i++)
        {
            preReq.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean[] taken = new boolean[numCourses];
        boolean[] waiting = new boolean[numCourses];
        
        Stack<Integer> orderedStack = new Stack();
        boolean cyclePresent = false;
        
        for(int i=0; i<numCourses; i++)
        {
            if(!cyclePresent && !taken[i])
            {
                cyclePresent = getCoursesUsingDFS(preReq,taken,waiting,i,orderedStack);
            }
        }
        
        if(cyclePresent)
           return new int[0];
        
        int[] toReturn = new int[numCourses];
        for(int i=numCourses-1; i>=0; i--)
        {
            toReturn[i] = orderedStack.pop();
        }
        
        return toReturn;
        
        //To use BFS, uncomment this and comment everything else 
//         int[] indegree = new int[numCourses];
//        // updateInDegree(indegree, preReq, prerequisites);
//         for(int i[] : prerequisites)
//         {
//             indegree[i[0]]++;
//             preReq.get(i[1]).add(i[0]);
//         }
        
//         return getCourseUsingBFS(indegree, preReq);
    }
    
    
    public boolean getCoursesUsingDFS(List<List<Integer>> preReq, boolean[] taken, boolean[] waiting, int course,                                           Stack<Integer> orderedStack)
    {
        if(waiting[course])
            return true;
        
        waiting[course] = true;
        
        List<Integer> currentCourses = preReq.get(course);
        boolean cycle = false;
        for(int i=0; i<currentCourses.size(); i++)
        {
         if(!cycle)
             cycle = getCoursesUsingDFS(preReq,taken,waiting,currentCourses.get(i),orderedStack);
        }
        
        if(!taken[course])
            orderedStack.push(course);
        
        waiting[course] = false;
        taken[course] = true;
        
        return cycle;

    }
    
    private int[] getCourseUsingBFS(int[] indegree, List<List<Integer>> preReq)
    {
        int[] orderedArray = new int[indegree.length];
        Queue<Integer> queue = new LinkedList();
        
        for(int i=0; i<indegree.length; i++)
        {
            if(indegree[i]==0)
            {
                queue.offer(i);
            }
        }
        
        System.out.println(indegree.length);
        
        int position=0;
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            
            orderedArray[position++] = current;
            
            for(int i : preReq.get(current))
            {
                indegree[i]--;
                if(indegree[i]==0)
                    queue.offer(i);
            }
            
        }
        
        System.out.println(position);
        if(position==indegree.length)
            return orderedArray;
        else
            return new int[0];
    
    }
    
}