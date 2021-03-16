/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        /*
        Modified version of 3 sum problem
        */
        
        if(nums==null || nums.length < 3)
            return 0;
        
        int solution=nums[0]+nums[1]+nums[2];
        
        //Sort such that duplicate values are together
        //Can be skipped easily
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++)
        {
            //Skipping the duplicates
            if(i>0 && nums[i-1]==nums[i])
                continue;
            
            int start = i+1;
            int end = nums.length-1;
            
            while(start<end)
            {
                int closeSum = nums[i]+nums[start]+nums[end];
                
                if(Math.abs(target-closeSum) < Math.abs(target-solution))
                    solution = closeSum;
                
                if(target<closeSum)
                    end--;
                else if(target>closeSum)
                    start++;
                else
                    return target;
            }
        }
        
        return solution;
    }
}
