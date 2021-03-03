/**
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 * Example 1:
 * Input: 
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 *
 */
class Solution {
    
    public int findCheapestPrice(int n , int[][] flights, int src, int dst, int K)
    {
        //Use the shortest path algorithm to find the shortest path from src to dst
        //There are multiple approaches ranging from using Djikstra with a PriorityQueue implementation to using a more optimized approach using Bellman Ford
        //Implementation using BellMan Ford
        
        int[] price = new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        price[src] = 0;
        
        for(int i=0; i<=K; i++)
        {
        int[] solution = Arrays.copyOf(price,n);
        for(int arr[] : flights)
        {
            int start = arr[0];
            int end = arr[1];
            int cost = arr[2];
            
            if(price[start]!=Integer.MAX_VALUE && solution[end]>price[start]+cost) 
            {
                solution[end] = Math.min(solution[end], price[start]+cost);
            }
            }
            price = solution;
        }
        
        if(price[dst]==Integer.MAX_VALUE)
            return -1;
        else
            return price[dst];
    }

//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    
//         //Use the shortest path algorithm to find the shortest path from src to dst
//         //There are multiple approaches ranging from using Djikstra with a PriorityQueue implementation to using a more optimized approach using Bellman Ford
           //Implementation using Djikstra's
//           
//         HashMap<Integer, List<int[]>> flight = new HashMap<>();
    
//         for(int[] i : flights)
//         {
//             if(!flight.containsKey(i[0]))
//                 flight.put(i[0], new ArrayList());
        
//             flight.get(i[0]).add(new int[] {i[1],i[2]});
//         }
    
//         PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//             @Override
//             public int compare(int[] a1, int[] a2)
//             {
//                 return Integer.compare(a1[0],a2[0]);
//             }
//         });
    
//         //src is current city or source, K+1 is the stop and 0 is the cost
//         queue.offer(new int[]{0,src,K+1});
    
//         while(!queue.isEmpty()){
        
//             int[] current = queue.poll();
//             int price = current[0];
//             int city = current[1];
//             int stop = current[2];
        
//             if(city==dst)
//                 return price;
        
//             if(stop>0)
//             {
//                 if(!flight.containsKey(city))
//                     continue;
            
//                 for(int[] nextStop : flight.get(city))
//                 {
//                     //our map flight contains an array consisting of the connecting stop at pos 0 and the cost at position 1
//                     queue.add(new int[]{price+nextStop[1], nextStop[0], stop-1});
//                 }
            
//             }
        
            
//         }
    
//         return -1;
    
    
//     }
}