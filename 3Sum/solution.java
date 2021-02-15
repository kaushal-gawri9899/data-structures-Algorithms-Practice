/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        
        //This is a very bad way to remove duplicacy by sorting the values in the list
        
        List<List<Integer> > toReturn = new ArrayList<>(); 
        
        Arrays.sort(nums);
        for(int i=0; i<nums.length -2; i++){
            
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            
            int lastElem = nums.length -1;
            int j = i+1;
            while(j<lastElem){
                
                if(j!=i+1 && nums[j]==nums[j-1] )
                {
                    j++;
                    continue;
                }
            
                if(lastElem!=nums.length-1 && nums[lastElem]==nums[lastElem+1])
                {
                    lastElem--;
                    continue;
                }
                
                int sum = nums[i] + nums[j] + nums[lastElem];
                
                if(sum==0)
                {
                    toReturn.add(Arrays.asList(nums[i],nums[j++], nums[lastElem]));
                    
                }
                else if(sum>0){
                    lastElem--;
                }
                else
                {
                    j++;
                }
            }
        }
        
        return toReturn;
        
 
    }
}


//Naive Solution
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
        
        
//       //Find all such triplets probably by, nCr 
        
//         //Use a hashmap to store the values
//         //Iterate ober the hashmap to get the sum
        
//         int sum = 0;
     
//         ArrayList<List<Integer> > toReturn = new ArrayList<List<Integer> >(); 
        
//         for(int i=0; i<nums.length -2; i++){
            
//             HashSet<Integer> sumMap = new HashSet<Integer>();
//             int currSum = sum - nums[i];
//             for(int j=i+1; j<nums.length; j++){
                
//                 if(sumMap.contains(currSum-nums[j]))
//                 {
//                     List<Integer> elements = new ArrayList<Integer>();
//                     elements.add(nums[i]);
//                     elements.add(nums[j]);
//                     elements.add(currSum-nums[j]);
                    
//                     Collections.sort(elements);
//                     if(!toReturn.contains(elements))
//                         toReturn.add(elements);
//                 }
                
//                 sumMap.add(nums[j]);
//             }
//         }
        
//         return toReturn;
            
//     }
// }
