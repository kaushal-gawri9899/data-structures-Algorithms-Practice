/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 * 
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
class Solution {
    public int jump(int[] nums) {
        
        /*
             2 3 1 1 4
             
             We can make a max jump of two from 1st index, if we take a jump of 1 we will reach i = 1 and if we take a max jump of 2, we will reach i = 2. Now, jump of 1 is more benificial because when we're on index 1, we can take a jump of 3 and can finally reach our target
             In general :
             
             _ _ _ _ _ _ _ _ _
             i i+1     j     n-1
             
             To take a jump from i to n-1, we will need to search for an index j, that maximize the distance 
             We need to minimize the jump and hence we can use a dp solution
            
        */
        
        int len = nums.length; 
        int maxIndex = nums[0];
        int toReturn = nums[0];
        int count = 1;
        
        if(len<2)
            return 0;
        
        for(int i=1; i<len; i++)
        {
            if(i > maxIndex)
            {
                count++;
                maxIndex=toReturn;
            }
            toReturn = Math.max(i+nums[i], toReturn);
        }
        
        return count;
        
//            int[] dp = new int[len];
//            Arrays.fill(dp,Integer.MAX_VALUE-1);
        
//            dp[len-1] = 0;
        
//            for(int i = len-2; i>=0; i--)
//            {
//                for(int j=i+1; j<=i+nums[i] && j<len; j++)
//                {
//                    dp[i] = Math.min(dp[i], 1+dp[j]);
//                }
//            }
        
//            return dp[0];
        
    }
}