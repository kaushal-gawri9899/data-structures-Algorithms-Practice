/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * 
 * Input: nums = [3,2,3]
 * Output: [3]
 */
class Solution
{
    public List<Integer> majorityElement(int[] nums) {
        
        /*The idea is to use Boyer Moore algorithm
          The approach is to initialize our top 2 occuring values and initialize there count as well. Increase the count for both the numbers if encountered, if at any point the count of any of the number becomes zero, change our value to this current value and increase the count again
          Else, in the end we just reduce both the counters
          Now, this will ensure that we get our top 2 occuring values
          
          Through this way, we are able to make triplets of elements(with no duplicate value as it is considered as candidate itself) and the elements left outside of our triplets would then be the majority elements
          
          Also, 
        */
        
        List<Integer> solution = new ArrayList();
        
        int num1 = -1, num2 = -1;
        int count1 =0, count2 = 0;
        
        for(int c : nums)
        {
            if(c==num1)
                count1++;
            
            else if(c==num2)
                count2++;
            
            else if(count1==0)
            {
                num1 = c;
                count1++;
            }
            else if(count2==0)
            {
                num2 = c;
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        
        count1=0;
        count2=0;
        
        for(int val : nums)
        {
            if(val==num1)
                count1++;
            else if(val==num2)
                count2++;
        }
        
        if(count1>nums.length/3)
            solution.add(num1);
        if(count2>nums.length/3)
            solution.add(num2);
        
        return solution;
    }
}

// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
        
//         HashMap<Integer, Integer> map = new HashMap<>();
        
//         for(int i : nums)
//         {
//             map.put(i, map.getOrDefault(i,0)+1);
//         }
        
//         List<Integer> list = new ArrayList();
//         for(int i : nums)
//         {
//             if(map.get(i)>(nums.length/3) && !list.contains(i))
//                 list.add(i);  
//         }
        
//         return list;
//     }
// }