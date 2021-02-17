/**
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Input: [1,2,3,1]
Output: true
 */


class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> duplicate = new HashSet<>(nums.length);
        
        for(int val : nums)
        {
            //checks if there is a same value
            if(!duplicate.add(val))
                return true;
        }
        
        return false;
        
//         Arrays.sort(nums);
//         for(int i=0; i<nums.length; i++)
//         {
//             if(nums[i]==nums[i+1])
//                 return false;
//         }
        
//         return true;
    }
}