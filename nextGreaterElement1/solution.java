/**
 * You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, return -1 for this number.

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation:
For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
For number 1 in the first array, the next greater number for it in the second array is 3.
For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> countMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i : nums2)
        {
            //Only add when the value of i is greater than stack.peek(), we pop all the elements less than i and add in our map
            //Used to keep a decreasing order stack for an input like 3 2 1 5 where the next greater element for all 3,2 and 1 is 5
            while(!stack.isEmpty() && stack.peek()<i)
            {
             countMap.put(stack.pop(),i);   
            }
            stack.push(i);
        }
        
        
        for(int j=0; j<nums1.length; j++)
        {
            nums1[j] = countMap.getOrDefault(nums1[j],-1);
        }
        
        return nums1;
        
    }
    

    
}