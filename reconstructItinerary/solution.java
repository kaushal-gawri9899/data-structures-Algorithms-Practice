/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * Note:
 *  If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 *  All airports are represented by three capital letters (IATA code).
 *  You may assume all tickets form at least one valid itinerary.
 *  One must use all the tickets once and only once.
 *  
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 */
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        /*
        We can treat our departure and arrival aiports as connected nodes of a graph
        We are assuming it to be Eulerian paths. 
        We can implement it using simple iteration if we use a Stack
        */
        
        LinkedList<String> solution = new LinkedList();
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        
        for(List<String> curr : tickets)
        {
            if(!map.containsKey(curr.get(0)))
                map.put(curr.get(0), new PriorityQueue<String>());
            
            map.get(curr.get(0)).offer(curr.get(1));
        }
        
        Stack<String> stack = new Stack<>();
        
        stack.push("JFK");
        
        while(!stack.isEmpty())
        {
            String temp = stack.peek();
            
            if(map.containsKey(temp) && map.get(temp).size()>0)
            {
                stack.push(map.get(temp).poll());
            }
            else
            {
                solution.addFirst(stack.pop());
            }
            
        }
        
        return solution;
    }
}