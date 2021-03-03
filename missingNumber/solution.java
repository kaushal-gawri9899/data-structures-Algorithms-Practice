/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 */
class Solution {
    public int missingNumber(int[] nums) {
        
        //Total Sum for first n digits is n*(n+1)/2 where n >=1
           int expectedSum = (nums.length*(nums.length+1))/2;
           int actualSum =0;
           for(int i : nums)
           {
               actualSum+=i;
           }
        
           int missing = expectedSum-actualSum;
        
           return missing;
//         HashSet<Integer> set = new HashSet<>();
        
//         for(int i=0; i<nums.length; i++)
//         {
//             set.add(nums[i]);
//         }
        
//         for(int i=0; i<nums.length+1; i++)
//         {
//             if(!set.contains(i))
//                 return i;
//         }
//         return -1;
    }
}