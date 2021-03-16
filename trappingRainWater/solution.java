/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. 
 */
class Solution {
    public int trap(int[] height) {
        
        /*
        This is a very interesting problem which is asked a lot in the interviews
        The approach could be understood much better using the graph provided
        
        Approach : Given an array with [0,1,0,2,1,0,1,3,2,1,2,1]
        
        Now, if we see in the graph, we the total number of water to be stored would be 1 + 4 + 1 = 6 units of water
        
        We would be using preprocessing to store this in multiple auxilary array
        
        Most important point to note is water will only get deposited only if there's a block greater than current block either on its left or on its right
        For the boundary blocks there can be no water deposited as there won't be any blocks either on left or right
        
        Now, we will store the greater bar for our current bar on its left in an auxilary array 
        Input : [0,1,0,2,1,0,1,3,2,1,2,1]
        
        //We will start from index 0 and iterate over
        //For index 0, left[0] would be the values at heigh[0] itself
        //For value starting from 1 to n, search for Min value at index i-1 and index i, such that left[i] = Math.max(height[i], left[i-1]) (As, left[i-1] will store the earlier highest building on the left side whereas height[i] is the current height)
        left :  [0,1,1,2,2,2,2,3,3,3,3,3]
        
        //We will start from index n and iterate down
        //For index n, right[n] would be the value at height[n] itself
        //For value starting from n-1 to 0, search for Min value at index i+1 and index i, such that right[i] = Math.max(height[i], right[i+1]) (As, right[i+1] will store the earlier highest building on the right side whereas height[i] is the current height)
        right : [3,3,3,3,3,3,3,3,2,2,2,1]
        
        
        Now, to calculate the max water, the water to be stored at current index would be the max value between left and right and substract the height of building 
        
        i.e, formula = Water at index i = Math.min(left[i],right[i]) - height[i]
        
        
        The code is given below
        
        We can even modify this code to use only single pass and O(1) space
        */
        
        int n = height.length;
        
        if(n<=0)
            return 0;
        
        int[] left = new int[n];
        int[] right = new int[n];
    
        
        left[0] = height[0];
        
        for(int i=1; i<n; i++)
        {
            left[i] = Math.max(height[i],left[i-1]);
        }
        
        right[n-1] = height[n-1];
        
        for(int i=n-2; i>=0;i--)
        {
            right[i] = Math.max(right[i+1],height[i]);
        }
        
        int maxWater = 0;
        
        for(int i=0; i<n; i++)
        {
            maxWater+=( Math.min(left[i],right[i]) - height[i]);
        }
        
        return maxWater;
    }
}