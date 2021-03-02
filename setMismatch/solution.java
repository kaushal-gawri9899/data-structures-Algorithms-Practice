/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * You are given an integer array nums representing the data status of this set after the error.
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        
        for(int val : nums)
        {
            //Define the position for our nums array as Math.abs(val)-1 {-1 as index starts from zero while we have 1 to n}
            //If anytime the value is negative for val-1, {val-1 states the index for a val where val>=1 and val<=n}
            if(nums[Math.abs(val)-1]<0)
            {
                result[0] = Math.abs(val);
            }
            //Else we make the value negative
            else
            {
            nums[Math.abs(val)-1]*=-1;
            }
            
        }
        
        //Iterate again in array and once we have any value greater than 0, the missing value is the value of index+1
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]>0)
                result[1]=i+1;
        }
        
        return result;
        
        
     //   Using extra space
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int[] result = new int[2];
        
//         for(int i : nums)
//         {
//             //Adding the values in our map and increasing its count
//             map.put(i, map.getOrDefault(i,0)+1);
//         }
        
    
//         for(int i=1; i<=nums.length; i++)
//         {
//             if(map.containsKey(i))
//             {
//                 if(map.get(i)>1)
//                     result[0] = i;
//             }
//             else
//                 result[1] = i;
//         }
        
//         return result;
        
        
    }
}