/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2 
 */

class Solution {
    
    //O(n) worst case as few values would be reached at most twice (in while loop)
    public int minSubArrayLen(int target, int[] nums)
    {
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++)
        {
            sum+=nums[i];
            while(sum>=target)
            {
                
                min = Math.min(min,i+1-j);
                //At the point when sum becomes greater or equal to target, we start reducing it    values to find the first element of sub array which is then substracted to find the min length
                sum = sum - nums[j];
                j++;
            }
            
        }
        return (min!=Integer.MAX_VALUE) ? min : 0;
    }

    //O(n^2) worst case thus very slow
    public int minSubArrayLenBruteForce(int target, int[] nums) {
     
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            int sum =0;
            for(int j=i; j<nums.length; j++)
            {
                sum+=nums[j];
                if(sum>=target)
                {
                    //j-i+1 defines the number of elements that make the sum
                    //j is the index of last element of subarray, i is the index of first element of subarray and +1 because i starts from 0
                    min = Math.min(min,j-i+1);
                    break;
                }
            }
        }
        return (min!=Integer.MAX_VALUE) ? min:0;
    }
}