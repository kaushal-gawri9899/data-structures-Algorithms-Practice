/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 */
class Solution {
    public int maxProduct(int[] nums) {
        
        int subProduct = 1;
        int result = Integer.MIN_VALUE;
        
        //The first case is either to include the first element and exclude the last of our subarray when both first and last element are negative
        //In this case we are supposed to include till the first non zero element just before the last negative element
        for(int i=0; i<nums.length; i++)
        {
            subProduct=subProduct*nums[i];
            result = Math.max(result,subProduct);
            //We need to take care of the case when we meet a zero, as it will update are subProduct to zero, so once subProduct is changed to 0, we need to change it back to 1 for subsequent multiplications
            if(subProduct==0)
                subProduct=1;
        }
        
        subProduct=1;
        //The second case is either to include the last element and exclude the first of our subarray when both first and last element are negative
        //In this case we are supposed to include till the first non zero element just after the first negative element
        for(int i=nums.length-1; i>=0; i--)
        {
            subProduct=subProduct*nums[i];
            result=Math.max(result,subProduct);
             if(subProduct==0)
                subProduct=1;
        }
        
        return result;
    }
}