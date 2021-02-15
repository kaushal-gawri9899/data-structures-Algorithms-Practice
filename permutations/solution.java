/**
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        //Initial thoughts : Backtracking can help in generating all such permutations
        //Recursive approach that will be called for n times where n is the size of nums array
        
        List<List<Integer>> permutations = new ArrayList<>();
        
        permuteArray(nums, 0, new ArrayList(), permutations, new boolean[nums.length]);
        return permutations;

    }
    
    private void permuteArray(int[] members, int start, List<Integer> list,List<List<Integer>> permutations, boolean[] used)
    {
        
        if(list.size()==members.length)
        {
            permutations.add(new ArrayList<>(list));
            return;
            
        }
        
        for(int i=0; i<members.length; i++)
        {
            // If we have already added this element, we continue iterating to next one
            if(used[i])
                continue;
            // we mark the current elem
            used[i] = true;
            
            //add the element to our current permutation list
            list.add(members[i]);
            //recursively add the next element
            permuteArray(members, i, list, permutations,used);
            used[i] = false;
            //Remove last elem to backtrack;
            list.remove(list.size() -1);
        }
    }
    
    
}