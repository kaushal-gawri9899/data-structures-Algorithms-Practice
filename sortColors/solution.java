/**
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
 */
class Solution {
    public void sortColors(int[] nums) {
        
        
        if(nums.length < 2)
            return;
        
        int right = nums.length-1;
        int left = 0;
        
        //Start the iterator from the left most element to the right most
        //Once two's are arranged at any rightmost position we don't need to replace it with other element 
        for(int i=left; i<=right; )
        {
            //If we encountered 0, we need to shift it to left
            //Swap nums[i] with nums[left] and increment pointers at left and i to move forward
            if(nums[i]==0)
            {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
                i++;
            }
            //If we encountered 0, we need to shift to right
            //Swap nums[i] with nums[right] and decrement the pointer at right side
            else if(nums[i]==2)
            {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
                
                
            }
            else
            {
                i++;
            }
                
        }
        
    }
    
  
  
}