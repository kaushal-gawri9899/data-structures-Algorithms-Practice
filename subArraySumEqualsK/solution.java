/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 * 
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * 
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
class Solution {
    
    public int subarraySum(int[] nums, int k)
    {
        HashMap<Integer, Integer> beforeSum = new HashMap<>();
        
        beforeSum.put(0,1);
        int count = 0;
        int currentSum = 0;
        
        for(int i : nums)
        {
            currentSum+=i;
            
            if(beforeSum.containsKey(currentSum-k))
                count+=beforeSum.get(currentSum-k);
            
            beforeSum.put(currentSum, beforeSum.getOrDefault(currentSum,0)+1);
        }
        
        return count;
    }
    
    /*Brute Force Approach*/
//     public int subarraySum(int[] nums, int k) {
        
//         int sum=0;
        
//         for(int i=0; i<nums.length; i++)
//         {
//             int total=nums[i];
//             if(nums[i]==k)
//                 sum++;
            
//             for(int j = i+1; j<nums.length; j++)
//             {
//                 total+=nums[j];
//                 if(total==k)
//                     sum++;
//             }
                
//         }
        
//         return sum;
//     }
}