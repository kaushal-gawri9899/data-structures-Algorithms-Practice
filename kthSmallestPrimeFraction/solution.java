/**
 * You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique. You are also given an integer k.
 * For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
 * Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].
 *
 * Input: arr = [1,2,3,5], k = 3
 * Output: [2,5]
 * Explanation: The fractions to be considered in sorted order are:
 * 1/5, 1/3, 2/5, 1/2, 3/5, and 2/3.
 * The third fraction is 2/5. 
 */
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        /*
        We can proceed using binary search or using a priority queue to maintain the indices
        
        We will first add the indices of our values mapped with the last element in a array in our priority queue because
        
        1/5 < 1/3 < 1/2
        2/5 < 2/3
        3/5
        
        Now, the fraction of two values would be lowest compared to another if their the cross multiplication with other is the least, that is cross multiplication is least
        
        This is the order (Now, as j cannot be less than i, we don't consider the reverse values)
        */
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            
            @Override
            public int compare(int[] a, int[] b)
            {
                return arr[a[0]]*arr[b[1]] - arr[b[0]]*arr[a[1]];
            }
        });
        
        int n = arr.length;
        //We just need to worry about the first k
        for(int i=0; i<n-1 && i<k; i++)
        {
            pq.offer(new int[]{i,n-1});
        }
        
        for(int i=0; i<k-1; i++)
        {
            int[] top = pq.remove();
            
            //As we break out of the values once both i and j become equal
            if(top[1]-1 > top[0])
            {
                top[1]--;
                pq.add(top);
            }
        }
        
        return new int[]{arr[pq.peek()[0]], arr[pq.peek()[1]]};
        
    }
}