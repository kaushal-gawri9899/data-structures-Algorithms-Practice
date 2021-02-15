/**
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
 */

class Solution {
    
   //  This is a slower solution as we are using hashset 
   // A faster way could be to use general backtrace by keeping a list of elements which are being added to calculate the sum
    
   
   /* 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        // List<List<Integer>> combineCandidates = new ArrayList<>();
        
        HashSet<List<Integer>> combineCandidates = new HashSet<>();
                
        backtrack(candidates, target, new ArrayList(), combineCandidates);
        
        return new ArrayList<>(combineCandidates);
    }
    
    private void backtrack(int[] members, int target, List<Integer> list,  HashSet<List<Integer>> combineCandidates)
    {
        if(target<0)
            return;
        if(target==0)
        {
            //Sorting the list before adding to the Set 
            //This will help remove duplicacy
            Collections.sort(list);
            combineCandidates.add(new ArrayList(list));
        }
        
        for(int candidate : members){
            
            //Shallow copy the elements of our array to a list to not let duplicate elements being added
            List<Integer> temp = new ArrayList<>(list);
            temp.add(candidate);
            backtrack(members, target - candidate, temp, combineCandidates);
        }
        
    }
    */
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> combineCandidates = new ArrayList();
        backtrace(candidates, 0, target, new ArrayList(), combineCandidates);
        return combineCandidates;
    }
    
    private void backtrace(int[] members, int start, int target, List<Integer> list, List<List<Integer>> combineCandidates) {
        
        if(target < 0)
            return;
        
        if(target == 0)
            combineCandidates.add(new ArrayList(list));
        
        for(int i = start; i < members.length; i++) {
            list.add(members[i]);
            backtrace(members, i, target - members[i], list, combineCandidates);
            list.remove(list.size() - 1);
        }
    }

}