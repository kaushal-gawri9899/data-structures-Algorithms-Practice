/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 */
class Solution {
    
    /*Without using any extra space*/
    public List<Integer> findDisappearedNumbers(int[] nums) {        
           for(int i=0; i<nums.length; i++)
           {
               int val = 0;
               
               if(nums[i]>0)
                   val = nums[i];
               else 
                   val = -nums[i];
               
               if(nums[val-1]>0)
                   nums[val-1]*=-1;
           }
               
               //val = 4, nums[3] = -7
               //val = 3, nums[2] = -2
               //val =2, nums[1] = -1
               //val = 7, nums[6] = -3
               //val = 8, nums[8] = -1
               //val =2, nums[5] =2
               //val =3, nums[6] = 3
               //val =1, nums[0] = -4
         
            List<Integer> list = new ArrayList<>();
        
            for(int i=0; i<nums.length; i++)
            {
                if(nums[i]>0)
                    list.add(i+1);
            }
        
            return list;
    

    }
    
    
    //Fastest Solution using extra space to mark the elements
//     public List<Integer> findDisappearedNumbers(int[] nums) {
        
//         boolean[] marked = new boolean[nums.length+1];
        
//         for(int i=0; i<nums.length; i++)
//         {
//             marked[nums[i]] = true;
//         }
        
//         List<Integer> list = new ArrayList<>();
        
//         for(int i=1; i<=nums.length; i++)
//         {
//             if(!marked[i])
//                 list.add(i);
//         }
//         return list;
//     }
   
    //Slower as ContainsKey uses O(n)
/*    
    public List<Integer> findDisappearedNumbers(int[] nums)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++)
        {
            if(map.containsKey(i+1))
                continue;
            
            list.add(i+1);
            
        }
        
        return list;
    }
    */
}