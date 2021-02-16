/**
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        
        //Return all the subsets of a given array
        //No repetition
        //Approach : Backtracking 
        
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
    
        generateSubSets(nums,0,list,subset);
       
        return subset;
    }
    
    
    private void generateSubSets(int[] nums, int index, List<Integer> list, List<List<Integer>> subset)
    {
      
        subset.add(new ArrayList<>(list));
        
        for(int i=index; i<nums.length; i++)
        {
        list.add(nums[i]);
        
        generateSubSets(nums,i+1,list,subset);
        
        //Signifies backtracking
        list.remove(list.size()-1);
        }
        
            
    }
}