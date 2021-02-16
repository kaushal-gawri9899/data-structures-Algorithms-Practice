/**
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
         List<List<Integer>> subset = new ArrayList<>();
        
         //Make sure to sort our nums array else for larger inputs duplicates will persist
         Arrays.sort(nums);
         getSubsetList(nums,0,new ArrayList<Integer>(),subset);
        
        return subset;
         
    }
    
    private void getSubsetList(int[] nums, int index, List<Integer> list, List<List<Integer>> subset)
    {
        
        subset.add(new ArrayList<>(list));
        
        for(int i=index; i<nums.length; i++)
        {
          
            if(i-1>=index && nums[i]==nums[i-1])
                continue;
            
              //This approach will add all the subsets which can include duplicates, so provide a check that skips the  duplicates
            list.add(nums[i]);
            getSubsetList(nums,i+1,list,subset);
            list.remove(list.size()-1);        
        }
    }
}