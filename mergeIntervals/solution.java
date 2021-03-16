/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length;
        
        int[] startInterval = new int[n];
        int[] endInterval = new int[n];
        
        /* 1 2 8 15*/
        /* 3 6 10 18*/
        
        for(int i=0; i<n; i++)
        {
            startInterval[i] = intervals[i][0];
            endInterval[i] = intervals[i][1];
        }
        
        Arrays.sort(startInterval);
        Arrays.sort(endInterval);
        
        List<int[]> solution = new ArrayList<int[]>();
        int j=0;
        for(int i=0; i<n; i++)
        {
            if(i==n-1 || startInterval[i+1]>endInterval[i])
            {
                solution.add(new int[]{startInterval[j],endInterval[i]});
                j=i+1;
            }
        } 
        
        int[][] arr = new int[solution.size()][2];
        
        arr = solution.toArray(arr);
        
        return arr;
       
    }
}