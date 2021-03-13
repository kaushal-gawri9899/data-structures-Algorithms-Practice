/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
class Solution {
    public boolean canJump(int[] nums) {
        
        /*
             2 3 1 1 4
             
             We can make a max jump of two from 1st index, if we take a jump of 1 we will reach i = 1 and if we take a max jump of 2, we will reach i = 2. Now, jump of 1 is more benificial because when we're on index 1, we can take a jump of 3 and can finally reach our target
             In general :
             
             _ _ _ _ _ _ _ _ _
             i i+1     j     n-1
             
             To take a jump from i to n-1, we will need to search for an index j, that maximize the distance 
            
        */
        
        int len = nums.length; 
        int maxIndex = 0;
        int toReturn = 0;       
        
        for(int i=0; i<len; i++)
        {
            if(i<=toReturn)
            {
            toReturn = Math.max(i+nums[i], toReturn);
            maxIndex = i;
            }
        }
        
        if(maxIndex==len-1)
            return true;
        else
            return false;
    
    }
}