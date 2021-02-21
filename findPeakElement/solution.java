/** 
 * A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 */
class Solution {
    public int findPeakElement(int[] nums) {
        
        //Binary search works in this case even though nums isn't sorted because using it we are going for the rising slope if the element at mid is less than mid + 1. If we keep on going forward it states a rising slope and the element at the end would then be our peak
        //If element at mid + 1 is less, that determines that the slope will now be changed to go downhill, in this case, the answer would be the highest element before slope is falling
        int start = 0;
        int end = nums.length-1;
        
        while(start<end)
        {
            int mid = (start+end)/2;
            
            if(nums[mid]<nums[mid+1])
            {
                start = mid+1;
                
            }
            else 
            {
                end = mid;
            }
        }
        
        return start;

//Linear search
//         for(int i=0; i<nums.length; i++)
//         {
//             if(i!=0)
//             {
//                 if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
//                 {
//                     return i;
//                 }
//             }
//         }
        
//         return 0;
    }
}