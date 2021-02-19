class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> permutations = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        permuteHelper(nums,0,new ArrayList(), permutations, visited);
        
        return permutations;
    }
    
    private void permuteHelper(int[] nums, int start, List<Integer> list, List<List<Integer>> permutations, boolean[] visited)
    {
        
       
        if(list.size()==nums.length)
        {
            permutations.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0; i<nums.length; i++)
        {
            //We need to mark whatever element we are choosing to not let have permutations of repeting the elements
            
            if(visited[i])
                    continue;
        
            visited[i] = true;
            
            list.add(nums[i]);
            
            permuteHelper(nums,i,list,permutations,visited);
            
            visited[i] = false;
            
            //Backtrack
            list.remove(list.size()-1);
        }
    }
}
