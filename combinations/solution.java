/**
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

You may return the answer in any order.

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        //Fill an array with integers from 1 to n
        // backtrack to get all subsets of length = k
        // int[] nums = new int[n];
        // for(int i=1; i<=n; i++)
        // {
        //     nums[i-1] = i;
        // }
        
        List<List<Integer>> subset = new ArrayList<>();
        getSubSetsOfLengthK(n,k,1,new ArrayList<Integer>(), subset);
        
        return subset;
    }
    
    //Better approach is to not use extra space and iterate till n-k+1
    //reduces the time by a lot
    private void getSubSetsOfLengthK(int n, int k, int index, List<Integer> list,List<List<Integer>> subset )
    {
        
        if(k==0)
        {
        subset.add(new ArrayList<>(list));
        return;
        }
        
        for(int i=index; i<=n-k+1; i++)
        {
            list.add(i);
            
            getSubSetsOfLengthK(n,k-1,i+1,list,subset);
            
            list.remove(list.size()-1);
        }
    }
}