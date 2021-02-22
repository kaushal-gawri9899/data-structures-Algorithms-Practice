/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Follow up:
 *   Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *   Could you do it in-place with O(1) extra space?
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 */
class Solution {
    
    public void rotate(int[] nums, int k)
    {
        //Without extra space
        //Say array has 1 2 3 4 5 and k = 2
        //Rotate array 5 4 3 2 1
        //Now rotate all elements after k elements : 5 4 1 2 3
        //Now rotate all elements till k elements : 4 5 1 2 3 
        // O(n) - 100% faster, O(1) space
        k=k%nums.length;
        int last = nums.length-1;
        reverseElements(nums,k,0,last);
        reverseElements(nums,k,k,last);
        reverseElements(nums,k,0,k-1);
    }
 
     private void reverseElements(int[] nums, int k, int start, int end)
     {
         while(start<end)
         {
             int temp = nums[start];
             nums[start] = nums[end];
             nums[end] = temp;
             start++;
             end--;
         }
     }
 
  public void rotateExtraSpace(int[] nums, int k){
     
     //Using extra space and O(n)
     int len = nums.length;
     int[] arr = new int[len];
     for(int i=0; i<len; i++)
     {
         arr[(i+k)%len] = nums[i];
     }
     
     for(int j=0; j<len; j++)
         nums[j] = arr[j];
     }
 
 public void rotateBruteForce(int[] nums, int k) {
     
     //Brute force solution, shift the elements right side for k times
     //O(n*k) complexity
     int temp, last;
     int len=nums.length;
     //Loop for k times to make k swaps
     while(k>0)
     {
         last = nums[len-1];
         //Iterate the array and swap the last element with j
         for(int j=0; j<nums.length; j++)
         {
             temp = nums[j];
             nums[j] = last;
             last = temp;
         }
         k--;
         }
      }
 
}