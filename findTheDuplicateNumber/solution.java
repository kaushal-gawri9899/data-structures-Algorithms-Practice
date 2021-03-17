/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * 
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 */
class Solution {
    
    
    /*O(n) time and O(1) space*/
    public int findDuplicate(int[] nums)
    {
        int slow=0;
        int fast=0;
        
        //Similar to detecting a cycle in linkedlist
        //We break on finding the middle of array
        while(true)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
            
            if(slow==fast)
                break;
        }
        
        int search = 0;
        
        while(true)
        {
            slow = nums[slow];
            search = nums[search];
            
            if(slow==search)
                return slow;
        }

    }

/*Using binary search
    O(nlogn) time and O(1) space
*/

//     public int findDuplicate(int[] nums)
//     {
//         int start = 0;
//         int end = nums.length-1;
    
//         while(start<end)
//         {
//             int mid = start+(end-start)/2;
        
//             int c=0;
        
//             for(int n : nums)
//             {
//                 if(n<=mid)
//                     c++;
//             }
        
//             if(c>mid)
//                 end = mid;
//             else
//                 start = mid+1;
        
//         }
    
//         return start;
//     }



/*O(n) time and O(1) space*/
//     public int findDuplicate(int[] nums)
//     {
    
//         for(int i=0; i<nums.length; i++)
//         {
//             int index = Math.abs(nums[i])-1;
        
//             //Mark the current value visited
//             nums[index]*=-1;
        
//             if(nums[index]>0)
//                 return Math.abs(nums[i]);
//         }
//         return -1;
//     }

/*Two pass solution with O(n) space and O(n) time, better than 100%*/
//     public int findDuplicate(int[] nums) {
    
//         int[] count = new int[nums.length+1];
    
//         for(int i=0; i<nums.length; i++)
//         {
//             count[nums[i]]++;

//         }
    
//         for(int i=1; i<count.length; i++)
//         {
//             if(count[i]>1)
//                 return i;
//         }
//         return -1;
//     }
}