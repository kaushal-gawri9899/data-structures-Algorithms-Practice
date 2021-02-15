/**
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
Input: nums = [1,3,5,6], target = 2
Output: 1
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        
        //We can use binary search to search for the number and return the index
        //If number not found, we return the index value such that
        
        int len = 0;
        int end = nums.length - 1;
        
        while(len<end){
            int mid = len+(end-len)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target)
            {
                end = mid;
            }
            else{
                len = mid+1;
            }
        }
        
        return nums[len] < target ? len+1 : len;
    }
}
