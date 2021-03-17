/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        /*
        This problem is similar to merge intervals
        First we create multiple startInterval and endInterval
        We iterate through our intervals array and add the starting and ending intervals in both of are array
        We also add newInterval[0] in startInterval array and newInterval[1] in endInterval array
        
        After this, the procedure is similar to just merging our start and end interval array using two pointers
        
        */
        int n = intervals.length;
        
        int[] startInterval = new int[n+1];
        int[] endInterval = new int[n+1];
        
        /*
        For example [[1,3],[6,9]] and [2,5]
        
        startInterval = [1,2,6]
        endInterval = [3,5,9]

        Now using two pointer approach, once value at startInterval at position i+1 is greater than endInterval at position i, we add it to our list (add startInterval[j] and endInterval[i])
        */
        for(int i=0; i<n; i++)
        {
            startInterval[i] = intervals[i][0];
            endInterval[i] = intervals[i][1];
        }
        
        startInterval[n] = newInterval[0];
        endInterval[n] = newInterval[1];
        
        Arrays.sort(startInterval);
        Arrays.sort(endInterval);
        
        List<int[]> solution = new ArrayList<int[]>();
        
        int j = 0;
        
        for(int i=0; i<n+1; i++)
        {
            if(i==n || startInterval[i+1]>endInterval[i])
            {
                solution.add(new int[]{startInterval[j], endInterval[i]});
                j=i+1;
            }
            
        }
        
        int[][] arr = new int[solution.size()][2];
        
        arr = solution.toArray(arr);
        
        return arr;
        
        
    }
    
    //Without extra space
//     class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         int start = newInterval[0];
//         int end = newInterval[1];
//         List<int[]> list = new ArrayList<>();
//         for (int[]interval : intervals) {
//             int curStart = interval[0];
//             int curEnd = interval[1];
//             if (curEnd < start) {
//                 list.add(new int[]{curStart, curEnd});
//             } else if (curStart > end) {
//                 list.add(new int[]{start, end});
//                 start = curStart;
//                 end = curEnd;
//             } else {
//                 start = Math.min(start, curStart);
//                 end = Math.max(end, curEnd);
//             }  
//         }
//         list.add(new int[]{start, end});
//         int[][] res = new int[list.size()][2];
//         for (int i = 0; i < list.size(); i++) {
//             res[i][0] = list.get(i)[0];
//             res[i][1] = list.get(i)[1];
//         }
//         return res;
//     }      
// }
}