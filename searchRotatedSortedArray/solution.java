/**
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4 
*/

class Solution {
    public int search(int[] nums, int target) {
        
//         int toReturn = -1;
        
//         if(nums.length==0)
//             return toReturn;
        
//         for(int i=0; i<nums.length; i++){
//             if(nums[i]==target){
//                 toReturn = i;
//             }
        
//         }
        
//         return toReturn;
        
        //More optimized using binary search
        
        int end = nums.length -1;
        int start = 0;
        int toReturn = -1;
    
        while(start<=end)
        {
            int mid = (start+end)/2;
            
            if(nums[mid]==target)
            {
                toReturn = mid;
                return toReturn;
            }
            
           
            //Check where it is sorted, break at pivot
            
            //checks if left hand side of pivot is sorted
            if(nums[start]<=nums[mid])
            {
                if(target>=nums[start] && target<nums[mid])
                    end = mid-1;
                else
                    start = mid + 1;
                
            }
            //checks if right hand side of pivot is sorted
            else{
                if(target>nums[mid] && target<=nums[end])
                start = mid+1;
                else
                    end = mid-1;
            }
    
            
        }
        return toReturn;
}
}