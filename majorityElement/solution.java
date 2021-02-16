/**
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 */
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    
    // This first keep a track of the first element in the array by considering it as the majority element
    // It then checks if the current element is similar to our majority element, if so it increases its count by 1 and if the element is different the fcount is reduced by -1
    // now once we get to another element other than the then majority element, we check if count is zero, if it isn't the majority element still remains same and the count is reduced, once we hit count to be zero, the new element is made the majority element
    // This element is then returned at the end
    
    // Known as "Boyer-Moore Voting Algorithm"
       public int majorityElement(int[] nums)
       {
           int count = 0;
           
           Integer value = null;
           
           for(int i : nums)
           {
               if(count==0)
                   value = i;
               
               if(i == value)
                   count+=1;
               else
                   count+=-1;
           }
           
           return value;
       }



    
//     public int majorityElement(int[] nums) {
     
//         HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
//         int n = nums.length-1;
        
//         for(int i : nums)
//         {
//             if(frequency.containsKey(i))
//             {
//                 frequency.put(i, frequency.get(i)+1);
//             }
//             else
//             {
//                 frequency.put(i,1);
//             }
//         }
        
        
//         for(Entry<Integer,Integer> entry : frequency.entrySet()){
            
//             if(entry.getValue()>n/2)
//                 return entry.getKey();
//         }
        
//         return 0;
//     }

// It uses O(n) time complexity and O(n) space complexity
}