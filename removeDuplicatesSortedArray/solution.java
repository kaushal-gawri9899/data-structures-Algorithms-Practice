/**
Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
        
        //Calculate the length to be after removing the duplicate elements
        //Make sure to keep a pointer at which length the next non duplicate element is present
        
        int newlen = 0;
     
            
            for(int j=1; j<nums.length; j++){
                if(nums[j]!=nums[newlen]){
                    newlen++;
                    nums[newlen] = nums[j];
                }
     
            }

        return newlen+1;
    }
}