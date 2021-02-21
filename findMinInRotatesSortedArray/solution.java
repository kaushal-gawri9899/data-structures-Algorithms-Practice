/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.

 *  Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *  Given the sorted rotated array nums, return the minimum element of this array.
 * 
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 */
class Solution {
    public int findMin(int[] nums) {
        
        //Basic approach to use binary search to search for values less then nums[0]
        
      
        int start = 0;
        int end = nums.length-1;
        
        if(nums.length==1)
            return nums[0];
        
        if(nums[end]>nums[start])
            return nums[0];
        
        while(start<end)
        {
            //to protect overflow
            int mid = start + (end-start)/2;
    
            //If middle element is lesser than its previous, smallest
            if(mid>0 && nums[mid]<nums[mid-1])
            {
                return nums[mid];
            }
        
            if(nums[start]<=nums[mid] && nums[mid]>nums[end])
            {
                start = mid+1;
            }
            else
                end = mid-1;
        }
        
        return nums[start];
    }
}