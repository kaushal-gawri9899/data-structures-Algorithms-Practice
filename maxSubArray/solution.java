/**
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        
        //AIM:Make sure that the problem asks us to find the conitiguous subarray with max sum
        
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int max = arr[0];
        for(int i=1; i<nums.length; i++){
            
            if(arr[i-1]>0){
                arr[i] = arr[i-1] + nums[i];
            }
            else{
                arr[i] = nums[i];
            }
            
            max = Math.max(max,arr[i]);
        }
        
        
    
        return max;
    }
}