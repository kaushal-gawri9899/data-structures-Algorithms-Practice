/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
 */


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
       
        int[] toReturn = {-1,-1};
//         toReturn[0]=-1;
//         toReturn[1] = -1;
        
        if(nums.length==0)
            return toReturn;
        
        int start = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target){
                toReturn[0] = i;
                start = i;
                break;
            }
        }

        if(toReturn[0]==-1)
            return toReturn;
        
        for(int l = nums.length-1; l>=0; l--){
            if(nums[l]==target)
            {
                toReturn[1] = l;
                break;
            }
        }
    
        
        return toReturn;
}
}

