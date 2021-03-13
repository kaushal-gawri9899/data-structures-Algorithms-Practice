/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        
        /*
        0 3 7 2 5 8 4 6 0 1
        
        0 1    0 1 2  ......................... 0 1 2 3 4 5 6 7 8 
        1 2    1 2 3
        2 3    3 4 5
        3 4    4 5 6
        4 5    5 6 7
        5 6    6 7 8
        6 7    
        7 8
        
        
        We need to return the length of maximum subset such that all the numbers in our subset is consecutive. 
        */
        
        // if(nums.length==1)
        // return 1;
        
        Set<Integer> set = new HashSet<>();
        
        /*
        Set : 100 
        Set : 4
        Set : 200
        Set : 1
        Set : 3
        Set : 2
        */
        
        for(int i : nums)
        {
            set.add(i);
        }
        
        int maxLen = 0;
        
        for(int i : nums)
        {
            //If the value less than current value is present in our set
            
            if(!set.contains(i-1))
            {
                //We need to now check for next value (that is right side value which is i+1)
                int next = i + 1;
                
                //We check if the next value is present in our set and we increase the value on each encounter
                //The loop will break out when the next won't be present anymore in our set
                //So the length of our substring would be the difference between the next value and the current value
                //For example, 100, 4, 200, 1 , 3 , 2, we check of 99 is present in set for first num. False
                //Now we check if 3 is present in set, which is true, thus we increment the value and check if 4 is present in set. As it is also true, we increment again and check if 5 is present. As it is false, we terminate the while loop and Thus length of our subsequence would have i = 4 and next = 5 (which is 5 - 4). Similarly say we had , 4 5 6 7 8 as our subsequence, in that case i would have been 4 and next would have been 3. Thus, we get next = 3+1 , as 4 is present, next = 4+1, as 5 is present next = 5+1, as 6 is present next = 6+1, as 7 is present next = 7+1, as 8 is present, next = 8+1 = 9 which isn't present and loop is terminated. Now, we do 9 - 4  = 5 as our length 
                while(set.contains(next))
                {
                    next++;
                }
                
                maxLen = Math.max(maxLen, next - i);
                
            }
            
          
        }
        
        
        
        return maxLen;
    }
}