/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
*/ 

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }
        
        
        for(int i=0; i<nums.length; i++){
            if(freq.get(nums[i])==1){
                return nums[i];
            }
        }
        return 0;
    }
}