class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> solution = new ArrayList();
        
        //Helpful in removing duplicacy as we will not select similar adjacent elements
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++)
        {
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            
            int endElem = nums.length-1;
            int j = i+1;
            while(j<endElem)
            {
                //When it is not the first two elements
                if(j!=i+1 && nums[j]==nums[j-1])
                {
                    j++;
                    continue;
                }
                
                if(endElem!=nums.length-1 && nums[endElem]==nums[endElem+1])
                {
                    endElem--;
                    continue;
                }
                int sum = nums[i]+nums[j]+nums[endElem];
                
                if(sum==0)
                {
                    solution.add(Arrays.asList(nums[i],nums[j],nums[endElem]));
                    j++;
                }
                else if(sum>0)
                {
                    endElem--;
                }
                else
                {
                    j++;
                }
            }
        }
        return solution;
    }
    
 
}