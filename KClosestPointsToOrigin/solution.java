/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e, √(x1 - x2)2 + (y1 - y2)2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 *
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]]. 
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
           
            @Override
            public int compare(int[] l, int[] r)
            {
                return distanceFromOrigin(r) - distanceFromOrigin(l);
            }
        });
        
        for(int[] val : points)
        {
            pq.add(val);
            
            //As we only care about k closest, we only add the smallest k values in our priority queue
            if(pq.size()>k)
                pq.poll();
        }
        
        //After filling our priority queue, next step is to just fill the array
        
        int[][] closestPoints = new int[k][2];
        
        int i=0;
        while(i<k)
        {
            closestPoints[i] = pq.poll();
            i++;
        }
        
        return closestPoints;
        
    }
    
    public int distanceFromOrigin(int[] dis)
    {
        return dis[0]*dis[0] + dis[1]*dis[1];
    }
}