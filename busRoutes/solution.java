/**
 * You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
 * For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
 * You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
 * Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
 * 
 * Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * Output: 2
 * Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 */
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        //This is a graph problem to be done using  bfs
        
        int row = routes.length;
        // int col = routes[0].length;
        
        //Use this hashmap to map the bus number (rows in routes) with all the stops
        HashMap<Integer, HashSet<Integer>> routeMap = new HashMap<>();
        
        if(source==target)
            return 0;
        
        //Mapping the bus number with all the stops for a particular bus number
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<routes[i].length; j++)
            {
                if(!routeMap.containsKey(routes[i][j]))
                {
                    routeMap.put(routes[i][j], new HashSet<>());
                }
                //Map the bus number with the routes[i][j] (all stops)
                routeMap.get(routes[i][j]).add(i);
            }
        }
        
        Queue<Integer> queue = new LinkedList();
        HashSet<Integer> visited = new HashSet<>();
        
        queue.offer(source);
        int result=0;
        
        while(!queue.isEmpty())
        {
            result++;
            
            int size = queue.size();
            
            for(int i=0; i<size; i++)
            {
                //Get the current bus stop which is the first in queue
                int curr = queue.poll();
                //Get all the stops passing through our current stop
                HashSet<Integer> buses = routeMap.get(curr);
                
                //For all the bus in our buses hashset(bus that pass through current stop)
                for(int bus : buses)
                {
                    //If we have already visited this stop, its a waste to do it again
                    if(visited.contains(bus))
                        continue;
                    
                    //Mark the stop visited
                    visited.add(bus);
                    
                    //Iterate in all the stops connecting through this bus
                    for(int j=0; j<routes[bus].length; j++)
                    {
                        //If current stop is the target, return
                        if(routes[bus][j]==target)
                            return result;
                        else
                            queue.offer(routes[bus][j]);
                    }
                }
            }
        }
        
        return -1;
        
        
    }
}
    