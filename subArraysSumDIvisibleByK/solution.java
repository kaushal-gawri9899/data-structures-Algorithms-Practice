/**
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 * 
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
class Solution {
    
    public int subarraysDivByK(int[] A , int K)
    {
        int[] map = new int[K];
        map[0] = 1;
        int total=0;
        int count=0;
        
        for(int i : A)
        {
            total=(total+i)%K;
            
            if(total<0)
                total+=K;
            
            count+=map[total];
            map[total]++;
            
        }
        return count;
    }
  
//     public int subarraysDivByK(int[] A, int K)
//     {
//         HashMap<Integer, Integer> map = new HashMap<>();
      
//         map.put(0,1);
//         int currentSum = 0;
//         int count =0;
      
//         for(int i : A)
//         {
//             currentSum=(currentSum+i)%K;
          
//             //This handles the case when modulas sign returns a negative value
//             if(currentSum<0)
//                 currentSum+=K;
          
//             if(map.containsKey(currentSum))
//                 count+=map.get(currentSum);
          
//             map.put(currentSum, map.getOrDefault(currentSum,0)+1);
//         }
      
//         return count;
//     }
  
  /*  BRUTE FORCE APPROACH 
      Will give TLE for larger inputs*/
//     public int subarraysDivByK(int[] A, int K) {
      
//         int count=0;
//         for(int i=0; i<A.length; i++)
//         {
//             int total = A[i];
          
//             if(total%K==0)
//                 count++;
          
//             for(int j = i+1; j<A.length; j++)
//             {
//                 total+=A[j];
//                 if(total%K==0)
//                     count++;
//             }
//         }
      
//         return count;
//     }
}