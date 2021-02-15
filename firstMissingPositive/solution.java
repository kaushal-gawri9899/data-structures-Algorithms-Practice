/**
Given an unsorted integer array nums, find the smallest missing positive integer.

Input: nums = [1,2,0]
Output: 3

Input: nums = [3,4,-1,1]
Output: 2
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        
        boolean onePresent = false;
        int len = nums.length;
        for(int i=0; i<len; i++)
        {
            if(nums[i]==1)
                onePresent = true;
            else if(nums[i]<=0 || nums[i] > len)
                nums[i] = 1;
                
        }
        
        if(!onePresent)
            return 1;
        
        for(int i=0; i<len; i++)
        {
            int index = Math.abs(nums[i]) - 1;
            //Negating the value to confirm that element present
            if(nums[index]>0)
                nums[index] = -1*nums[index];
            
        }
        
        for(int i=0; i<len; i++)
        {
            //The index of first non negative number + 1 is the required answer
            if(nums[i]>0)
                return i+1;
        }
        
        
        //The last element such that all positive number in sequence present 
        return len+1;
    }
}