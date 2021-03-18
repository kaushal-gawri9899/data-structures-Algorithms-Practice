/** 
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window. 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation: 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
/** Very Slow Solution */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        /*
        Sliding window problem, we will use a hashmap to store our windows and a variable max which will be returned later on. This max will hold the maximum value in our window
        */
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        int[] solution = new int[nums.length-k+1];
        
        for(int i=0; i<k; i++)
        {
            map.put(nums[i], i);
        }
        
        solution[0] = map.lastKey();
        
        for(int i=0; i<nums.length-k; i++)
        {
            
            if(map.get(nums[i])==i)
                map.remove(nums[i]);
            
            
            map.put(nums[i+k], i+k);
            
            solution[i+1] = map.lastKey();
        }
        
        return solution;
    }
}

