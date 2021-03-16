/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 * The replacement must be in place and use only constant extra memory.
 * 
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 */
class Solution {
    public void nextPermutation(int[] nums) {
        
        /*
        This is a tricky question but before that we should know what permutations are
        Once we have an idea about how permutations work, we need to understand the pattern that lets us maintain the lexicographically order
        
        Say, we have an input as 0 1 2 5 3 3 0
        We need to find the next lexicographically ordered permutation which should be 
        0 1 3 0 2 3 5
        
        Now, say we have 0 1 2 5 3 3 0
        
        Step 1 : First find the first value in our nums array after which our values are in non increasing sequence. That is we need to find the longest non increasing suffix
        
        In this case, the longest non increasing suffix would be 5 3 3 0
        The value in our nums array after which our values are in non increasing sequence is, 2 (Identify our pivot)
        
        Now, in our non increasing suffix 5 3 3 0 and for our pivot 2 we need to find the next greater element to our pivot value in the non increasing suffix. That is find the first value greater than our pivot 2 from the righmost side of our non increasing suffix. Here, it is 3 at index nums.length - 2
        0 1 2 5 3 "3" 0 (the one in quotes)
        
        Now, at this point we will swap our pivot value, i.e, 2 to our first greater value from the right side, which was 3 such that now our array becomes
        
        0 1 "3" 5 3 "2" 0
        
        The last part is to reverse our longest increasing subsequence (suffix) such that now the array becomes :
        
        0 1 3 0 2 3 5
        which is the desirable output
        
        */
        
        
        //First step is to find the pivot value after which we have our longest increasing subsequence
        int pivot = getPivot(nums);
        
        //We only swap with pivot if there exist a pivot and we don't directly need to reverse our array to return the lowest possible order
        if(pivot>=0)
        {
            int nextGreat = getIndexOfNextGreaterFromRight(nums, nums[pivot]);
            
            //Swap the nextGreat with our pivot;
            int temp = nums[pivot];
            nums[pivot] = nums[nextGreat];
            nums[nextGreat] = temp;
            
        }
        
        
        reverseSubsequence(nums, pivot+1);
        
    }
    
    private int getPivot(int[] nums)
    {
        for(int i=nums.length-1; i>0; i--)
        {
            if(nums[i-1]<nums[i])
                return i-1;
        }
        
        return -1;
    }
    
    private int getIndexOfNextGreaterFromRight(int[] nums, int current)
    {
        for(int i=nums.length-1; i>=0; i--)
        {
            if(nums[i]>current)
                return i;
        }
        return -1;
    }
    
   
    
    private void reverseSubsequence(int[] nums, int index)
    {
        int end = nums.length-1;
        
        while(index<end)
        {
            
            int temp = nums[index];
            nums[index] = nums[end];
            nums[end] = temp;
            
            index++;
            end--;
        }
    }
}